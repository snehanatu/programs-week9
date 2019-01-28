DeckOfCards deckOfCards = new DeckOfCards();
Card firstUserCard = deckOfCards.getCard();
Card secondUserCard = deckOfCards.getCard();

println ("User's cards are: ["+firstUserCard.toString()+"] and ["+secondUserCard.toString()+"]");

BlackJackHand userHand = new BlackJackHand(firstUserCard, secondUserCard);
println "User hand: " + userHand.sumOfCards;

Card firstDealerCard = deckOfCards.getCard();
Card secondDealerCard = deckOfCards.getCard();
BlackJackHand dealerHand = new BlackJackHand(firstDealerCard, secondDealerCard);
println ("Dealer's face up card is: ["+firstDealerCard.toString()+"]");

if (userHand.sumOfCards == 21) {
	println "Valid Blackjack Hand! User wins!!"
} else {
	
	while (userHand.sumOfCards <= 21) {
		def response = System.console().readLine 'Do you want to get another card or quit? Enter [c] for card and [any key] to quit: '
		if (response.equals("c")) {
			Card nextUserCard = deckOfCards.getCard();
			println ("User's next card is: ["+nextUserCard.toString()+"]");
			userHand.addCard(nextUserCard);
			println "User hand: " + userHand.sumOfCards;
			
		} else {
			break;
		}
	}
	
	if (userHand.sumOfCards > 21) {
		println "User busted!!";
	} else {
		println ("Dealer's second card is: ["+secondDealerCard.toString()+"]");
		println "Dealer hand: " + dealerHand.sumOfCards;
		if (userHand.sumOfCards > dealerHand.sumOfCards) {
			println "User wins!!"
		} else {
			println "Dealer wins!!"
		}
	}
}


class BlackJackHand {
	List cards = new ArrayList();
	private int sumOfCards = 0;
	
	BlackJackHand(Card firstCard, Card secondCard){
		this.cards.add(firstCard);
		this.cards.add(secondCard);
		this.sumOfCards = firstCard.value + secondCard.value;
	}
	
	void addCard(Card card) {
		this.cards.add(card);
		this.sumOfCards += card.value;
	}
}

class DeckOfCards {
	private List deck = new ArrayList();

	DeckOfCards() {
		for(int i = 0; i < Card.SUITS.length; i++) {
			for(int j=2; j<=10; j++) {
				deck.add(new Card(Card.SUITS[i], j));
			}
			deck.add(new Card(Card.SUITS[i], 11, "ACE"));
			deck.add(new Card(Card.SUITS[i], 10, "JACK"));
			deck.add(new Card(Card.SUITS[i], 10, "QUEEN"));
			deck.add(new Card(Card.SUITS[i], 10, "KING"));
		}
		Collections.shuffle(deck);
	}
	
	Card getCard() {
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}
}

class Card{
	static final String[] SUITS = ["Hearts", "Clubs", "Spades", "Diamonds"];

	String suitName;
	int value;
	String cardName;

	Card(String suitName, int value){
		this.suitName = suitName;
		this.value = value;
		this.cardName = String.valueOf(value);
	}

	Card(String suitName, int value, String cardName){
		this.suitName = suitName;
		this.value = value;
		this.cardName = cardName;
	}

	String toString() {
		return suitName+":"+cardName;
	}
}
