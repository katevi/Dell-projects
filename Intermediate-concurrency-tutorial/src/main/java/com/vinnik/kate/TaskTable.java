package com.vinnik.kate;

import java.util.Hashtable;
import java.util.Random;

public class TaskTable {
    private final static int BOTTOM_BOUND_OF_RANDOM = 10000;
    private final static int UPPER_BOUND_OF_RANDOM = 90000;
    private volatile int lastTaskIdentifier;

    private final Hashtable<Integer, Task> taskTable;

    public TaskTable(int amountOfMeasurements) {
        this.lastTaskIdentifier = 0;
        this.taskTable = this.fillTableWithTasks(amountOfMeasurements);
    }

    public Task getLastTaskIdentifier() {
        return taskTable.get(lastTaskIdentifier);
    }

    public boolean isAllTaskTook() {
        return this.lastTaskIdentifier >= this.taskTable.size();
    }

    public synchronized Task incrementLastTaskIdentifier() {
        if (lastTaskIdentifier < taskTable.size()) {
            this.lastTaskIdentifier++;
            return this.taskTable.get(this.lastTaskIdentifier - 1);
        }
        return null;
    }

    private Hashtable<Integer, Task> fillTableWithTasks(int amountOfMeasurements) {
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
