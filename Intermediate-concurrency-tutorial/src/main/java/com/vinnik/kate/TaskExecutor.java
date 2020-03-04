package com.vinnik.kate;

public class TaskExecutor {
    private ResultTable resultTable;

    public TaskExecutor(int amountOfThreads) {
        for (int i = 0; i < amountOfThreads; i++) {
            //Thread thread = new Thread();
        }
        //!!!!
        resultTable.printResults();
    }

    private class Thread implements Runnable {
        private final Task task;

        private Thread(Task task) {
            this.task = task;
        }

        @Override
        public void run() {

        }

        private void printResultToTable(Task task) {
            resultTable.addFinishedTask(task);
        }
    }
}
