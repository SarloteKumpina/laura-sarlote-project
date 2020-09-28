# laura-sarlote-project

#### Create a game **"Cows and bulls"**

1. Create a class "Utils" and:

    a) create a method "generateNumber" which generates random number with 4 digits where each digit is different.
The method must return int array;  
b) create a method "countBulls" which counts all digits that are placed in the right place in the random number at each guess;
The method must return int;  
c) create a method "countCows" which counts all digits that are somewhere in the random number, but are not in the right place;
The method must return int;  
d) create a method "printTable" which prints a new table after every valid input guess including all the previous guesses.
The method should print following (this is just an example for users input and expected outcome for Bulls and Cows count):

    | Your guess | Bulls | Cows | Attempts left |
    |:----------:|:-----:|:----:|:-------------:|
    |    1234    |   0   |   3  |       9       |
    |    5678    |   0   |   1  |       8       |
    
2. Create a class "CowsAndBullsGame" with main method for creating the game and:

    a) import Scanner for users input;  
b) create a variable "numbersOnly" with datatype String;  
c) create a variable "userGuessCount" with datatype int and assign value - 10 to it;  
d) create a variable "bullsCount" with datatype int;  
e) create a variable "cowsCount" with datatype int;  
f) create a variable "playAgain" with datatype String;  
g) create two-dimensional array variable "table" with datatype String;  
h) print a text for beginning of the game as follows:

    _**Game "Cows & bulls"**_

    _**Try to guess 4 different digit number (secret number).
Start the game by entering 4 digits from 0 to 9.
If some of your digits will be in the right place of the secret number, you will get Bulls.
If some of your digits will be in the secret number, but not in the right place, you will get Cows.
You have 10 guesses! Good luck! :)**_

   i) use do while loop for creating the game:
    - call the method generateNumber for generating the random number for user to guess;
    - ask user to enter his/her guess and accept first 4 digits from users input as guess;
    - if user entered less than 4 or more than 4 digits, output following message and let user guess again:

      _**Incorrect input. Please enter 4 digits!**_

    - create an array variable "userNumber" with datatype int;
    - store each digit from users input into the array "userNumber";
    - assign a value to "bullsCount" by calling the method "countBulls";
    - assign a value to "cowsCount" by calling the method "countCows";
    - store data into the array "table";
    - subtract by one value to the "userGuessCount";
    - call the method "printTable";
    - reset the "userGuessCount" to 10 after every game;
    - make sure after correct guess user gets the following message:

      _**You won! Congratulations!
    Do you want to play again?
    Please answer by entering - "yes" or "no"!**_

    - and after 10 incorrect guesses this message:

      _**Sorry you lost! Good luck next time!
    Do you want to play again?
    Please answer by entering - "yes" or "no"!**_

    - if user answers with "yes" (does not matter if lower or upper case letters are used), the game starts again with new random number to guess;
    - if user answers with "no" (does not matter if lower or upper case letters are used), the program exits;
    - if user answers with something else, then "yes" or "no" (as well as an empty input), the user gets the following message:
  
      _**Sorry, could not get your reply! 
    Please type one of two answers - "yes" or "no"!**_
