# Exercises: Streams, Files and Directories

##  1.	Sum Lines
Write a program that reads a text file ("input.txt" from the Resources - Exercises) and prints on the console the sum of the ASCII symbols of each of its lines. Use BufferedReader in combination with FileReader. 

### Examples

| Input  | Output |   
| ------ | ------ |
|  On January 1 , 1533 ,       |    1452 <br> 1397 <br> 2606 <br> 670 <br> 1573 <br> 2028 <br> 2762 |
Michael Angelo, 
then fifty-seven years old, 
writes
from Florence to 
Tommaso de' Cavalieri, 
a youth of noble Roman family,      |        |

##  2.	Sum Bytes
Write a program that reads a text file ("input.txt" from the Resources - Exercises) and prints on the console the sum of the ASCII symbols of all characters inside the file. Use BufferedReader in combination with FileReader.

### Examples
| Input  | Output |   
| ------ | ------ |
|  On January 1 , 1533 ,       |    12488  |
Michael Angelo, 
then fifty-seven years old, 
writes
from Florence to 
Tommaso de' Cavalieri, 
a youth of noble Roman family,      |        |

## 3.	ALL CAPITALS!
Write a program that reads a text file ("input.txt" from the Resources - Exercises) and changes the casing of all letters to the upper. Write the output to another file ("output.txt").

### Examples
| Input  | Output |   
| ------ | ------ |
|  On January 1 , 1533 ,       |    ON JANUARY 1 , 1533 , <br> MICHAEL ANGELO,  <br> THEN FIFTY-SEVEN YEARS OLD, <br> WRITES <br> FROM FLORENCE TO <br> TOMMASO DE' <br> CAVALIERI,  <br> A YOUTH OF NOBLE ROMAN FAMILY, |
Michael Angelo, 
then fifty-seven years old, 
writes
from Florence to 
Tommaso de' Cavalieri, 
a youth of noble Roman family,      |        |

## 4.	Count Character Types
Write a program that reads a list of words from the file ("input.txt" from the Resources - Exercises) and finds the count of vowels, other symbols, and punctuation marks. Assume that:
-	a, e, i, o, u are vowels, only lower case.
-	All others are other symbols.
-	Punctuation marks are (! , . ?).
-	Do not count whitespace.

Write the results to another file – "output.txt". 

### Examples
| Input  | Output |   
| ------ | ------ |
| On January 1 , 1533 , Michael Angelo, <br> then fifty-seven years old, writes from Florence to Tommaso de' Cavalieri, <br> a youth of noble Roman family, ...| Vowels: 41 <br> Other symbols: 72 <br> Punctuation: 6 |

## 5.	Line Numbers
Write a program that reads a text file ("inputLineNumbers.txt" from the Resources - Exercises) and inserts line numbers in front of each of its lines. The result should be written to another text file – "output.txt". 

### Examples

| Input  | Output |   
| ------ | ------ |
|  Two households, both alike in dignity, <br> In fair Verona, where we lay our scene, <br> From ancient grudge break to new, <br> Where civil blood makes civil hands. <br> From forth the fatal loins of these two <br> A pair of star-cross'd lovers take their life; <br> Whose misadventured piteous overthrows <br> Do with their death bury their parents' strife. |  1. Two households, both alike in dignity, <br> 2. In fair Verona, where we lay our scene, <br> 3. From ancient grudge break to new, <br> 4. Where civil blood makes civil hands. <br> 5. From forth the fatal loins of these two  <br> 6. A pair of star-cross'd lovers take their life; <br> 7. Whose misadventured piteous overthrows <br> 8. Do with their death bury their parents' strife |

## 6.	Word Count
Write a program that reads a list of words from the file "words.txt" (from the Resources - Exercises) and finds how many times each of the words is contained in another file "text.txt" (from the Resources - Exercises). Matching should be case-insensitive.

Write the results in the file "results.txt". Sort the words by frequency in descending order.

### Examples

| Input  | Output |   
| ------ | ------ |
|   of which The |   of - 6 <br> which - 2 <br> The - 1  |

## 7.	Merge Two Files
Write a program that reads the contents of two text files ("inputOne.txt", "inputTwo.txt" from Resources - Exercises) and merges them into a third one.

### Examples

| Input  | Output |   
| ------ | ------ |
|   text from inputOne ... <br> text from inputTwo ...     |   text from inputOne ... text from inputTwo ... |

## 8.	Get Folder Size
Write a program that traverses a folder and calculates its size in bytes. Use Folder Exercises Resources in Resources.

### Examples

| Input  | Output |   
| ------ | ------ |
|       |  Folder size: 2878  |