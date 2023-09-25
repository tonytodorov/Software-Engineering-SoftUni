# More Exercise: Basic Syntax, Conditional Statements and Loops

## 1. Sort Numbers

Read three real numbers and sort them in descending order. Print each number on a new line.

### Examples

| Input  | Output |   
| ------ | ------ |
| 2       |   3   |
| 1       |   2   |
| 3        |   1   |
| Input  | Output |  
| -2       |   3   |
|  1       |   1   |
|  3      |   -2   |
| Input  | Output |  
|  0       |   2   |
|  0       |   0   |
|  0      |    0   |

## 2.	English Name of the Last Digit
   
Write a method that returns the English name of the last digit of a given number.
Write a program that reads an integer and prints the returned value from this method.  

### Examples

| Input  | Output |   
| ------ | ------ |
| 512    | two    |
| Input  | Output |
| 1      | one    |
| Input  | Output |
| 1643   | three  |

## 3.	Gaming Store

Write a program that helps you buy the games. The valid games are the following games in this table:

| Name  | Price |   
| ------ | ------ |
| OutFall 4    | $39.99   |
|  CS: OG  |  $15.99    |
|  Zplinter Zell   |    $19.99      |
| Honored 2  |    $59.99       |
|   RoverWatch |      $29.99    |
|   RoverWatch Origins Edition |      $39.99    |

On the first line, you will receive your current balance – a floating-point number in the range [0.00…5000.00].<br>

Until you receive the command "Game Time", you have to keep buying games. When a game is bought, the user's balance decreases by the price of the game. <br>

Additionally, the program should obey the following conditions:
-	If a game the user is trying to buy is not present in the table above, print "Not Found" and read the next line.
-	If at any point, the user has $0 left, print "Out of money!" and end the program.
-	Alternatively, if the user is trying to buy a game that they can't afford, print "Too Expensive" and read the next line.
  
When you receive "Game Time", print the user's remaining money and total spent on games, rounded to the 2nd decimal place.

### Input
The input comes as a single double number.

### Output
The output is either "Passed!" if the grade is more than 2.99, otherwise, you should print "Failed!".

### Examples

| Input  | Output |   
| ------ | ------ |
| 120   |     Bought RoverWatch    |
|  RoverWatch |     Bought Honored 2      |
| Honored 2  |   Total spent: $89.98. Remaining: $30.02    |
|   Game Time |                                            |
| Input  | Output |  
| 19.99  |     Not Found    |
|  Reimen Origins |   Too Expensive     |
|  RoverWatch |     Bought  Zplinter Zell    |
| Zplinter Zell  |   Out of mo-ney!    |
|   Game Time |                                            |
| Input  | Output |  
| 19.99  |      Bought OutFall 4     |
|  OutFall 4 |   Bought  RoverWatch Origins Edition     |
|   RoverWatch Origins Edition |     Total spent: $79.98. Remaining: $0.01     |
| Zplinter Zell  |                                |
|   Game Time |                                            |


## 4.	Reverse String
   
Write a program that reverses a string and prints it on the console.

### Examples

| Input  | Output |   
| ------ | ------ |
| Hello      | olleH   |
| Input  | Output |
| SoftUni     | inUtfoS  |
| Input  | Output |
| 1234      | 4321   |


## 5.	Messages

Write a program that emulates typing an SMS, following this guide:

| 1  <br>    |    2 <br>abc   |      3  <br> def |  
| ------ | ------ |  ---------|
| 4  <br> ghi   |    5  <br> jkl |      6 <br> mno    |  
| 7   <br> pqrs   |    8 <br> tuv  |      9 <br> wxyz  |  
|      |    0 <br> space   |        |  

Following the guide, 2 becomes "a", 22 becomes "b" and so on.


### Examples

| Input  | Output |   
| ------ | ------ |
| 5       |   hello   |
| 44        |     |
| 33        |     |
| 555        |     |
| 555        |     |
| 666        |      |
| Input  | Output |  
| 9       |   hey there   |
| 44        |     |
| 33        |     |
| 999        |     |
| 0        |     |
| 8        |      |
| 44        |     |
| 33        |     |
| 777        |     |
| 33        |      |
| Input  | Output |  
| 7       |   meet me  |
| 6        |     |
| 33        |     |
| 33        |     |
| 8       |     |
| 0        |      |
| 66        |     |
| 33        |     |
