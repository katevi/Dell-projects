package com.vinnik.kate;

import java.util.Hashtable;

public final class ResultTable {
    private volatile int lastCompletedTaskIdentifier;
    private final Hashtable<Integer, Task> resultTable;
    private final int amountOfTasksToBeCompleted;

    /** By given amount of measurements creates empty hash table for adding completed task in it,
     *  amount of tasks, which should be completed, number of tasks, which completed already.
     * @param amountOfMeasurements - amount of tasks, which should be completed. */
    public ResultTable(final int amountOfMeasurements) {
        this.lastCompletedTaskIdentifier = 0;
        this.resultTable = new Hashtable();
        this.amountOfTasksToBeCompleted = amountOfMeasurements;
    }

    /** When thread completes the task, it adds measurements to result table. */
    public synchronized void addCompletedTask(final Task task) {
        resultTable.put(lastCompletedTaskIdentifier, task);
        if (lastCompletedTaskIdentifier < this.amountOfTasksToBeCompleted) {
            this.lastCompletedTaskIdentifier++;
        }
    }

    /** Returns current size of resultTable. */
    public int getSize() {
        return resultTable.size();
    }

    /** Print information about all elements of resultTable (all completed tasks). */
    public void printTableElements() {
        for (int i = 0; i < this.resultTable.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append(this.resultTable.get(i).getThreadIdentifier());
            stringBuilder.append(" completed task ");
            stringBuilder.append(this.resultTable.get(i).getTaskIdentifier());
            stringBuilder.append(": sorted ");
            stringBuilder.append(this.resultTable.get(i).getAmountOfNumbers());
            stringBuilder.append(" numbers in ");
            stringBuilder.append(this.resultTable.get(i).getMeasuredTime());
            stringBuilder.append(" milliseconds. ");
            System.out.println(stringBuilder);
        }
    }
}
