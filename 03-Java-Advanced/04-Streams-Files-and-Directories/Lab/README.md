# Lab: Streams, Files and Directories

##  1.	Read File
You are given a file named "input.txt". Read and print all of its contents as a sequence of bytes (the binary representation of the ASCII code for each character) separated by a single comma. 

### Examples

| Input  | Output |   
| ------ | ------ |
| On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes...	| 11101111 10111011 10111111 1001111 1101110 100000 1001010 1100001 1101110 1110101 ...  |

##  2.	Write to File
Read the file named "input.txt" that is provided for this exercise and write all its content to a file while skipping any punctuation. Skip the following symbols: ",", ".", "!", "?".

### Examples
| Input  | Output |   
| ------ | ------ |
| On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes	| On January 1  1533  Michael Angelo then fifty-seven years old writes  |

## 3.	Copy Bytes
Read the file named "input.txt" and write to another file every character's ASCII representation.

Write every space or new line as it is, e.g., a space or a new line.

### Examples 

| Input  | Output |   
| ------ | ------ |
| On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes ...     | 79110 749711011797114121 49 44 49535151 44 771059910497101108 6511010310110811144 116104101110 10210510211612145115101118101110 12110197114115 11110810044 119114105116101115 ...  |

## 4.	Extract Integers
Read the file provided, named "input.txt" and extracts all integers that are not a part of a word in a separate file. A valid integer is surrounded by white spaces.

### Examples
| Input  | Output |   
| ------ | ------ |
| On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes ...	| 1 <br> 1533 <br> ... |

## 5.	Write Every Third Line
Read the file provided, named "input.txt" and write to another file all lines whose number is divisible by 3. Line numbers start from one.

### Examples

| Input  | Output |   
| ------ | ------ |
|  On January 1 , 1533 ,              |    then fifty-seven years old, <br> Tommaso de' Cavalieri, |
Michael Angelo, 
then fifty-seven years old, 
writes
from Florence to 
Tommaso de' Cavalieri, 
a youth of noble Roman family,    |      |

## 6.	Sort Lines
Read the file provided, named "input.txt" and sort all lines. Write text to another text file. Use Path and Files Classes. 

### Examples

| Input  | Output |   
| ------ | ------ |
|   C <br> A <br> B <br> D        |   A <br> B <br> C <br> D      |


## 7.	List Files
You are provided a folder named "Files-and-Streams". Create a program that lists the names and file sizes (in bytes) of all files that are placed directly in it (do not include files in nested folders). 

### Examples

| Input  | Output |   
| ------ | ------ |
|       |   input.txt: [size in bytes] <br> output.txt: [size in bytes] |

## 8.	Nested Folders
You are provided a folder named "Files-and-Streams". Create a program that lists the names of all directories in it (including all nested directories).
On the last line, print the count of all folders, including the root folder.

### Examples

| Input  | Output |   
| ------ | ------ |
|       |  ... <br> Streams-and-Files <br>Files-and-Streams <br>Streams-and-Files <br>Serialization <br>Streams-and-Files <br>[folder count] folders      |