package com.vinnik.kate;

import java.util.Random;

/** This class starts threads, which are measures time of processing tasks. */
public class TaskExecutor {
    private static final int UPPER_BOUND_OF_RANDOM = 10000;
    private static final int NANOSECONDS_IN_MILLISECONDS = 1000000;

    private final int amountOfThreads;

    private TaskTable taskTable;

    /** Creates new object's table with tasks with given amount of tasks, creates given amount of threads. */
    public TaskExecutor(int amountOfThreads, int amountOfMeasurements) {
        this.amountOfThreads = amountOfThreads;
        this.taskTable = new TaskTable(amountOfMeasurements);
    }

    /** Starts measures of time to complete each task from table with tasks. */
    public void measureTasksCompletionTime() {
        System.out.println("Measuring starts...");
        for (int i = 0; i < amountOfThreads; i++) {
            Thread thread = new Thread(new ThreadSorter(i));
            thread.start();
        }
    }

    private class ThreadSorter implements Runnable {
        private final int threadIdentifier;
        private Task task;

        private ThreadSorter(int threadIdentifier) {
            this.threadIdentifier = threadIdentifier;
        }

        @Override
        public void run() {
            while (!taskTable.isAllTaskTook()) {
                this.task = taskTable.popLastTaskIdentifier();
                if (this.task != null) {
                    this.task.setThreadIdentifier(this.threadIdentifier);

                    System.out.println("Thread number " + task.getThreadIdentifier() + " took task " + task.getTaskIdentifier() + ".");

                    final long startTime = System.nanoTime();
                    this.sort(generateRandomArray(task.getAmountOfNumbers()));
                    final double elapsedTimeInMilliseconds = (double) (System.nanoTime() - startTime) / (double) NANOSECONDS_IN_MILLISECONDS;

                    this.task.setMeasuredTime(elapsedTimeInMilliseconds);
                    this.printMeasure(this.task);
                }
            }
        }


        private int[] generateRandomArray(int arraySize) {
            final int[] randomArray = new int[arraySize];
            final Random random = new Random();
            for (int i = 0; i < randomArray.length; i++) {
                randomArray[i] = random.nextInt(UPPER_BOUND_OF_RANDOM);
            }
            return randomArray;
        }

        private void sort(int[] array) {
            final int length = array.length;

            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        final int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }

        private void printMeasure(Task task) {
            System.out.println("Thread " + task.getThreadIdentifier() + " completed task " + task.getTaskIdentifier()
                    + ": sorted " + task.getAmountOfNumbers() + " numbers in " + task.getMeasuredTime() + " milliseconds. ");
        }
    }
}
