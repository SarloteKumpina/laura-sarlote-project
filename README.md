# laura-sarlote-project

### Create a game **"Bulls and cows"**

1.  Create a class "Utils" and: 

a) create a method "generateNumber" which generates random number with 4 or 5 digits (according to users choice) where each digit is different. The method must return int array;
       
b) create a method "countBulls" which counts all digits that are placed in the right place in the random number at each guess. The method must return int;
   
c) create a method "countCows" which counts all digits that are somewhere in the random number, but are not in the right place. The method must return int;  
   
d) create a method "printTableFourDigits" which prints a new table after every valid guess input with 4 digits including all the previous guesses.  
The method should print following (this is just an example for users input and expected outcome for Bulls and Cows count if user chose to have 10 guesses):  

| Your guess | Bulls | Cows | Attempts left |  
|:----------:|:-----:|:----:|:-------------:|
|    1234    |   0   |   3  |       9       |
|    5678    |   0   |   1  |       8       |

e) create a method "printTableFiveDigits" which prints a new table after every valid guess input with 5 digits including all the previous guesses.    
The method should print following (this is just an example for users input and expected outcome for Bulls and Cows count if user chose to have 20 guesses):

| Your guess | Bulls | Cows | Attempts left |
|:----------:|:-----:|:----:|:-------------:|
|    1234    |   0   |   3  |       9       |
|    5678    |   0   |   1  |       8       |

2. Create a class "CowsAndBullsGame" with main method for creating the game and:   
   
a) import Scanner for users input;
    
b) create the variables:  
   - "numbersOnly" with datatype String;   
   - "userGuessCount" with datatype int;
   - "userGuessCountTen" with datatype int and assign value - 10 to it;
   - "userGuessCountFifteen" with datatype int and assign value - 15 to it;
   - "userGuessCountTwenty" with datatype int and assign value - 20 to it;
   - "bullsCount" with datatype int;
   - "cowsCount" with datatype int;
   - "playAgain" with datatype String;
   - two-dimensional array variable "table" with datatype String;
   - "gamesPlayed" with datatype int and assign value - 0 to it;
   - "gamesWon" with datatype int and assign value - 0 to it;
   - "gamesLost" with datatype int and assign value - 0 to it;
   - "digitChoice" with datatype int and assign value. 

c) print a text for beginning of the game as follows:

**_Game "Bulls & Cows"_**

**_Try to guess the secret number where each digit is different!_**
**_First - choose between 4 or 5 digit number to guess._**
**_Second - choose between 10, 15 or 20 guesses._**
**_Start the game by entering 4 or 5 digits (according to your choice) from 0 to 9._**
**_If some of your digits will be in the right place of the secret number, you will get Bulls._**
**_If some of your digits will be in the secret number, but not in the right place, you will get Cows._**
**_Good luck! :)_**

d) use do while loop for creating the game:
   - ask user to choose between 4 or 5 digit number to guess;
   - if user entered something else than 4 or 5, output following message and let user answer again:
      
**_Incorrect input. Please enter - 4 or 5!_** 
 
   - ask user to choose between 10, 15  or 20 guesses to have;    
   - if user entered something else than 10, 15 or 20, output following message and let user answer again:

**_Incorrect input. Please enter - 10, 15 or 20!_**

   - call the method generateNumber with 4 or 5 digits (according to users choice at the begining of the game) for generating the random number for user to guess;
   - assign size to the array --> table[userGuessCount][4];
   - ask user to enter his/her guess and accept first 4 or 5 (according to users choice at the begining of the game) digits from users input as guess;
   - if user entered less than 4 or more than 4 digits (in case of choosing 4 digit number to guess at the begining of the game), output following message and let user guess again:

**_Incorrect input. Please enter 4 digits!_**

   - if user entered less than 5 or more than 5 digits (in case of choosing 5 digit number to guess at the begining of the game), output following message and let user guess again:

**_Incorrect input. Please enter 5 digits!_**

   - create an array variable "userNumber" with datatype int and size of "digitChoice";
   - store each digit from users input into the array "userNumber";
   - assign a value to "bullsCount" by calling the method "countBulls";
   - assign a value to "cowsCount" by calling the method "countCows";
   - store data into the array "table", use variables "UserGuessCountTen", "UserGuessCountFifteen" and "UserGuessCountTwenty";
   - subtract by one value from "UserGuessCountTen", "UserGuessCountFifteen" or "UserGuessCountTwenty";
   - call the method "printTableFourDigits" or "printTableFiveDigits";
   - reset the "userGuessCountTen" to - 10 after every game;
   - reset the "userGuessCountFifteen" to - 15 after every game;
   - reset the "userGuessCountTwenty" to - 20 after every game;
   - count played games and include information about how many games the user won and how many lost;
   - make sure that after correct guess user gets the following message:

**_You won! Congratulations!_**

**_Games played: 1_**
**_- games you won: 1_**
**_- games you lost: 0_**

**_Do you want to play again?_**
**_Please answer by entering - "yes" or "no"!_**

   - and after all (10, 15 or 20) incorrect guesses this message:

**_Sorry you lost! Good luck next time!_**
**_The secret number was: 5780 (or 54603 in case of 5 digits choice)_**

**_Games played: 2_**
**_- games you won: 1_**
**_- games you lost: 1_**

**_Do you want to play again?_**
**_Please answer by entering - "yes" or "no"!_**

   - if user answers with "yes" (does not matter if lower or upper case letters are used), the game starts again;
   - if user answers with "no" (does not matter if lower or upper case letters are used), the program exits;
   - if user answers with something else than "yes" or "no" (as well as an empty input), the user gets the following message:

**_Sorry, could not get your reply!_**
**_Please type one of two answers - yes or no!_**   