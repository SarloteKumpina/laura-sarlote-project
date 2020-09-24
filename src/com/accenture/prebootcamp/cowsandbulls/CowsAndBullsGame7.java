package com.accenture.prebootcamp.cowsandbulls;

import java.util.Scanner;

public class CowsAndBullsGame7 {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String numbersOnly;
        int userGuessCount = 10;
        int bullsCount = 0;
        int cowsCount = 0;
        String playAgain;
        String[][] table;

        System.out.println();
        System.out.println("Game \"Cows & bulls\"\n\n" +
                "Try to guess 4 different digit number.\n" +
                "Start the game by entering 4 digits from 0 to 9.\n" +
                "If some of your digits will be in the right place, you will get Bulls\n" +
                "If some of your digits will be in the secret number, but not in the right " +
                "place, you will get Cows\n" +
                "You have 10 guesses! Good luck! :)");

        do {
            int[] randomNumber = Utils.generateNumber();
            System.out.println();
            for (int i = 0; i < randomNumber.length; i++) {
                System.out.print(randomNumber[i] + " ");
            }
            table = new String[userGuessCount][4];
            do {
                do {
                    System.out.println();
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

            if (userGuessCount == 0) {
                userGuessCount = 10;
            }

            if (bullsCount == 4) {
                System.out.println("You won! Congratulations! \nDo you want to play again? " +
                        "\nPlease answer by entering - \"yes\" or \"no\"!");
            } else {
                System.out.println("\nSorry you lost! Good luck next time! \nDo you want to play again? " +
                        "\nPlease answer by entering - \"yes\" or \"no\"!");
            }

            playAgain = userInput.nextLine();

            while (!playAgain.toLowerCase().equals("yes") && !playAgain.toLowerCase().equals("no")) {
                System.out.println("Sorry, could not get your reply! \nPlease type one of two answers - yes or no!");
                playAgain = userInput.nextLine();
            }

        } while (playAgain.toLowerCase().equals("yes"));

        userInput.close();
    }
}
