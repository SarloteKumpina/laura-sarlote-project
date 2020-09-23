package com.accenture.prebootcamp.cowsandbulls;

import java.util.Scanner;
import java.util.ArrayList;

public class CowsAndBullsGame6 {
    public static void main(String[] args) {
        int[] randomNumber = Utils.generateNumber();
        Scanner userInput = new Scanner(System.in);
        String numbersOnly;
        int userGuessCount = 10;
        int bullsCount;
        String playAgain;

        ArrayList<String> usersInputArray;
        usersInputArray = new ArrayList<>();
        ArrayList<String> countedBullsArray;
        countedBullsArray = new ArrayList<>();
        ArrayList<String> countedCowsArray;
        countedCowsArray = new ArrayList<>();
        ArrayList<String> remainingGuessesArray;
        remainingGuessesArray = new ArrayList<>();

        for (int i = 0; i < randomNumber.length; i++) {
            System.out.print(randomNumber[i] + " ");
        }
        System.out.println();

        System.out.println("Game \"Cows & bulls\"\n\n" +
                "Try to guess 4 different digit number.\n" +
                "Start the game by entering 4 digits from 0 to 9.\n" +
                "If some of your digits will be in the right place, you will get Bulls\n" +
                "If some of your digits will be in the secret number, but not in the right place, you will get Cows\n" +
                "You have 10 guesses! Good luck! :)\n");

        do {
            do {
                do {
                    System.out.print("Your guess: ");
                    String userString = userInput.nextLine();

                    numbersOnly = userString.replaceAll("[^0-9]", "");

                    if (numbersOnly.length() != 4) {
                        System.out.println("Incorrect input. Please enter 4 digits!");
                    }
                } while (numbersOnly.length() != 4);

                System.out.print("+------------+-------+------+---------------+\n" +
                        "| Your guess | Bulls | Cows | Attempts left |\n" +
                        "+------------+-------+------+---------------+");

                int[] userNumber = new int[4];
                for (int i = 0; i < numbersOnly.length(); i++) {
                    userNumber[i] = Integer.parseInt(numbersOnly.substring(i, i + 1));
                }

                bullsCount = Utils.countBulls(userNumber, randomNumber);
                userGuessCount--;

                if (bullsCount != 4) {
                    usersInputArray.add(numbersOnly);
                    countedBullsArray.add(Integer.toString(bullsCount));
                    countedCowsArray.add(Integer.toString(Utils.countCows(userNumber, randomNumber)));
                    remainingGuessesArray.add(Integer.toString(userGuessCount));

                    for (String guess : usersInputArray) {
                        System.out.print("\n|  " + guess + "      |  ");
                    }

                    for (String bulls : countedBullsArray) {
                        System.out.print(bulls + "    |  ");
                    }

                    for (String cows : countedCowsArray) {
                        System.out.print(cows + "   |       ");
                    }

                    for (String remain : remainingGuessesArray) {
                        System.out.print(remain + "       |\n" +
                                "+------------+-------+------+---------------+\n");
                    }
                }
            }
            while (bullsCount != 4 && userGuessCount != 0);

            if (bullsCount == 4) {
                System.out.println("        |\n+------------+-------+------+---------------+\n\nYou won! " +
                        "Congratulations! \nDo you want to play again? \nPlease answer by entering - yes or no!");
            } else {
                System.out.println("\nSorry you lost! " +
                        "Good luck next time! \nDo you want to play again? \nPlease answer by entering - yes or no!");
            }

            playAgain = userInput.nextLine();

        } while (playAgain.toLowerCase().equals("yes"));
    }
}
