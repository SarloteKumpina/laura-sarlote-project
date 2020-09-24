# laura-sarlote-project
Laura and Sarlote project

Description

Create a game:

Create class Utils, add property numbers which is of type array with whole numbers.
Create default constructor which initializes "numbers" to a new empty array of size 4.
Make sure property "numbers" is not accessible directly from other class (it has to be encapsulated).
Create method "createArray" for adding elements to the numbers (this method should be encapsulated).
Create method "showResult" for showing to the user how many Cow and Bull guesses are correct (this method should be encapsulated).


Create class "CowsAndBullsGame". Inside this class generate 4 separate whole random numbers from 1-9 (encapsulate them as private).
Make sure that each of the 4 numbers are different.
Put these 4 numbers in array.
Creates a new instance of "Utils" with default constructor.
By using scanner, ask user to input 4 whole different numbers.
Check if the input is valid, if not return "Not valid input, please try again."
By using method "createArray" put these 4 numbers in array.
Compare users arrays each position to the random array (using for loop) - counting Bulls.
Compare if users numbers are in any other position in the random array (using for into for loop) - counting Cows.M
Make sure that user has 10 guesses and inform user how many guesses are left.
Make sure that when users guess is correct, the program congratulates the user and exit.
If the user uses all guesses and did not guess the correct number, the output should be as follows: "0 - Bulls, 2 - Cows (0 guesses left). Sorry, you lost!"

1)
Example input: "Please enter 4 digit number: ":
                1234
Example output:
                1 - Bulls, 2 - Cows (9 guesses left).

2)
Example input: "Please enter 4 digit number: ":
                a123
Example output:
                "Not valid input, please try again."
