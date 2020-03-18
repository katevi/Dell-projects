# Multithreading introductory task in Dell mentoring program.

### How to execute program:

1. Open command line in the root of project directory. Enter ```gradle fatJar```

2. Go to the directory ```build/libs/```

3. In ```build/libs``` there is ```Intermediate-concurrency-tutorial-all-1.0-SNAPSHOT.jar
```
4. Execute this from command line by entering 
```java -jar Intermediate-concurrency-tutorial-all-1.0-SNAPSHOT.jar {amount of threads you want} {amount of measurements you want}```

### Description of functionality
In this task trained concurrency problem - work of many threads with one resource. 
1. User enters amount of threads and amount of measures he want. 
2. Program generates table with tasks: amount of tasks is amount of measures. The task is randomly generated array from 10000 to 100000 numbers in size, which need be sorted. To complete the task means to sort array.
3. Program creates given number of threads and starts them.
4. All threads works with table with tasks: each of them goes to the table, takes the first found non-completed and non-took-yet task and starts do it.
5. Threads do their tasks sort their arrays and measures time of sorting.
6. When thread finishes sorting of array, it print result of measure. For instance, for thread number 1, which completed task 2 print will be in such format: "Thread 1 completed task 2: sorted 14859 numbers in 1649.898338 milliseconds. "