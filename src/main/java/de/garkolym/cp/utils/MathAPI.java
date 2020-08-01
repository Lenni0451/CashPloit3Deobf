package de.garkolym.cp.utils;

import java.util.Random;

public class MathAPI {

    public static int nextNumberBetween(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max - min + 1) + min;
        return randomNum;
    }

}
