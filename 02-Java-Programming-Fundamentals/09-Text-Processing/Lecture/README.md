# Lab: Text Processing

##  1. Reverse Strings
You will be given a series of strings until you receive an "end" command. Write a program that reverses strings and prints each pair on a separate line in the format 
"{word} = {reversed word}".

### Examples

| Input  | Output |   
| ------ | ------ |
| helLo | helLo = oLleh |
| Softuni | Softuni = inutfoS |
| bottle | bottle = elttob |
| Input    | Output |
| Dog      |  Dog = goD  |
| caT          | caT = Tac  |
| chAir          | chAir = riAhc  |

##  2.	Repeat Strings
Write a Program That Reads an Array of Strings. Each String is Repeated N Times, Where N is the length of the String. Print the Concatenated String.


| Input  | Output |
| ------ | ------ |
| hi abc add        | hihiabcabcabcaddaddadd       |
| work     | workworkworkwork    |
| ball |  ballballballball      |


## 3. Substring
On the first line, you will receive a string. On the second line, you will receive a second string. Write a program that removes all of the occurrences of the first String in the second until there is no match. At the end, print the remaining String.

### Examples 

| Input  | Output |   
| ------ | ------ |
| ice |  kgb       |
| kicegiciceeb |        |
| Input  | Output |   
| e |  fixtur       |
| fixture |        |


## 4.	Text Filter
Write a program that takes a text and a string of banned words. All words included in the ban list should be replaced with asterisks "*", equal to the word's length. The entries in the ban list will be separated by a comma and space ", ".

The ban list should be entered on the first input line and the text on the second input line. 

### Examples

| Input  | Output |   
| ------ | ------ |
| Linux, Windows       |        |
| It is not Linux, it is GNU/Linux. Linux is merely the kernel, while GNU adds the functionality. Therefore we owe it to them by calling the OS GNU/Linux! Sincerely, a Windows client      |           It is not \*\*\*\*\*, it is GNU/\*\*\*\*\*. \*\*\*\*\* is merely the kernel, while GNU adds the functionality. Therefore we owe it to them by calling the OS GNU/\*\*\*\*\*! Sincerely, a ******* client                          |
| Input  | Output |  
| computer, programming, set      |                |
|  In computer programming, an application programming interface (API) is a set of subroutine definitions, communication protocols, and tools for building software.  |   In ******** \*\*\*\*\*\*\*\*\*\*\*, an application \*\*\*\*\*\*\*\*\*\*\* interface (API) is a *** of subroutine definitions, communication protocols, and tools for building software.       |

## 5.	Digits, Letters and Other
Write a program that receives a single string and on the first line prints all the digits, on the second – all the letters, and on the third – all the other characters. There will always be at least one digit, one letter, and another character.

### Examples

| Input  | Output |   
| ------ | ------ |
| Agd#53Dfg^&4F53 |  53453    |
|                 |  AgdDfgF  |
|                 |  #^&      |
| Input  | Output |   
| a1!             |  1        |
|                 |  a        |
|                 |  !        |

