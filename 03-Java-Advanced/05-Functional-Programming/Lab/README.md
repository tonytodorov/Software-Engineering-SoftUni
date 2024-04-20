# Lab: Functional Programming

## 1.	Sort Even Numbers
Write a program that reads one line of Integers separated by ", ". 
-	Print the even numbers.
-	Sort them in ascending order. 
-	Print them again.

### Examples

| Input  | Output |   
| ------ | ------ |
| 4, 2, 1, 3, 5, 7, 1, 4, 2, 12	| 4, 2, 4, 2, 12 <br> 2, 2, 4, 4, 12  |
| 1, 3, 5	|        |
| 2, 4, 6	| 2, 4, 6 <br> 2, 4, 6  |

##  2.	Sum Numbers
Write a program that reads one line of Integers separated by ", ". Print the count of the numbers and their sum.

### Examples
| Input  | Output |   
| ------ | ------ |
| 4, 2, 1, 3, 5, 7, 1, 4, 2, 12	| Count = 10 <br> Sum = 41  |
| 2, 4, 6	| Count = 3 <br> Sum = 12  |

## 3.	Count Uppercase Words
Write a program that reads one line of text from the console. Print the count of words that start with an Uppercase letter, after that print all these words in the same order as you found them in the text.

### Examples 

| Input  | Output |   
| ------ | ------ |
| The following example shows how to use Predicate    | 2 <br> The <br> Predicate |
| Write a program that reads one line of text from console. Print count of words that start with Uppercase, after that print all those words in the same order like you find them in text. |3 <br> Write <br> Print <br> Uppercase |

## 4. Add VAT
Write a program that reads one line of Double prices separated by ", ". Print the prices with added VATs for all of them. Format them to the 2nd digit after the decimal point. The order of the prices must remain the same.


### Examples
| Input  | Output |   
| ------ | ------ |
|1.38, 2.56, 4.4 |    Prices with VAT: <br> 1.66 <br> 3.07 <br> 5.28 |
|1, 3, 5, 7 |    Prices with VAT: <br> 1.20 <br> 3.60 <br> 6.00 <br> 8.40 |  

## 5.	Filter by Age
Write a program that reads an integer N on the first line. And on next N lines read pairs of "{name}, {age}". Then read three more lines:

-	Condition - "younger" or "older"
-	Age - Integer
-	Format - "name", "age" or "name age"

Depending on the condition, print the pairs in the right format. <br>
<strong>Don't use any built-in functionality. Write your methods.</strong>

### Examples

| Input  | Output |   
| ------ | ------ |
|  5     | Peter - 20 <br> Maria - 29 <br> Idan - 31 
Peter, 20
George, 18
Maria, 29
Idan, 31
Simeon, 16
older
20
name age |       |
| Input  | Output |   
| 5    |  Peter <br> George <br> Simeon |
Peter, 20
George, 18
Maria, 29
Idan, 31
Simeon, 16
younger
20
name|       |
| Input  | Output |  
| 5    | 20 <br> 18 <br> 29 <br> 31 <br> 16 |
Peter, 20
George, 18
Maria, 29
Idan, 31
Simeon, 16
younger
50
age  |          |

## 6.	Find Evens or Odds
You are given a lower and an upper bound for a range of integer numbers. Then a command specifies if you need to list all even or odd numbers in the given range. Use predicates that need to be passed to a method.

### Examples
| Input  | Output |   
| ------ | ------ |
|   1 10 <br> odd      |   1 3 5 7 9     |
|   20 30 <br> even      |  20 22 24 26 28 30     |
