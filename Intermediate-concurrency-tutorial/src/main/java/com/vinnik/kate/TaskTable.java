package com.vinnik.kate;

import java.util.Hashtable;
import java.util.Random;

/** This class generates and stores table with tasks:
 *  task is array of random length within random numbers, which needs to be sorted
 *  task considered completed, when array sorted. */
public final class TaskTable {
    private final static int BOTTOM_BOUND_OF_RANDOM = 10000;
    private final static int UPPER_BOUND_OF_RANDOM = 90000;
    private volatile int lastTaskIdentifier;

    private final Hashtable<Integer, Task> taskTable;

    public TaskTable(int amountOfMeasurements) {
        this.lastTaskIdentifier = 0;
        this.taskTable = this.fillTableWithTasks(amountOfMeasurements);
    }

    /** Checks if all tasks have took by some thread. */
    public boolean isAllTaskTook() {
        return this.lastTaskIdentifier >= this.taskTable.size();
    }

    /** Returns last not took by any thread task and increments last task flag. */
    public synchronized Task popLastTaskIdentifier() {
        if (lastTaskIdentifier < taskTable.size()) {
            this.lastTaskIdentifier++;
            return this.taskTable.get(this.lastTaskIdentifier - 1);
        }
        return null;
    }

    /** Returns current size of taskTable. */
    public int getSize() {
        return taskTable.size();
    }

    private Hashtable<Integer, Task> fillTableWithTasks(final int amountOfMeasurements) {
        final Hashtable<Integer, Task> tableWithTasks = new Hashtable<>();
        for (int i = 0; i < amountOfMeasurements; i++) {
            tableWithTasks.put(i, new Task(i, this.generateRandom()));
        }
        return tableWithTasks;
    }

    private int generateRandom() {
        final Random random = new Random();
        return (BOTTOM_BOUND_OF_RANDOM + random.nextInt(UPPER_BOUND_OF_RANDOM));
    }
}
