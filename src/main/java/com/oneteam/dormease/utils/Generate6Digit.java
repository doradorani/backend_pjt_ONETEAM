package com.oneteam.dormease.utils;

public class Generate6Digit {
    public static String generateAuthNo() {
        java.util.Random generator = new java.util.Random();
        generator.setSeed(System.currentTimeMillis());
        return String.valueOf( generator.nextInt(1000000) % 1000000);

    }
}
