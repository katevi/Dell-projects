The program takes 1 arguments:
java -jar program.jar <amount_of_threads>
* amount_of_threads - int value representing amount of threads that'd be used.

We have N threads, each of them has a unique identifier- a number (0, 1, ...). Each thread should generate an array that consists of 500 random integer values, for example: [10, 324, 3, 2929, .... , 992]. Then, a thread should sort this in ascending order. The time of the sorting should be measured.
When the thread finishes sorting, it should output the result in the following format: "<thread_identifier> - <time_taken_for_sorting_milliseconds>".# Dell-projects