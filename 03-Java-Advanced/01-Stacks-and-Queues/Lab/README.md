# Lab: Stacks and Queues

##  1.	Browser History
Write a program that takes two types of browser instructions:
-	Normal navigation: a URL is set, given by a string;
-	The string "back" sets the current URL to the last set URL

After each instruction, the program should print the current URL. If the back instruction can't be executed, print 
"no previous URLs". The input ends with the "Home" command, and then you simply have to stop the program.

### Examples

| Input  | Output |   
| ------ | ------ |
| https//softuni.bg/ | https//softuni.bg/ |
| back               | no previous URLs |
| https//softuni.bg/trainings/courses | https//softuni.bg/trainings/courses |
| back                                 | https//softuni.bg/                 |
| https//softuni.bg/trainings/2056       |   https//softuni.bg/trainings/2056                              |
| back                                 |  https//softuni.bg/                               |
| https//softuni.bg/trainings/live      |    https//softuni.bg/trainings/live                             |
| https//softuni.bg/trainings/live/details |     https//softuni.bg/trainings/live/details                            |
|          Home                             |                                 |
| Input  | Output |
| https//google.bg/                 | https//google.bg/ |
| https//google.bg/softuni               |  https//google.bg/softuni |
| back                                   | https//google.bg/ |
| back                                 | no previous URLs                |
| https//google.bg/java/advanced       |   https//google.bg/java/advanced                           |
| back                                 |  https//google.bg/                                |
| https//google.bg/java/oop      |   https//google.bg/java/oop                           |
|          Home                             |                                 |

##  2.	Simple Calculator
Create a simple calculator that can evaluate simple expressions that will not hold any operator different from addition and subtraction. There will not be parentheses or operator precedence.

Solve the problem using a Stack.

| Input  | Output |
| ------ | ------ |
| 2 + 5 + 10 - 2 - 1        |   14      |
| Input  | Output |
| 2 - 2 + 5     | 5    |


## 3.	Decimal to Binary Converter
Create a simple program that can convert a decimal number to its binary representation. Implement an elegant solution using a Stack.

Print the binary representation back at the terminal.

### Examples 

| Input  | Output |   
| ------ | ------ |
| 10     |  1010     |
| Input  | Output |   
| 1024   |  10000000000   |


## 4.	Matching Brackets
We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.

Print the result back at the terminal.

### Examples

| Input  | Output |   
| ------ | ------ |
| 1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5       |   (2 + 3)     |
|                                            |  (3 + 1)            |
|                                            |  (2 - (2 + 3) * 4 / (3 + 1))          |
| Input  | Output |  
| (2 + 3) - (2 + 3)     |    (2 + 3)            |
|                       |    (2 + 3)            |

## 5.	Printer Queue
The printer queue is a simple way to control the order of files sent to a printer device. We know that a single printer can be shared between multiple devices. So to preserve the order of the files sent, we can use a queue. 

Write a program which takes filenames until the "print" command is received. Then as output, print the filenames in the order of printing. Some of the tasks may be canceled. If you receive "cancel" you have to remove the first file to be printed. If there is no current file to be printed, print "Printer is on standby".


### Examples

| Input  | Output |   
| ------ | ------ |
| Lab.docx |   Canceled Lab.docx        |
|  cancel               |   Printer is on standby     |
|  cancel               |  Canceled Presentation.pptx      |
|  Presentation.pptx               |  NoteNothing.txt      |
|  NoteNothing.txt              |   SomeCode.java     |
|  SomeCode.java               |         |
|    cancel            |          |
|    print            |          |
| Input  | Output |   
|  Presentation.pptx   |   Canceled Presentation.pptx      |
|  cancel               |   Canceled Text.txt     |
|  Text.txt              |  Printer is on standby    |
|  cancel               |  Printer is on standby     |
|  cancel              |            |
|  cancel               |         |
|    print            |          |


## 6.	Hot Potato
Hot potato is a game in which children form a circle and start passing a hot potato. The counting starts with the first kid. Every nth toss, the child left with the potato leaves the game. When a kid leaves the game, it passes the potato forward. This continues repeating until there is only one kid left.

Create a program that simulates the game of Hot Potato. Print every kid that is removed from the circle. In the end, print the kid that is left last.

### Examples

| Input  | Output |   
| ------ | ------ |
| Sam John Sara |   Removed John      |
|  2              |   Removed Sam     |
|             |  Last is Sara      |
| Input  | Output |   
|  George Peter Sam John Zak              | Removed Zak      |
|  10              |   Removed Peter     |
|                 | Removed Sam        |
|                |  Removed George        |
|               |  Last is John        |
| Input  | Output |   
| George Peter Misha Sara Kendal   |   Removed George      |
|  1               |  Removed Peter     |
|                |  Removed Misha    |
|                  |  Removed Sara    |
|                  |   Last is Kendal         |
|                 |         |
|                  |          |


## 7.	Math Potato
Rework the previous problem by using a PriorityQueue so that a child is removed only on a composite (not prime) cycle (cycles start from 1). 

If a cycle is prime, print the child's name.

As before, print the name of the child that is left last.

### Examples

| Input  | Output |   
| ------ | ------ |
| Maria Peter George |   Removed George      |
|  2              |   Prime Maria     |
|             | Prime Maria      |
|             |   Removed Maria              |
|            |     Last is Peter                    |
| Input  | Output |   
| George Peter Misha Sara Kendal |   Removed George      |
|  10             |   Prime Kendal     |
|             | Prime Kendal     |
|             |   Removed Kendal              |
|            |     Prime Misha                   |
|            |     Removed Misha                           | 
|             |     Prime Peter                                 |
|             |     Removed Peter                                 |
|             |     Last is Sara                                 |

##  8.	Browser History Upgrade
Extend "Browser History" with a "forward" instruction, which visits URLs that were navigated away from by "back".

Each forward instruction visits the next most recent such URL. If normal navigation happens, all potential forward URLs are removed until a new back instruction is given if the forward instruction can't be executed, print

"no next URLs".


### Examples

| Input  | Output |   
| ------ | ------ |
| forward | no next URLs |
| https//softuni.bg/               | https//softuni.bg/ |
| https//softuni.bg/trainings/courses | https//softuni.bg/trainings/courses|
| back                                 | https//softuni.bg/                 |
| forward       |   https//softuni.bg/trainings/courses                            |
| https//softuni.bg/trainings/2056   |  https//softuni.bg/trainings/2056                             |
| back     |   https//softuni.bg/trainings/courses                            |
| forward  |     https//softuni.bg/trainings/2056                          |
| forward                            |      no next URLs                             |
| https//softuni.bg/trainings/courses                                |     https//softuni.bg/trainings/courses                   |
|  Home                                     |                       |
| Input  | Output |   
| back                 | no previous URLs |
| https//google.bg/              |  https//google.bg/ |
| https//google.bg/softuni                                   | https//google.bg/softuni |
| back                                 | https//google.bg/                |
| forward      |  https//google.bg/softuni                           |
| https//google.bg/java/advanced                                 |  https//google.bg/java/advanced                                |
| back                      |               https//google.bg/softuni                                             |
| forward                             |         https//google.bg/java/advanced                                  |
| https//google.bg/java/oop                             |           https//google.bg/java/oop                                |
| back                             |     https//google.bg/java/advanced                                         |
| https//google.bg/java/oop                            |                  https//google.bg/java/oop                          |
| fHome                           |                                           |


