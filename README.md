# Multithreading introductory task in Dell mentoring program.

### How to execute program:
1. Please, create executable jar file of this program. Instruction might be found in this link: https://www.jetbrains.com/help/idea/packaging-a-module-into-a-jar-file.html
2. Execute created jar file by entering this command in command line: 
java -jar {name-of-created-jar-file}.jar {amount-of-threads}
3. To restart program with new parameters, reexecute jar file with new amount of threads

### Description of functionality
In this task implemented so-called Multithreading Sorter. It sorts entered by user amount of threads and measures sorting time. The program cycle is described below.
1. User enters amount of threads he/she want
2. Sorter creates given amount of threads 
3. For each thread sorter creates array of 500 random numbers thread needs to sort
4. Sorter starts threads
5. Threads sort their arrays and measures time of sorting.
6. When thread finishes sorting of array, it print result measure. For instance, for thread number 5 print will be in such format: "Thread 5 processed data for 7.782968 milliseconds"