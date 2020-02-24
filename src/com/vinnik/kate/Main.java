package com.vinnik.kate;

/** Class, which implements interaction with user. */
public class Main {
    public static void main(String[] args) {
        try {
            int amountOfThreads = Integer.parseInt(args[0]);
            MultithreadingSorter.measureTimeOfSorting(amountOfThreads);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("Please, enter amount of threads.");
        }
    }
}
