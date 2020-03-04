package com.vinnik.kate;

import java.util.Hashtable;

public class ResultTable {
    private Hashtable<Integer, Task> resultTable;

    public void addFinishedTask(Task task) {
        resultTable.put(resultTable.size() + 1, task);
    }

    public void printResults() {
        for (int i = 0; i < resultTable.size(); i++) {
            System.out.println(resultTable.get(i).getThreadIdentifier() + " " + resultTable.get(i).getTaskIdentifier()
                    + resultTable.get(i).getAmountOfNumbers() + resultTable.get(i).getMeasuredTime());
        }
    }
}
