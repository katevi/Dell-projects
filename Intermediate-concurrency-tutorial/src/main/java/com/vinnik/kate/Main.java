package com.vinnik.kate;

/** Class, which implements interaction with user. */
public class Main {
    private final static int MINIMAL_AMOUNT_OF_THREADS = 0;
    private static final int MINIMAL_AMOUNT_OF_MEASUREMENTS = 0;

    private static void printMessageAboutIncorrectInput() {
        System.out.println("Incorrect input format. Please, enter positive integer number of threads and measurements in such form: \n" +
                "\"java -jar {name-of-created-jar-file}.jar {amount-of-threads} {amount-of-measurements}\"");
    }

    public static void main(String[] args) {
        try {
            final int amountOfThreads = Integer.parseInt(args[0]);
            final int amountOfMeasurements = Integer.parseInt(args[1]);

            if (amountOfThreads < MINIMAL_AMOUNT_OF_THREADS || amountOfMeasurements < MINIMAL_AMOUNT_OF_MEASUREMENTS) {
                printMessageAboutIncorrectInput();
            }

            System.out.println("Amount of threads is " + amountOfThreads + ", amount of measurements is " + amountOfMeasurements + ".");

            final TaskExecutor executor = new TaskExecutor(amountOfThreads, amountOfMeasurements);
            executor.measureTasksCompletionTime();
            executor.printMeasures();

        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            printMessageAboutIncorrectInput();
        } catch (java.lang.NumberFormatException e) {
            printMessageAboutIncorrectInput();
        } catch (Exception e) {
            System.out.println("Something went wrong in multithreading sorter. To restart, enter command: \n" +
                    "\"java -jar {name-of-created-jar-file}.jar {amount-of-threads} {amount-of-measurements}\"");
        }
    }
}
