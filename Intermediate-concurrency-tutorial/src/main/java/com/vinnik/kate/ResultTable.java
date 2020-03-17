package com.vinnik.kate;

import java.util.Hashtable;

public final class ResultTable {
    private volatile int lastCompletedTaskIdentifier;
    private final Hashtable<Integer, Task> resultTable;
    private final int amountOfTasksToBeCompleted;

    /** By given amount of measurements creates empty hash table for adding completed task in it,
     *  amount of tasks, which should be completed, number of tasks, which completed already.
     * @param amountOfMeasurements - amount of tasks, which should be completed. */
    public ResultTable(int amountOfMeasurements) {
        this.lastCompletedTaskIdentifier = 0;
        this.resultTable = new Hashtable();
        this.amountOfTasksToBeCompleted = amountOfMeasurements;
    }

    /** When thread completes the task, it adds measurements to result table. */
    public synchronized void addCompletedTask(Task task) {
        resultTable.put(lastCompletedTaskIdentifier, task);
        if (lastCompletedTaskIdentifier < this.amountOfTasksToBeCompleted) {
            this.lastCompletedTaskIdentifier++;
        }
    }

    public int getSize() {
        return resultTable.size();
    }

    public void printTableElements() {
        for (int i = 0; i < this.resultTable.size(); i++) {
            System.out.println("Thread " + this.resultTable.get(i).getThreadIdentifier() + " completed task " + this.resultTable.get(i).getTaskIdentifier()
                    + ": sorted " + this.resultTable.get(i).getAmountOfNumbers() + " numbers in " + this.resultTable.get(i).getMeasuredTime() + " milliseconds. ");
        }
    }
}
