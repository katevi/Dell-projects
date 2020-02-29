package com.vinnik.kate;

/** Class, which implements interaction with user. */
public class Main {
    private final static int MINIMAL_AMOUNT_OF_THREADS = 0;
    public static void main(String[] args) {
        try {
            final int amountOfThreads = Integer.parseInt(args[0]);
            if (amountOfThreads < MINIMAL_AMOUNT_OF_THREADS) {
                System.out.println("Wrong number of threads format. Please, enter positive integer number in such form: \n" +
                        "\"java -jar {name-of-created-jar-file}.jar {amount-of-threads}\"");
            }
            MultithreadingSorter.measureTimeOfSorting(amountOfThreads);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("Please, enter amount of threads. Amount of threads must be in such form:\n" +
                    "\"java -jar {name-of-created-jar-file}.jar {amount-of-threads}\"");
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Wrong number of threads format. Please, enter positive integer number in such form: \n" +
                    "\"java -jar {name-of-created-jar-file}.jar {amount-of-threads}\"");
        } catch (Exception e) {
            System.out.println("Something went wrong in multithreading sorter. To restart, enter command: \n" +
                    "\"java -jar {name-of-created-jar-file}.jar {amount-of-threads}\"");
        }
    }
}
