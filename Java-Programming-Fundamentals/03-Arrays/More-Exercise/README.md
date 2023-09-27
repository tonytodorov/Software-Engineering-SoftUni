# More Exercise: Arrays

## 1.	Encrypt, Sort and Print Array

Write a program that reads a sequence of strings from the console. Encrypt every string by summing:

-	The code of each vowel multiplied by the string length.
-	The code of each consonant is divided by the string length.

Sort the number sequence in ascending order and print it on the console.

On the first line, you will always receive the number of strings you must read

### Examples

| Input  | Output |   
| ------ | ------ |
| 4           |   1032    |
| Peter       |   1071    |
| Maria       |   1168    |
| Katya       |   1532    |
| Todor       |           |
| Input  | Output |  
| 3           |   1396    |
| Sofia       |   1601    |
| London      |   3202    |
| Washington  |           |

## 2.	Pascal Triangle
   
The triangle may be constructed in the following manner: In row 0 (the topmost row), 
there is a unique nonzero entry 1. Each entry of each subsequent row is constructed by
adding the number above and to the left with the number above and to the right, treating
blank entries as 0. For example, the initial number in the first (or any other) row is 1 
(the sum of 0 and 1), whereas the numbers 1 and 3 in the third row are added to produce 
the number 4 in the fourth row.

Print each row element, separated with whitespace.

### Examples

| Input  | Output |   
| ------ | ------ |
| 4      |  1    |
|     |   1 1     |
|       |   1 2 1     |
|       |    1 3 3 1    |
| Input  | Output |
| 13      |  1    |
|     |     1 1     |
|       |   1 2 1     |
|       |    1 3 3 1    |
|     |     1 4 6 4 1     |
|       |  1 5 10 10 5 1     |
|       |   1 6 15 20 15 6 1    |
|     |     1 7 21 35 35 21 7 1     |
|       |  1 8 28 56 70 56 28 8 1     |
|       |    1 9 36 84 126 126 84 36 9 1     |
|     |    1 10 45 120 210 252 210 120 45 10 1      |
|       |   1 11 55 165 330 462 462 330 165 55 11 1     |
|       |   1 12 66 220 495 792 924 792 495 220 66 12 1      |

## 3.	Recursive Fibonacci

The Fibonacci sequence is quite a famous sequence of numbers. Each sequence member is calculated from the sum of the two previous elements. 
The first two elements are 1, 1. Therefore the sequence goes like 1, 1, 2, 3, 5, 8, 13, 21, 34…

The following sequence can be generated with an array, but that's easy, so your task is to implement it recursively.

So if the function GetFibonacci(n) returns the n’th Fibonacci number we can express it using GetFibonacci(n) = GetFibonacci(n-1) + GetFibonacci(n-2).

However, this will never end and in a few seconds, a StackOverflow Exception is thrown. For the recursion to stop, 
it has to have a "bottom". At the bottom of the recursion is GetFibonacci(2) should return 1, and GetFibonacci(1) should return 1.

### Input
-	The user should enter the wanted Fibonacci number on the only line in the input.

### Output
-	The output should be the n'th Fibonacci number counting from 1.

### Constraints
-	1 ≤ N ≤ 50

### Examples 

| Input  | Output |   
| ------ | ------ |
| 5   | 5     |
| Input  | Output |
| 10     | 55    |
| Input  | Output |
| 21    | 10946     |

## 4.	Longest Increasing Subsequence (LIS)
   
Read a list of integers and find the longest increasing subsequence (LIS). If several such exist, print the leftmost.

### Examples

| Input  | Output |   
| ------ | ------ |
|  1    | 1 |
| Input  | Output |
| 7 3 5 8 -1 0 6 7    | 3 5 6 7  |
| Input  | Output |
| 7 3 5 8 -1 0 6 7    | 3 5 6 7  |
| Input  | Output |
| 1 2 5 3 5 2 4 1    | 1 2 3 5  |
| Input  | Output |
|0 10 20 30 30 40 1 50 2 3 4 5 6    | 0 1 2 3 4 5 6  |
| Input  | Output |
| 11 12 13 3 14 4 15 5 6 7 8 7 16 9 8   | 3 4 5 6 7 8 16  |
| Input  | Output |
| 3 14 5 12 15 7 8 9 11 10 1    | 3 5 7 8 9 11  |

