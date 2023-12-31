# More Exercise: Methods

## 1. Data Types

Write a program that, depending on the first line of the input, reads an int, double, or string.

-	If the data type is int, multiply the number by 2.
-	If the data type is real, multiply the number by 1.5 and format it to the second decimal point.
-	If the data type is a string, surround the input with "$".

Print the result on the console.

### Examples

| Input  | Output |   
| ------ | ------ |
|  int  |  10    |
|  5  |      |
| Input  | Output |
|  real  |  3.00    |
|  2  |      |
| Input  | Output |
|  String  |  `$hello$`   |
|  hello  |      |


## 2.	Center Point

You are given the coordinates of two points on a Cartesian coordinate system - X1, Y1, X2, and Y2. Create a method that prints the point that is closest to the center of the coordinate system (0, 0) in the format (X, Y). If the points are at the same distance from the center, print only the first one.

### Examples

| Input  | Output |   
| ------ | ------ |
|  2  |  (-1, 2)    |
|  4  |      |
|  -1  |      |
|  2  |      |
| Input  | Output |
|  4  |  (4, -2)    |
|  -2  |      |
|  5  |      |
|  1  |      |

## 3. Longer Line

You are given the coordinates of four points in the 2D plane. The first and the second pair of points form two different lines. Print the longer line in the format "(X1, Y1)(X2, Y2)" starting with the point that is closer to the center of the coordinate system (0, 0) (You can reuse the method that you wrote for the previous problem). If the lines are of equal length, print only the first one.

### Examples 

| Input  | Output |   
| ------ | ------ |
|  2  |  (4, -3)(-5, -5)    |
|  4  |      |
|  -1  |     |
|  2  |      |
|  -5  |      |
|  -5  |      |
|  4  |     |
|  -3  |      |
| Input  | Output |
|  4  |  (-2, -1)(4, 6)    |
|  6  |      |
|  -2  |      |
|  -1  |      |
|  2  |     |
|  4  |      |
|  7  |      |
|  3  |      |

## 4.	Tribonacci Sequence

In the "Tribonacci" sequence, every number is formed by the sum of the previous 3.

You are given a number num. Write a program that prints num numbers from the Tribonacci sequence, each on a new line, starting from 1. The input comes as a parameter named num. The value num will always be a positive integer.


### Examples

| Input  | Output |   
| ------ | ------ |
| 4      |  1 1 2 4   |
| Input  | Output |  
| 8      |  1 1 2 4 7 13 24 44  |


## 5. Multiplication Sign

You are given a number num1, num2, and num3. Write a program that finds if num1 * num2 * num3 (the product) is negative, positive, or zero. Try to do this WITHOUT multiplying the 3 numbers.

### Examples

| Input  | Output |   
| ------ | ------ |
| 2      | negative        |
| 3      |        |
| -1     |        |
| Input  | Output |  
| 2      | positive        |
| 3      |        |
| -1     |        | 



## 6.	Array Manipulator

Trifon has finally become a junior developer and has received his first task. It's about manipulating an array of integers. He is not quite happy about it, since he hates manipulating arrays. They will pay him a lot of money, though, and he is willing to give somebody half of it if to help him do his job. You, on the other hand, love arrays (and money) so you decide to try your luck.

The array may be manipulated by one of the following commands:

<ul>
    <li>    exchange {index} – splits the array after the given index and exchanges the places of the two resulting subarrays. E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3] </li>
     <ul>
	    <li >   If the index is outside the boundaries of the array, print "Invalid index". </li>
    </ul>
    <li>    max even/odd – returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4 </li>
    <li>	min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even > print 3 </li>
    <ul>
            <li>    If there are two or more equal min/max elements, return the index of the rightmost one. </li>
            <li>	If a min/max even/odd element cannot be found, print "No matches". </li>
    </ul>
    <li>	first {count} even/odd – returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2] </li>
    <li>	last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3] </li>
    <ul>
        <li>If the count is greater than the array length, print "Invalid count".</li>
        <li>If there are not enough elements to satisfy the count, print as many as you can. If there are zero even/odd elements, print an empty array "[]".</li>
    </ul>
    <li> end – stop taking input and print the final state of the array. </li>
</ul>


### Input
-	The input data should be read from the console.
-	On the first line, the initial array is received as a line of integers, separated by a single space.
-	On the next lines, until the command "end" is received, you will receive the array manipulation commands.
-	The input data will always be valid and in the format described. There is no need to check it explicitly.

### Output
-	The output should be printed on the console.
-	On a separate line, print the output of the corresponding command.
-	On the last line, print the final array in square brackets with its elements separated by a comma and a space. 
-	See the examples below to get a better understanding of your task.

### Constraints
-	The number of input lines will be in the range [2 … 50].
-	The array elements will be integers in the range [0 … 1000].
-	The number of elements will be in the range [1 ... 50].
-	The split index will be an integer in the range [-231 … 231 – 1].
-	The first/last count will be an integer in the range [1 … 231 – 1].
-	There will not be redundant whitespace anywhere in the input.
-	Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.


### Examples

| Input  | Output |   
| ------ | ------ |
| 1 3 5 7 9      |   2   |
|   exchange 1    |   No matches    |
|    max odd   |   [5, 7]   |
|    min even    |  []     |
|    first 2 odd   |  [3, 5, 7, 9, 1]    |
|    last 2 even   |      |
|   exchange 3    |       |
|   end   |       |
| Input  | Output |
| 1 10 100 1000     |  3   |
|   max even   |   Invalid count  |
|    first 5 even   |   Invalid index   |
|    exchange 10    |  0     |
|    min odd  |  2    |
|    exchange 0   |   0   |
|   max even    |    [10, 100, 1000, 1]   |
|   min even   |       |
|   end   |       |
| Input  | Output |
| 1 10 100 1000     |  [1]     |
|    exchange 3   |    [1]    |
|    first 2 odd  |    [1, 10, 100, 1000]    |
|    last 4 odd   |        |
|    end   |        |
