package com.accenture.prebootcamp.cowsandbulls;

import java.util.Scanner;

public class CowsAndBullsGame2 {

    // maybe uztaisam ASCII art, ja ir laiks

    public static void main(String[] args) {
        int[] randomNumber = Utils.generateNumber();
        Scanner userInput = new Scanner(System.in);
        String numbersOnly;
        int userGuessCount = 10;
        int bullsCount = 0;
        String playAgain;

        for (int i = 0; i < randomNumber.length; i++) {
            System.out.print(randomNumber[i] + " ");
        }
        System.out.println("");

        do {
            do {
                do {
                    System.out.print("Please enter 4 different digits from 0 to 9: ");
                    String userString = userInput.nextLine();

                    numbersOnly = userString.replaceAll("[^0-9]", "");
                    if (numbersOnly.length() != 4) {
                        System.out.println("Incorrect input. Please enter 4 digits!");
                    }
                } while (numbersOnly.length() != 4);

                System.out.println("Your guess: " + numbersOnly);

                int[] userNumber = new int[4];
                for (int i = 0; i < numbersOnly.length(); i++) {
                    userNumber[i] = Integer.parseInt(numbersOnly.substring(i, i + 1));
                }

                bullsCount = Utils.countBulls(userNumber, randomNumber);
                userGuessCount--;

                System.out.println("Bulls - " + bullsCount + "\nCows - " +
                        Utils.countCows(userNumber, randomNumber));
                if (bullsCount != 4) {
                    System.out.println("You have " + userGuessCount + " guesses left.");
                }

            } while (bullsCount != 4 && userGuessCount != 0);

            if (bullsCount == 4) {
                System.out.println("You won! Congrats! Wanna play again - Yes/No?");
            } else {
                System.out.println("Sorry, you loose! Wanna play again - Yes/No?");
            }

            playAgain = userInput.nextLine();
            playAgain.toLowerCase();

        } while (playAgain.toLowerCase().equals("yes"));
    }
}
