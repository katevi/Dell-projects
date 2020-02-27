package com.vinnik.kate;

/** Class, which implements interaction with user. */
public class Main {
    private final static int MINIMAL_AMOUNT_OF_THREADS = 0;
    public static void main(String[] args) {
        try {
            final int amountOfThreads = Integer.parseInt(args[0]);
            if (amountOfThreads < MINIMAL_AMOUNT_OF_THREADS) {
                System.out.println("Wrong number format. Please, enter positive integer number. ");
            }
            MultithreadingSorter.measureTimeOfSorting(amountOfThreads);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("Please, enter amount of threads.");
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Wrong number format. Please, enter positive integer number. ");
        } catch (Exception e) {
            System.out.println("Something went wrong in multithreading sorter. ");
        }
    }
}
