package com.vinnik.kate;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/** Class, which creates given number of threads, and measures time they need to sort random array. */
public class MultithreadingSorter {
    private static final int ARRAY_SIZE = 500;
    private static final int UPPER_BOUND_RANDOM = 10000;
    private static final int NANOSECONDS_IN_MILLISECONDS = 1000000;

    /** Creates given number of threads and executes them. */
    public static void measureTimeOfSorting(final int amountOfThreads) {
        for (int i = 0; i < amountOfThreads; i++) {
            final ThreadSort thread = new ThreadSort(i);
            thread.start();
        }
    }


    final protected static class ThreadSort extends Thread {
        private final int[] numbersToSort;
        private final int identifier;

        protected ThreadSort(final int identifier) {
            this.numbersToSort = this.generateRandomArray();
            this.identifier = identifier;

        }

        private int[] generateRandomArray() {
            final int[] randomArray = new int[ARRAY_SIZE];
            final Random random = new Random();
            for (int i = 0; i < randomArray.length; i++) {
                randomArray[i] = random.nextInt(UPPER_BOUND_RANDOM);
            }
            return randomArray;
        }

        public void run() {
            final long startTime = System.nanoTime();
            sort();
            final double elapsedTimeInMilliseconds = (double) (System.nanoTime() - startTime) / (double) NANOSECONDS_IN_MILLISECONDS;
            System.out.println("Thread " + identifier + " processed data for " + elapsedTimeInMilliseconds + " milliseconds");
        }

        protected void sort() {
            final int length = numbersToSort.length;

            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (numbersToSort[j] > numbersToSort[j + 1]) {
                        final int temp = numbersToSort[j];
                        numbersToSort[j] = numbersToSort[j + 1];
                        numbersToSort[j + 1] = temp;
                    }
                }
            }
        }

    }

}
