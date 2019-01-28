$number = Read-Host -Prompt "Enter A Number: "
$result = (($number/10)+1)*10
Write-Output "The rounding up of number to the next 10 : $result"
$myfavword = "Hello"
$yourword = Read-Host -Prompt "Enter your word"
Write-Output "You Entered:  $yourword"
while ($myfavword -ne $yourword){
    $yourword = Read-Host -Prompt  "Our Words don't match , Please Enter Your Word Again : "
    Write-Output "You Entered:  $yourword"
}
Write-Output "Our Words Match "