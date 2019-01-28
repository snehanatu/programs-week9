# !/bin/bash
echo "Enter A Number"
read number
result=$[($number/10 + 1)*10]
echo "The number rounding up to next higher multiple of 10 : $result"  
myfavword=Hello
echo "Enter your favorite word"
read yourword
echo "You entered : $yourword "
while [ $myfavword != $yourword ]
do
echo "Our Favorite Words are not same,Please Enter your word again: !!"
read yourword
done
echo "We have same Favorite Words"

