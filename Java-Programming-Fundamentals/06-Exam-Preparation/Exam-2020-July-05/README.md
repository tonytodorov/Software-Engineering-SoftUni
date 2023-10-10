# Programming Fundamentals Mid Exam Retake - 05 July 2020

## 1. SoftUni Reception

Every day, thousands of students pass by the reception at SoftUni with different questions to ask. The employees have to help everyone by providing all the information and answering all of the questions.

Three employees are working in the reception all day. Each of them can handle a different number of students per hour. Your task is to calculate how much time it will take to answer all the questions of a given number of students.

First, you will receive 3 lines with integers, representing the number of students that each employee can help per hour. On the following line, you will receive students count as a single integer. 

Every fourth hour, all employees have a break, so they don't work for an hour. It is the only break for the employees, because they don't need rest, nor have a personal life. Calculate the time needed to answer all the student's questions and print it in the following format: "Time needed: {time}h."

### Input
-	On the first three lines -  each employee efficiency -  integer in the range [1 - 100].
-	On the fourth line - students count – integer in the range [0 – 10000].
-	Input will always be valid and in the range specified.

### Output
- Print a single line: "Time needed: {time}h."
- Allowed working time/memory: 100ms / 16MB.


### Examples

| Input  | Output |   
| ------ | ------ |
|   5     |  Time needed: 2h.  |
|   6     |        |
|    4    |        |
|    20    |        |
| Input  | Output |
|   1     |  Time needed: 10h.  |
|   2     |        |
|    3    |        |
|    45    |        |
| Input  | Output |
|   3     |  Time needed: 5h.  |
|   2     |        |
|   5    |        |
|   40    |        |

## 2.	Array Modifier

You are given an array with integers. Write a program to modify the elements after receiving the following commands:
-	"swap {index1} {index2}" takes two elements and swap their places.
-	"multiply {index1} {index2}" takes element at the 1st index and multiply it with the element at 2nd index. Save the product at the 1st index.
-	"decrease" decreases all elements in the array with 1.

### Input
On the first input line, you will be given the initial array values separated by a single space.

On the next lines, you will receive commands until you receive the command "end". The commands are as follows: 
-	"swap {index1} {index2}"
-	"multiply {index1} {index2}"
-	"decrease"

### Output
The output should be printed on the console and consist of elements of the modified array – separated by a comma and a single space ", ".

### Constraints
-	Elements of the array will be integer numbers in the range [-231...231].
-	Count of the array elements will be in the range [2...100].
-	Indexes will be always in the range of the array.

| Input  | Output |
| ------ | ------ |
| 23 -2 321 87 42 90 -123     | 86, 7382, 2369942, -124, 41, 89, -3     |
| swap 1 3     |     |  
| swap 3 6     |     |
| swap 1 0     |     |
| multiply 1 2     |     |  
| multiply 2 1     |     |  
| decrease     |     |  
| end     |     |  
| Input  | Output |
| 1 2 3 4     | 1, 11, 3, 0    |
| swap 0 1     |     |  
| swap 1 2     |     |
| swap 2 3     |     |
| multiply 1 2     |     |  
| decrease     |     |  
| end     |     | 


## 3.	Numbers

Write a program to read a sequence of integers and find and print the top 5 numbers greater than the average value in the sequence, sorted in descending order.

### Input
- Read from the console a single line holding space-separated integers.

### Output
-	Print the above-described numbers on a single line, space-separated. 
-	If less than 5 numbers hold the property mentioned above, print less than 5 numbers. 
-	Print "No" if no numbers hold the above property.

### Constraints
- All input numbers are integers in the range [-1 000 000 … 1 000 000]. 
- The count of numbers is in the range [1…10 000].

### Examples 

| Input  | Output |   
| ------ | ------ |
|   10 20 30 40 50    |          |
| Input  | Output |
|   5 2 3 4 -10 30 40 50 20 50 60 60 51    |        |
| Input  | Output |
|   1     |   No    |
| Input  | Output |
|   -1 -2 -3 -4 -5 -6     |   -1 -2 -3   |



