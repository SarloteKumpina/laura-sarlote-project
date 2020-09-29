package com.accenture.prebootcamp.bullsandcows;

import java.util.Random;

class Utils {

    static int[] generateNumber(int sizeOfNumber) {

        Random random = new Random();
        int[] myArray = new int[sizeOfNumber];
        String memory = "";

        for (int i = 0; i < sizeOfNumber; i++) {
            int number = random.nextInt(9);
            while (memory.contains(Integer.toString(number))) {
                number = random.nextInt(9);
            }
            myArray[i] = number;
            memory += number;
        }
        return myArray;
    }

    static int countBulls(int[] userNumber, int[] randomNumber) {
        int bullsCount = 0;
        for (int i = 0; i < userNumber.length; ++i) {
            if (randomNumber[i] == userNumber[i]) {
                bullsCount += 1;
            }
        }
        return bullsCount;
    }

    static int countCows(int[] userNumber, int[] randomNumber) {
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

    static void printTableFourDigits(String[][] table) {
        System.out.print("-------------+-------+------+----------------\n" +
                "  Your guess | Bulls | Cows | Attempts left  \n" +
                "-------------+-------+------+----------------\n");

        for (int i = 0; i < table.length; i++) {
            if (table[i][0] == null) {
                return;
            }
            System.out.print("     " + table[i][0] + "    " +
                    "|   " + table[i][1] + "   |  " +
                    table[i][2] + "   |       " +
                    table[i][3] + "        \n" +
                    "-------------+-------+------+----------------\n");
        }
    }

    static void printTableFiveDigits(String[][] table) {
        System.out.print("-------------+-------+------+----------------\n" +
                "  Your guess | Bulls | Cows | Attempts left  \n" +
                "-------------+-------+------+----------------\n");

        for (int i = 0; i < table.length; i++) {
            if (table[i][0] == null) {
                return;
            }
            System.out.print("     " + table[i][0] + "   " +
                    "|   " + table[i][1] + "   |  " +
                    table[i][2] + "   |       " +
                    table[i][3] + "        \n" +
                    "-------------+-------+------+----------------\n");
        }
    }
}
