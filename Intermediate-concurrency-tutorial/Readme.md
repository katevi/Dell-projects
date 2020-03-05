# Multithreading introductory task in Dell mentoring program.

### How to execute program:
1. Please, create executable jar file of this program. Instruction might be found in this link: https://www.jetbrains.com/help/idea/packaging-a-module-into-a-jar-file.html
2. Execute created jar file by entering this command in command line: 
"java -jar {name-of-created-jar-file}.jar {amount-of-threads} {amount-of-measurements}"
3. To restart program with new parameters, reexecute jar file with new amount of threads

### Description of functionality
In this task trained concurrency problem - work of many threads with one resource. 1. User enters amount of threads and amount of measures he want. 
2. Program generates table with tasks: amount of tasks is amount of measures. The task is randomly generated array from 10000 to 100000 numbers in size, which need be sorted. To complete the task means to sort array.
3. Program creates given number of threads and starts them.
4. All threads works with table with tasks: each of them goes to the table, takes the first found non-completed and non-took-yet task and starts do it.
5. Threads do their tasks sort their arrays and measures time of sorting.
6. When thread finishes sorting of array, it print result of measure. For instance, for thread number 1, which completed task 2 print will be in such format: "Thread 1 completed task 2: sorted 14859 numbers in 1649.898338 milliseconds. "