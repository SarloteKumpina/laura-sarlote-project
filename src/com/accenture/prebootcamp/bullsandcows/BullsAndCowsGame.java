package com.accenture.prebootcamp.bullsandcows;

import java.util.Scanner;

public class BullsAndCowsGame {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String numbersOnly;
        int userGuessCount;
        int userGuessCountStatic;
        int bullsCount;
        int cowsCount;
        String playAgain;
        String[][] table;
        int gamesPlayed = 0;
        int gamesWon = 0;
        int gamesLost = 0;
        int digitChoice;

        System.out.println();
        System.out.println("Game \"Bulls & Cows\"\n\n" +
                "Try to guess the secret number where each digit is different!\n" +
                "First - choose between 4 or 5 digit number to guess.\n" +
                "Second - choose between 10, 15 or 20 guesses.\n" +
                "Start the game by entering 4 or 5 digits (according to your choice) from 0 to 9.\n" +
                "If some of your digits will be in the right place of the secret number, you will get Bulls.\n" +
                "If some of your digits will be in the secret number, but not in the right place, you will get Cows.\n" +
                "Good luck! :)\n");

        do {
            do {
                System.out.print("\nPlease enter how many digit number you want to guess - 4 or 5: ");
                digitChoice = userInput.nextInt();
                if (digitChoice < 4 || digitChoice > 5) {
                    System.out.println("\nIncorrect input. Please enter - 4 or 5!");
                }
            } while (digitChoice < 4 || digitChoice > 5);

            do {
                System.out.print("Please enter how many guesses you want to have - 10, 15 or 20: ");
                userGuessCount = userInput.nextInt();
                userGuessCountStatic = userGuessCount;
                if (userGuessCount != 10 && userGuessCount != 15 && userGuessCount != 20) {
                    System.out.println("\nIncorrect input. Please enter - 10, 15 or 20!");
                }
            } while (userGuessCount != 10 && userGuessCount != 15 && userGuessCount != 20);

            userInput.nextLine();

            int[] randomNumber = Utils.generateNumber(digitChoice);
            System.out.println();

            table = new String[userGuessCount][4];

            do {
                do {
                    System.out.print("Your guess: ");
                    String userString = userInput.nextLine();

                    numbersOnly = userString.replaceAll("[^0-9]", "");
                    if (numbersOnly.length() != digitChoice) {
                        System.out.println("Incorrect input. Please enter " + digitChoice + " digits!");
                    }
                } while (numbersOnly.length() != digitChoice);

                int[] userNumber = new int[digitChoice];
                for (int i = 0; i < numbersOnly.length(); i++) {
                    userNumber[i] = Integer.parseInt(numbersOnly.substring(i, i + 1));
                }

                bullsCount = Utils.countBulls(userNumber, randomNumber);
                cowsCount = Utils.countCows(userNumber, randomNumber);

                table[userGuessCountStatic - userGuessCount][0] = numbersOnly;
                table[userGuessCountStatic - userGuessCount][1] = Integer.toString(bullsCount);
                table[userGuessCountStatic - userGuessCount][2] = Integer.toString(cowsCount);
                table[userGuessCountStatic - userGuessCount][3] = Integer.toString(userGuessCount - 1);
                userGuessCount--;

                Utils.printTable(table, digitChoice);

            } while (bullsCount != digitChoice && userGuessCount != 0);

            gamesPlayed++;
            if (bullsCount == digitChoice) {
                gamesWon++;
                System.out.println("\nYou won! Congratulations!\n\nGames played: " + gamesPlayed +
                        "\n- games you won: " + gamesWon + "\n- games you lost: " + gamesLost +
                        "\n\nDo you want to play again? " +
                        "\nPlease answer by entering - \"yes\" or \"no\"!");
            } else {
                gamesLost++;
                System.out.println("\nSorry, you lost! Good luck next time!");
                System.out.print("The secret number was: ");
                for (int i = 0; i < randomNumber.length; i++) {
                    System.out.print(randomNumber[i] + " ");
                }
                System.out.println("\n\nGames played: " + gamesPlayed +
                        "\n- games you won: " + gamesWon + "\n- games you lost: " + gamesLost);


                System.out.println("\nDo you want to play again? " +
                        "\nPlease answer by entering - \"yes\" or \"no\"!");
            }

            userInput.reset();

            playAgain = userInput.nextLine();

            while (!playAgain.toLowerCase().equals("yes") && !playAgain.toLowerCase().equals("no")) {
                System.out.println("Sorry, could not get your reply! \nPlease type one of two answers - \"yes\" or \"no\"!");
                playAgain = userInput.nextLine();
            }

        } while (playAgain.toLowerCase().equals("yes"));

        userInput.close();
    }
}
