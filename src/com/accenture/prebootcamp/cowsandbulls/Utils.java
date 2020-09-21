package com.accenture.prebootcamp.cowsandbulls;

import java.util.Random;

public class Utils {

    public static int[] generateNumber() {

        Random random = new Random();
        int[] myArray = new int[4];
        String memory = "";

        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(9);
            while (memory.contains(Integer.toString(number))) {
                number = random.nextInt(9);
            }
            myArray[i] = number;
            memory += number;
        }
        return myArray;
    }

    public static int countBulls(int[] userNumber, int[] randomNumber) {
        int bullsCount = 0;
        for (int i = 0; i < userNumber.length; ++i) {
            if (randomNumber[i] == userNumber[i]) {
                bullsCount += 1;
            }
        }
        return bullsCount;
    }

    public static int countCows(int[] userNumber, int[] randomNumber) {
        int cowsCount = 0;
        for (int i = 0; i < userNumber.length; ++i) {
            for (int j = 0; j < randomNumber.length; ++j) {
                if (userNumber[i] == randomNumber[j] && i != j) {
                    cowsCount += 1;
                }
            }
        }
        return cowsCount;
    }
}
