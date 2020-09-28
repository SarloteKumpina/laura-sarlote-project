package com.accenture.prebootcamp.bullsandcows;

import java.util.Scanner;

public class TheGame {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String numbersOnly;
        int userGuessCount;
        int userGuessCountTen = 10;
        int userGuessCountFifteen = 15;
        int userGuessCountTwenty = 20;
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
                "Try to guess 4 different digit number (secret number).\n" +
                "Start the game by entering 4 digits from 0 to 9.\n" +
                "If some of your digits will be in the right place of the secret number, you will get Bulls.\n" +
                "If some of your digits will be in the secret number, but not in the right " +
                "place, you will get Cows.\n" +
                "You have 10 guesses! Good luck! :)");

        do {
            do {
                System.out.print("Enter your choice of how many digit number you want to guess 4 or 5: ");
                digitChoice = userInput.nextInt();
                if (digitChoice < 4 || digitChoice > 5) {
                    System.out.println("\nIncorrect input. Please enter 4 or 5!");
                }
            } while (digitChoice < 4 || digitChoice > 5);

            do {
                System.out.print("\nHow many times you want to guess the number? You can choose from 10, 15 or 20: ");
                userGuessCount = userInput.nextInt();

                if (userGuessCount != 10 && userGuessCount != 15 && userGuessCount != 20) {
                    System.out.println("Incorrect input. You can choose from 10, 15 or 20!");
                }
            } while (userGuessCount != 10 && userGuessCount != 15 && userGuessCount != 20);

            userInput.nextLine();

            int[] randomNumber = Utils.generateNumber(digitChoice);
            System.out.println();

            for (int i = 0; i < randomNumber.length; i++) {
                System.out.print(randomNumber[i] + " ");
            }

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

                if (userGuessCount == 20) {
                    table[20 - userGuessCountTwenty][0] = numbersOnly;
                    table[20 - userGuessCountTwenty][1] = Integer.toString(bullsCount);
                    table[20 - userGuessCountTwenty][2] = Integer.toString(cowsCount);
                    table[20 - userGuessCountTwenty][3] = Integer.toString(userGuessCountTwenty - 1);
                    userGuessCountTwenty--;
                } else if (userGuessCount == 15) {
                    table[15 - userGuessCountFifteen][0] = numbersOnly;
                    table[15 - userGuessCountFifteen][1] = Integer.toString(bullsCount);
                    table[15 - userGuessCountFifteen][2] = Integer.toString(cowsCount);
                    table[15 - userGuessCountFifteen][3] = Integer.toString(userGuessCountFifteen - 1);
                    userGuessCountFifteen--;
                } else {
                    table[10 - userGuessCountTen][0] = numbersOnly;
                    table[10 - userGuessCountTen][1] = Integer.toString(bullsCount);
                    table[10 - userGuessCountTen][2] = Integer.toString(cowsCount);
                    table[10 - userGuessCountTen][3] = Integer.toString(userGuessCountTen - 1);
                    userGuessCountTen--;
                }

                if (digitChoice == 4) {
                    Utils.printTableFourDigits(table);
                }

                if (digitChoice == 5) {
                    Utils.printTableFiveDigits(table);
                }


            } while (bullsCount != digitChoice && userGuessCountTen != 0 && userGuessCountFifteen != 0 && userGuessCountTwenty != 0);

            gamesPlayed++;
            if (bullsCount == digitChoice) {
                gamesWon++;
                System.out.println("You won! Congratulations!\nGames played - " + gamesPlayed +
                        "\nGames you won - " + gamesWon + "\nGames you lost - " + gamesLost + "\nDo you want to play again? " +
                        "\nPlease answer by entering - \"yes\" or \"no\"!");
            } else {
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

            userGuessCountTen = 10;
            userGuessCountFifteen = 15;
            userGuessCountTwenty = 20;

            playAgain = userInput.nextLine();

            while (!playAgain.toLowerCase().equals("yes") && !playAgain.toLowerCase().equals("no")) {
                System.out.println("Sorry, could not get your reply! \nPlease type one of two answers - \"yes\" or \"no\"!");
                playAgain = userInput.nextLine();
            }

        } while (playAgain.toLowerCase().equals("yes"));

        userInput.close();
    }
}
