package com.accenture.prebootcamp.bullsandcows;

import java.util.Scanner;

class BullsAndCowsGame {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String numbersOnly;
        int userGuessCount = 10;
        int bullsCount;
        int cowsCount;
        String playAgain;
        String[][] table;
        int gamesPlayed = 0;
        int gamesWon = 0;
        int gamesLost = 0;

        System.out.println();
        System.out.println("Game \"Bulls & Cows\"\n\n" +
                "Try to guess 4 different digit number (secret number).\n" +
                "Start the game by entering 4 digits from 0 to 9.\n" +
                "If some of your digits will be in the right place of the secret number, you will get Bulls.\n" +
                "If some of your digits will be in the secret number, but not in the right " +
                "place, you will get Cows.\n" +
                "You have 10 guesses! Good luck! :)");

        do {
            int[] randomNumber = Utils.generateNumber();
            System.out.println();
            table = new String[userGuessCount][4];
            do {
                do {
                    System.out.print("Your guess: ");
                    String userString = userInput.nextLine();

                    numbersOnly = userString.replaceAll("[^0-9]", "");
                    if (numbersOnly.length() != 4) {
                        System.out.println("Incorrect input. Please enter 4 digits!");
                    }
                } while (numbersOnly.length() != 4);

                int[] userNumber = new int[4];
                for (int i = 0; i < numbersOnly.length(); i++) {
                    userNumber[i] = Integer.parseInt(numbersOnly.substring(i, i + 1));
                }

                bullsCount = Utils.countBulls(userNumber, randomNumber);
                cowsCount = Utils.countCows(userNumber, randomNumber);

                table[10 - userGuessCount][0] = numbersOnly;
                table[10 - userGuessCount][1] = Integer.toString(bullsCount);
                table[10 - userGuessCount][2] = Integer.toString(cowsCount);
                table[10 - userGuessCount][3] = Integer.toString(userGuessCount - 1);

                userGuessCount--;
                Utils.printTable(table);

            } while (bullsCount != 4 && userGuessCount != 0);

            if (bullsCount == 4) {
                gamesPlayed++;
                gamesWon++;
                System.out.println("You won! Congratulations!\nGames played - " + gamesPlayed +
                        "\nGames you won - " + gamesWon + "\nGames you lost - " + gamesLost + "\nDo you want to play again? " +
                        "\nPlease answer by entering - \"yes\" or \"no\"!");
            } else {
                gamesPlayed++;
                gamesLost++;
                System.out.println("Sorry, you lost! Good luck next time!\nGames played - " + gamesPlayed +
                                "\nGames you won - " + gamesWon + "\nGames you lost - " + gamesLost);
                System.out.print("The secret number was: ");
                for (int i = 0; i < randomNumber.length; i++) {
                    System.out.print(randomNumber[i] + " ");
                }
                System.out.println("\nDo you want to play again? " +
                        "\nPlease answer by entering - \"yes\" or \"no\"!");
            }
            userGuessCount = 10;

            playAgain = userInput.nextLine();

            while (!playAgain.toLowerCase().equals("yes") && !playAgain.toLowerCase().equals("no")) {
                System.out.println("Sorry, could not get your reply! \nPlease type one of two answers - \"yes\" or \"no\"!");
                playAgain = userInput.nextLine();
            }

        } while (playAgain.toLowerCase().equals("yes"));

        userInput.close();
    }
}
