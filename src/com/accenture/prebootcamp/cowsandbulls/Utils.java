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
}