## 5.	Kamino Factory

The clone factory in Kamino got another order to clone troops. But this time, you are tasked 
to find the best DNA sequence to use in the production. 

You will receive the DNA length, and until you receive the command "Clone them!" you will be 
receiving DNA sequences of ones and zeroes, split by "!" (one or several).

You should select the sequence with the longest subsequence of ones. If there are several 
sequences with the same length of a subsequence of ones, print the one with the leftmost 
starting index, if there are several sequences with the same length and starting index, 
select the sequence with the greater sum of its elements.

After you receive the last command "Clone them!", you should print the collected information in the following format:

"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
"{DNA sequence, joined by space}"

### Input/Constraints
- The first line holds the length of the sequences – integer in the range [1…100].
- On the next lines, until you receive "Clone them!" you will be receiving sequences (at least one) of ones and zeroes, split by "!" (one or several).

### Output
The output should be printed on the console and consists of two lines in the following format:
"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
"{DNA sequence, joined by space}"

### Examples

| Input  | Output |   
| ------ | ------ |
| 5         |   Best DNA sample 2 with sum: 2. <br> 0 1 1 0 0  |
| 1!0!1!1!0 |      |
| 0!1!1!0!0 |      |
| Clone them!     |      |
| Input  | Output |
| 4         |   Best DNA sample 1 with sum: 3. <br> 1 1 0 1 |
| 1!1!0!1 |      |
| 1!0!0!1 |      |
| 1!1!0!0 |      |
| Clone them!     |      |

## 6.	LadyBugs

You are given a field size and the indexes of ladybugs inside the field. After that, on every new line, 
until the "end" command is given, a ladybug changes its position to its left or right by a given fly length. 

A command to a ladybug looks like this: "0 right 1". This means that the little insect placed on index 0 
should fly one index to its right. If the ladybug lands on a fellow ladybug, it continues to fly in the same 
direction by the same fly length. If the ladybug flies out of the field, it is gone.

For example, imagine you are given a field with size 3 and ladybugs on indexes 0 and 1. If the ladybug on index 0 needs to 
fly to its right by the length of 1 (0 right 1) it will attempt to land on index 1, but as there is another ladybug there,
it will continue further to the right by an additional length of 1, landing on index 2. After that, if the same ladybug
needs to fly to its right by the length of 1 (2 right 1), it will land somewhere outside of the field, so it flies away.

If you are given a ladybug index that does not have a ladybug there, nothing happens. 
If you are given a ladybug index that is outside the field, nothing happens.

Your job is to create the program, simulating the ladybugs flying around doing nothing. 
In the end, print all cells in the field separated by blank spaces. For each cell that has 
a ladybug on it print '1' and for each empty cell print '0'. For the example above, the output should be '0 1 0'. 

### Input
-	On the first line, you will receive an integer - the size of the field.
-	On the second line, you will receive the initial indexes of all ladybugs separated by a blank space. The given indexes may or may not be inside the field range.
-	On the next lines, until you get the "end" command you will receive commands in the format: "{ladybug index} {direction} {fly length}".

### Output
-	Print the all cells within the field in format: "{cell} {cell} … {cell}"
-	If a cell has a ladybug in it, print '1'.
-	If a cell is empty, print '0' .

### Constraints
-	The size of the field and number of commands will be in the range [0 … 1000].
-	The ladybug indexes and fly length will be in the range [-2,147,483,647 … 2,147,483,647].

### Examples

| Input  | Output |   
| ------ | ------ |
| 3      |  0 1 0      |
| 0 1      |        |
| 0 right 1      |        |
| 2 right 1      |        |
| end     |        |
| Input  | Output |
| 3      |  0 0 0      |
| 0 1 2     |        |
| 0 right 1      |        |
| 1 right 1      |        |
| 2 right 1      |        |
| end     |        |
| end     |        |
| Input  | Output |
| 5      |  0 0 0 1 0      |
| 3     |        |
| 3 left 2      |        |
| 1 left -2      |        |
| end     |        |
