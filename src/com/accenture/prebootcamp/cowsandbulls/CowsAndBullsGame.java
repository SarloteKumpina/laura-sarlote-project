package com.accenture.prebootcamp.cowsandbulls;

import java.util.Scanner;

public class CowsAndBullsGame {

    public static void main(String[] args) {
        int[] randomNumber = Utils.generateNumber();

        for (int i = 0; i < randomNumber.length; i++) {
            System.out.print(randomNumber[i] + " ");

        }
        System.out.println("\n×******");

//        boolean isGuessCorrect = false;
        int bullsCount = 0;
        int cowsCount = 0;

        Scanner userInput = new Scanner(System.in);

        do {
            System.out.print("Please enter 4 different digits from 0 to 9 (for example 1 3 4 8): ");
            String userString = userInput.nextLine();

//        String numbersOnly = userString.replaceAll("[^0-9]", "");
            String numbersOnly = userString.trim();
            System.out.println("Your guess: " + numbersOnly);

//        String[] usersArray = numbersOnly.split("");
//        for (int i = 0; i< usersArray.length; i++){
//            System.out.print(usersArray[i] + " ");
//         }

            int[] userNumber = new int[4];
            for (int i = 0; i < numbersOnly.length(); i++) {
                userNumber[i] = Integer.parseInt(numbersOnly.substring(i, i + 1));
            }

            for (int i = 0; i < userNumber.length; ++i) {
//            System.out.println("Outer loop iteration " + i);
                for (int j = 0; j < randomNumber.length; ++j) {
                    if (userNumber[i] == randomNumber[j]) {
                        cowsCount += 1;

                    }
                    //System.out.println("usersNumber[0] = " + userNumber[i] + "; randomNumber[j] = " + randomNumber[j] + " AND cows count is - " + cowsCount);
                }
            }

            for (int i = 0; i < userNumber.length; i++) {
                if (randomNumber[i] == userNumber[i]) {
                    //isGuessCorrect = true;
                    bullsCount += 1;
                }
            }

//            if (!isGuessCorrect) {
//                //System.out.println("Not correct, try again! You have 9 attempts left.");
//            }
            System.out.print("Bulls - " + bullsCount + " Cows - " + cowsCount);
            System.out.println("\n×******");


        } while (bullsCount < 5);


    }


}
