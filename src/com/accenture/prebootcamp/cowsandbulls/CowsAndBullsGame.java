package com.accenture.prebootcamp.cowsandbulls;

import java.util.Scanner;

public class CowsAndBullsGame {

    public static void main(String[] args) {
        int[] randomNumber = Utils.generateNumber();

        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter 4 different digits from 0 to 9 (for example 1 3 4 8): ");
        String userString = userInput.nextLine();


//        String numbersOnly = userString.replaceAll("[^0-9]", "");
        String numbersOnly = userString.trim();
        System.out.println("Your guess: " + numbersOnly);

        //String[] usersArray = numbersOnly.split("");
        //for (int i = 0; i< usersArray.length; i++){
        //    System.out.print(usersArray[i] + " ");
        // }

        int[] userNumber = new int[4];
        for (int i = 0; i < numbersOnly.length(); i++) {
            userNumber[i] = Integer.parseInt(numbersOnly.substring(i, i + 1));
        }


        int bullsCount = 0;
        for (int i = 0; i < userNumber.length; i++) {
//            int number = userNumber[i];
            if (randomNumber[i] == userNumber[i]) {
                bullsCount += 1;
            }
        }

        int cowsCount = 0;
        boolean exists = false;
        for (int i = 0; i < userNumber.length; i++) {
            int number = randomNumber[i];
                    if (number == userNumber[i]) {
                        exists = true;
                        cowsCount += 1;
                    }
                }

//        do {
//            int userGuess = userInput.nextInt();
//            boolean exists = false;
//            for (int i = 0; i < myList.length; i++) {
//                if (userGuess == myList[i]) {
//                    exists = true;
//                }
//            }
//

        System.out.print("Bulls - " + bullsCount + " Cows - " + cowsCount);


        System.out.println();


        for (int x = 0; x < randomNumber.length; x++) {

            System.out.print(randomNumber[x] + " ");
        }


    }
}