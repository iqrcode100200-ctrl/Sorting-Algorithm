#Comparison between the different sorting algorithms

This project is mainly about distinguishing the differences between the sorting algorithms by the number of comparison and time taken to sort a given array
This project uses five known sorting algorithms:
-Bubble Sort
-Selection Sort
-Insertion Sort
-Merge Sort
-Quick Sort

in order to be able to distinguish the differences between the different sorting algorithms:
-measure the time taken by each sorting algorithm(Time complexity)
-Number of comparisons done by each algorithm
-appending the size of the array in record.txt(done)

All the sorted array,ite time taken and the number of comparisons performed will be stored in a record.txt file which will be analysed by the user.
But we can notice something that record.txt will simply store all the sorting algorithm, its size, the unsorted array, time taken and number of of comparison.
But here, our aim is to distingush between the different sorting algorithm therefore ,
- method if the array size and sorting algorithm is same, do not append to record.txt , in order to avoid any duplicate entries(fourth feature)- there will be a condition in every case. The condition is that if a sorting algorithm 
-the user will have an option to open the record.text file in order to 
-the user will have an option whether they want to save the sorted array or not

The first feature -measurement of exxecution time
we will use the method System.nanoTime() for different lengths of arrays that calculates y capturing the start time and end time
The reason the datatype is long is because of precise timing-miliseconds

The second feature- in order to count the number of comparisons(adjacent elements) made by each sorting algorithm, we will initialise a variable comparisons and it will be incremented after each run.

The third feature
The method will read the file content of record.txt and check if the entry already exists.

note : add time complexity of every sorting algorithm
Doing the implementation of different sorting algorithms by using  different input size(n), helps us for the measurement of an algorithm's efficiency using time and space complexity

Improvement-after doing the basics
After doing the console-based, we can make it more interactive by integrating gui java swing.
The gui version will be in the same order as the console-based.
Integration of graphs for better readability.
