package com.vinnik.kate;

import java.util.Random;

public class TaskExecutor {
    private static final int UPPER_BOUND_OF_RANDOM = 10000;
    private static final int NANOSECONDS_IN_MILLISECONDS = 1000000;

    private final int amountOfThreads;

    private ResultTable resultTable;
    private TaskTable taskTable;

    public TaskExecutor(int amountOfThreads, int amountOfMeasurements) {
        this.amountOfThreads = amountOfThreads;
        this.resultTable = new ResultTable();
        this.taskTable = new TaskTable(amountOfMeasurements);
    }

    public void measureTasksCompletionTime() {
        for (int i = 0; i < amountOfThreads; i++) {
            Thread thread = new Thread(i);
            thread.run();

        }
    }

    private class Thread implements Runnable {
        private final int threadIdentifier;
        private Task task;

        private Thread(int threadIdentifier) {
            this.threadIdentifier = threadIdentifier;
        }

        @Override
        public void run() {
            while (taskTable.setLastTaskIdentifier(taskTable.getLastTaskIdentifier().getTaskIdentifier() + 1)) {
                this.task = taskTable.getLastTaskIdentifier();
                this.task.setThreadIdentifier(this.threadIdentifier);

                final long startTime = System.nanoTime();
                this.sort(generateRandomArray(task.getAmountOfNumbers()));
                final double elapsedTimeInMilliseconds = (double) (System.nanoTime() - startTime) / (double) NANOSECONDS_IN_MILLISECONDS;

                this.task.setMeasuredTime(elapsedTimeInMilliseconds);

                System.out.println(task.getThreadIdentifier() + " " + task.getTaskIdentifier() + " " + task.getAmountOfNumbers() + " " + task.getMeasuredTime());
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

        private void printResultToTable(Task task) {
            resultTable.addFinishedTask(task);
        }
    }
}
