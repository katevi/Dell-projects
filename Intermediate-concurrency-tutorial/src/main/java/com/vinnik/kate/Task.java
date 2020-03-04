package com.vinnik.kate;

public class Task {
    private final int taskIdentifier;
    private final int amountOfNumbers;
    private int threadIdentifier;
    private double measuredTime;

    public Task(int taskIdentifier, int amountOfNumbers) {
        this.taskIdentifier = taskIdentifier;
        this.amountOfNumbers = amountOfNumbers;
        this.threadIdentifier = 0;
        this.measuredTime = 0;
    }

    public double getMeasuredTime() {
        return measuredTime;
    }

    public int getAmountOfNumbers() {
        return amountOfNumbers;
    }

    public int getTaskIdentifier() {
        return taskIdentifier;
    }

    public int getThreadIdentifier() {
        return threadIdentifier;
    }

    public void setThreadIdentifier(int threadIdentifier) {
        this.threadIdentifier = threadIdentifier;
    }

    public void setMeasuredTime(double measuredTime) {
        this.measuredTime = measuredTime;
    }
}
