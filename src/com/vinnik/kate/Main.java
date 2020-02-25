package com.vinnik.kate;

/** Class, which implements interaction with user. */
public class Main {
    public static void main(String[] args) {
        try {
            final int amountOfThreads = Integer.parseInt(args[0]);
            if (amountOfThreads < 0) {
                System.out.println("Wrong number format. Please, enter positive integer number. ");
            }
            MultithreadingSorter.measureTimeOfSorting(amountOfThreads);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("Please, enter amount of threads.");
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Wrong number format. Please, enter positive integer number. ");
        }
    }
}
