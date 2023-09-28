# Exercise: Methods

## 1. Smallest of Three Numbers

Write a method to print the smallest of three integer numbers. Use an appropriate name for the method.

### Examples

| Input  | Output |   
| ------ | ------ |
|  2  |  2    |
|  5  |      |
|  3  |      |
| Input  | Output |
|  600  |  123    |
|  342  |      |
|  123  |      |
| Input  | Output |
|  25  |  -21    |
|  -21  |      |
|  4  |      |


## 2. Volews Count

Write a method that receives a single string and prints the count of the vowels. Use an appropriate name for the method.

### Examples

| Input  | Output |   
| ------ | ------ |
| SoftUni     |  3   |
| Input  | Output |  
| Cats      |  1  |
| Input  | Output |  
|  JS      |   0  |

## 3.Characters in Range

Write a method that receives two characters and prints all the characters in between them on a single line according to ASCII.

### Examples 

| Input  | Output |   
| ------ | ------ |
| a     |  b c   |
| d     |     |
| Input  | Output |  
| #     |  $ % & ' ( ) * + , - . / 0 1 2 3 4 5 6 7 8 9  |
| :     |     |
| Input  | Output |  
| C     |  $ % & ' ( ) * + , - . / 0 1 2 3 4 5 6 7 8 9 : ; < = > ? @ A B  |
| #     |     |

## 4.	Password Validator

Write a program that checks if a given password is valid. Password rules are:

-	6 – 10 characters (inclusive);
-	Consists only of letters and digits;
-	Have at least 2 digits.

If a password is valid, print "Password is valid". If it is not valid, for every unfulfilled rule, print a message:

-	"Password must be between 6 and 10 characters"
-	"Password must consist only of letters and digits"
-	"Password must have at least 2 digits"


### Examples

| Input  | Output |   
| ------ | ------ |
|  logIn  |  Password must be between 6 and 10 characters <br> Password must have at least 2 digits   |
| Input  | Output |
|  MyPass123  |  Password is valid   |
| Input  | Output |
|  Pa$s$s  |  Password must consist only of letters and digits <br> Password must have at least 2 digits   |


## 5.	Add and Subtract

You will receive 3 integers. Write a method sum to get the sum of the first two integers and subtract the method that subtracts the third integer from the result from the sum method. 


### Examples

| Input  | Output |   
| ------ | ------ |
|  23  |  19   |
|  6  |      |
|  10  |      |
| Input  | Output |
|  1  |  -12   |
|  17  |      |
|  30  |      |
| Input  | Output |
|  42  |  0    |
|  58  |      |
|  100  |      |


## 6.	Middle Characters

You will receive a single string. Write a method that prints the middle character. 
If the length of the string is even, there are two middle characters.


### Examples

| Input  | Output |   
| ------ | ------ |
| aString    |  r   |
| Input  | Output |  
| someText |  eT  |
| Input  | Output |  
|  3245      |   24  |

## 7.	NxN Matrix

Write a method that receives a single integer n and prints an nxn matrix with that number.

### Examples

| Input  | Output |   
| ------ | ------ |
| 3      |   3 3 3    |
|       |    3 3 3   |
|       |    3 3 3   |
| Input  | Output |
| 7      |   7 7 7 7 7 7 7    |
|       |    7 7 7 7 7 7 7    |
|       |    7 7 7 7 7 7 7    |
|       |    7 7 7 7 7 7 7    |
|       |    7 7 7 7 7 7 7    |
|       |    7 7 7 7 7 7 7    |
|       |    7 7 7 7 7 7 7    |
| Input  | Output |
| 2     |  2 2  |
|       |   2 2   |


## 8.	Factorial Division

Read two integer numbers. Calculate the factorial of each number. Divide the first result by the second and print the division formatted to the second decimal point.

### Examples

| Input  | Output |   
| ------ | ------ |
|  5    |  60.00   |
|  2        |         |
| Input  | Output |
|  6    |  360.00   |
|  2        |         |

## 9.	Palindrome Integers

A palindrome is a number that reads the same backward as forward, such as 323 or 1001. Write a program that reads a positive integer number until you receive "END". For each numbered print, whether the number is palindrome or not.

### Examples

| Input  | Output |   
| ------ | ------ |
|  123   |  false    |
|  323        |  true       |
|  421        |  false   |
|  121        |  true       |
|  END        |         |
| Input  | Output |
|  32   |  false    |
|  2        |  true       |
|  232        |  true   |
|  1010        |  false       |
|  END        |         |

## 10.	Top Number

Read an integer n from the console. Find all top numbers in the range [1 … n] and print them. A top number holds the following properties:

-	Its sum of digits is divisible by 8, e.g. 8, 16, 88.
-	Holds at least one odd digit, e.g. 232, 707, 87578.

### Examples 

| Input  | Output |   
| ------ | ------ |
|  50   |  17   |
|       |  35   |
| Input  | Output |
|  100   |  17   |
|       |  35   |
|       |  53   |
|       |  71   |
|       |  79   |
|       |  97   |