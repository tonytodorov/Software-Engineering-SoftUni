# Lab: Exceptions and Error Handling

## 1. Number in Range

Write a program to enter an integer in a certain range. Until the number is not valid, enter a new number from the console. When the number is valid - end the program.

### Input
- Read a range - two numbers, separated by a space.
- On the next line, read the String.

### Output
- Print the range in the following format: "Range: [{startIndex}...{endIndex}]".
- When an invalid number is entered, String or the number is out of range, print "Invalid number: {num}".
- When the entered number is valid, print "Valid number: {num}".

### Examples
|  Input  |   Output  |
|  ------       |    -----       |
|  10 20 <br> 5 <br> xx <br> 20     |   Range: [10...20] <br> Invalid number: 5 <br> Invalid number: xx <br> Valid number: 20      |
| -5 <br> 50 <br> hi <br> -6 <br> -1   |  Range: [-5...50] <br> Invalid number: hi <br> Invalid number: -6 <br> Valid number: -1              |

## 2.	Square Root

Write a program that reads an integer number and calculates and prints its square root (with 2 digits after the decimal point). If the number is invalid, print "Invalid number". In all cases finally, print "Goodbye". Use try-catch-finally.

### Examples
|  Input  |   Output  |
|  ------       |    -----       |
|  9      | 3.00 <br> Goodbye  |
|  20  |  4.47 <br> Goodbye      |
|  Xx  |  Invalid <br> Goodbye      |
|  -5  |  Invalid <br> Goodbye      |

## 3. Enter Numbers

Write a method readNumber(int start, int end) that enters an integer number in a given range [start…end], excluding the numbers start and end. If an invalid number or a non-number text is entered, the method should throw an exception. Using this method, write a program that enters 10 numbers: a1, a2, … a10, such that 1 < a1 < … < a10 < 100. If the user enters an invalid number, continue while there are 10 valid numbers entered. Print the array elements, separated with comma and space ", ".

### Examples
|  Input  |   Output  |
|  ------       |    -----       |
|  2 <br> 3 <br> 4 <br> 5 <br> 6 <br> 7 <br> 8 <br> 9 <br> 10 <br> 11        | 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 |
|  1 <br> 2 <br> 1 <br> 3 <br> p <br> 4 <br> 5 <br> 6 <br> 7 <br> 8 <br> 9 <br> 10 <br> 11        | Your number is not in range (1 - 100)<br> Your number is not in range (2 – 100) <br> Invalid Number! <br> 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 |

