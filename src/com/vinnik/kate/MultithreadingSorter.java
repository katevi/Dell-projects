package com.vinnik.kate;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/** Class, which creates given number of threads, and measures time they need to sort random array. */
public class MultithreadingSorter {

    /** Creates given number of threads and executes them. */
    public static void measureTimeOfSorting(int amountOfThreads) {
        for (int i = 0; i < amountOfThreads; i++) {
            ThreadSort thread = new ThreadSort(i);
            thread.start();
        }
    }


    private static class ThreadSort extends Thread {
        private int[] numbersToSort;
        private int key;

        protected ThreadSort(int number) {
            numbersToSort = new int[500];
            key = number;

            for (int i = 0; i < numbersToSort.length; i++) {
                Random random = new Random();
                numbersToSort[i] = random.nextInt(10000);
            }
        }

        public void run() {
            long startTime = System.nanoTime();
            sort();
            long elapsedTimeInNanoseconds = System.nanoTime() - startTime;
            long elapsedTimeInMilliseconds = TimeUnit.MILLISECONDS.convert(elapsedTimeInNanoseconds, TimeUnit.NANOSECONDS);
            System.out.println(key + " - " + elapsedTimeInMilliseconds);
        }

        protected void sort() {
            int length = numbersToSort.length;

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
