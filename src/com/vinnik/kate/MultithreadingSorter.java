package com.vinnik.kate;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/** Class, which creates given number of threads, and measures time they need to sort random array. */
public class MultithreadingSorter {
    private static final int arraySize = 500;
    private static final int upperBoundForRandom = 10000;

    /** Creates given number of threads and executes them. */
    public static void measureTimeOfSorting(final int amountOfThreads) {
        for (int i = 0; i < amountOfThreads; i++) {
            ThreadSort thread = new ThreadSort(i);
            thread.start();
        }
    }


    protected static class ThreadSort extends Thread {
        private int[] numbersToSort;
        private int identifier;

        protected ThreadSort(int number) {
            this.numbersToSort = this.generateRandomArray();
            this.identifier = number;

        }

        private int[] generateRandomArray() {
            int[] randomArray = new int[arraySize];
            final Random random = new Random();
            for (int i = 0; i < randomArray.length; i++) {
                randomArray[i] = random.nextInt(upperBoundForRandom);
            }
            return randomArray;
        }

        public void run() {
            long startTime = System.nanoTime();
            sort();
            long elapsedTimeInNanoseconds = System.nanoTime() - startTime;
            long elapsedTimeInMilliseconds = TimeUnit.MILLISECONDS.convert(elapsedTimeInNanoseconds, TimeUnit.NANOSECONDS);
            System.out.println("Thread " + identifier + " processed data for " + elapsedTimeInMilliseconds + " milliseconds");
        }

        protected void sort() {
            final int length = numbersToSort.length;

            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (numbersToSort[j] > numbersToSort[j + 1]) {
                        int temp = numbersToSort[j];
                        numbersToSort[j] = numbersToSort[j + 1];
                        numbersToSort[j + 1] = temp;
                    }
                }
            }
        }

    }

}
