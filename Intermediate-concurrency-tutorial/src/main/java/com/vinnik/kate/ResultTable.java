package com.vinnik.kate;

import java.util.Hashtable;

public class ResultTable {
    private volatile int lastTaskIdentifier;
    private final Hashtable<Integer, Task> resultTable;
    private final int amountOfTasksToBeCompleted;

    public ResultTable(int amountOfMeasurements) {
        this.lastTaskIdentifier = 0;
        this.resultTable = new Hashtable();
        this.amountOfTasksToBeCompleted = amountOfMeasurements;
    }

    public synchronized void addCompletedTask(Task task) {
        resultTable.put(lastTaskIdentifier, task);
        if (lastTaskIdentifier < this.amountOfTasksToBeCompleted) {
            this.lastTaskIdentifier++;
        }
    }

    private void printTableElements() {
        for (int i = 0; i < this.resultTable.size(); i++) {
            System.out.println("Thread " + this.resultTable.get(i).getThreadIdentifier() + " completed task " + this.resultTable.get(i).getTaskIdentifier()
                    + ": sorted " + this.resultTable.get(i).getAmountOfNumbers() + " numbers in " + this.resultTable.get(i).getMeasuredTime() + " milliseconds. ");
        }
    }

    public void printResultsInTheThread() {
        Thread printThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printTableElements();
            }
        });
        while (lastTaskIdentifier < amountOfTasksToBeCompleted) {
            try {
                printThread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printThread.start();
    }
}
