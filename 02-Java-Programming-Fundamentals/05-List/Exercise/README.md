# Exercise: Lists

## 1. Train

On the first line, you will be given a list of wagons (integers). Each integer represents the number of passengers that are currently in each wagon.
On the next line, you will get the max capacity of each wagon (single integer). Until you receive "end" you will be given two types of input:

-	Add {passengers} - add a wagon to the end with the given number of passengers
-	{passengers} -  find an existing wagon to fit all the passengers (starting from the first wagon)

In the end, print the final state of the train (all the wagons separated by a space)

### Examples

| Input  | Output |   
| ------ | ------ |
| 32 54 21 12 4 0 23  |  72 54 21 12 4 75 23 10 0    |
|  75           |          |
|  Add 10      |          |
|  Add 0      |          |
|  30      |          |
|  10    |          |
|  75    |          |
|  end    |          |
| Input  | Output |
| 0 0 0 10 2 4  |  10 10 10 10 10 10 10    |
|  10           |          |
|  Add 10      |          |
|  10     |          |
|  10      |          |
|  8    |          |
|  6    |          |
|  end    |          |


## 2.	Change List

Write a program that reads a list of integers from the console and receives commands which manipulate the list. Your program may receive the following commands: 

-	Delete {element} - delete all elements in the array which are equal to the given element
-	Insert {element} {position} - insert element at the given position

You should stop the program when you receive the command "end". Print all numbers in the array, separated with a single whitespace.

| Input  | Output |
| ------ | ------ |
| 1 2 3 4 5 5 5 6 |  1 10 2 3 4 6    |
|  Delete 5          |          |
|  Insert 10 1      |          |
|  Delete 5     |          |
|  end    |          |
| Input  | Output |
| 20 12 4 319 21 31234 2 41 23 4 |  20 12 50 319 50 21 31234 2 41 23    |
|  Insert 50 2          |          |
|  Insert 50 5      |          |
|  Delete 4     |          |
|  end    |          |

## 3.	House Party

Write a program that keeps track of guests going to a house party. 

On the first input line, you are going to receive how many commands you are going to have. 
On the next lines you are going to receive some of the following inputs:

- "{name} is going!"
-	"{name} is not going!"

If you receive the first type of input, you have to add the person if he/she is not on the list. 
If he/she is in the list, print on the console: "{name} is already in the list!". 
If you receive the second type of input, you must remove the person if he/she is on the list. 
If not, print: "{name} is not in the list!". In the end, print all guests.

### Examples 

| Input  | Output |   
| ------ | ------ |
|  4     |        |
|  Allie is going!     |    John is not in the list!    |
|  George is going!     |    Allie    |
|  John is not going!     |        |
|  George is not going!     |        |
| Input  | Output |
|  5     |        |
|  Tom is going!     |    Tom is already in the list!    |
|  Annie is going!     |    Tom    |
|  Tom is going!     |    Annie    |
|  Garry is  going!     |   Garry     |
|  Jerry is  going!     |    Jerry    |


## 4.	List Operations
You will be given numbers (a list of integers) on the first input line. Until you receive "End" you will
be given operations you must apply on the list. The possible commands are:

-	Add {number} - add number at the end
-	Insert {number} {index} - insert number at given index
-	Remove {index} - remove that index
-	Shift left {count} - first number becomes last 'count' times
-	Shift right {count} - last number becomes first 'count' times
-	
Note: The index given may be outside the array's bounds. In that case, print "Invalid index".

### Examples

| Input  | Output |   
| ------ | ------ |
| 1 23 29 18 43 21 20       | 43 20 5 1 23 29 18     |
| Add 5     |       |
| Remove 5       |       |
| Shift left 3      |       |
| Shift left 1      |       |
| End    |       |
| Input  | Output |  
| 12 34 100 1 45 2 8     |  Invalid index     |
| Insert 3 0     |  5 12 42 95 32 8 1 3     |
| Remove 10      |       |
| Insert 8 6      |       |
| Shift right 1     |       |
| Shift left 2       |       |
| end    |       |

## 5.	Bomb Numbers
Write a program that reads a sequence of numbers and a special bomb number with a certain power. 
Your task is to detonate every occurrence of the special bomb number and according to its power -
his neighbors from left and right. Detonations are performed from left to right, and all detonated 
numbers disappear. Finally, print the sum of the remaining elements in the sequence.

### Examples

| Input  | Output |   
| ------ | ------ |
| 1 2 2 4 2 2 2 9    |   12  |
| 4 2   |     |
| Input  | Output |  
| 1 4 4 2 8 9 1    |   5  |
| 9 3   |     |
| Input  | Output |  
| 1 7 7 1 2 3   |  6     |
| 7 1   |     |
| Input  | Output |  
| 1 1 2 1 1 1 2 1 1 1   |  4     |
| 2 1     |        |

## 6.	Cards Game
You will be given two hands of cards, which will be integer numbers. Assume that you have two players. 
You must find the winning deck and, respectively, the winner.

You start from the beginning of both hands. Compare the cards from the first deck to those from the second. 
The player, who has a bigger card, takes both cards and puts them on the back of his hand - the second player's card 
is last, and the first person's card (the winning one) is before it (second to last), and the player with the smaller 
card must remove the card from his deck. If both players' cards have the same values - no one wins, and the two cards
must be removed from the decks. The game is over when one of the decks is left without any cards. You have to print the 
winner on the console and the sum of the left cards: "{First/Second} player wins! Sum: {sum}".

### Examples

| Input  | Output |   
| ------ | ------ |
| 20 30 40 50 <br> 10 20 30 40    |  First player wins! Sum: 240   |
| Input  | Output |  
| 10 20 30 40 50 <br> 50 40 30 30 10    |  Second player wins! Sum: 50   |

## 7.	Append Arrays

Write a program to append several arrays of numbers.

-	Arrays are separated by "|".
-	Values are separated by spaces (" ", one or several).
-	Order the arrays from the last to the first and their values from left to right.

### Examples

| Input  | Output |   
| ------ | ------ |
|  1 2 3 \|4 5 6  \|  7  8  |  7 8 4 5 6 1 2 3   |
| Input  | Output |
|  7 \| 4  5\|1 0 \| 2 5 \|3 |  3 2 5 1 0 4 5 7     |
| Input  | Output |
| 1\| 4 5 6 7  \|  8 9 |  8 9 4 5 6 7 1   |
