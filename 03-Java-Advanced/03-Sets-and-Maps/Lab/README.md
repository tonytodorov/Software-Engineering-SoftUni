# Lab: Sets and Maps Advanced

##  1.	Parking Lot
Write a program that:
-	Records car numbers for every car that enters the parking lot.
-	Removes car number when the car is out.

When the parking lot is empty, print "Parking Lot is Empty".

# Input
The input will be a string in the format "{direction, carNumber}".

The input ends with the string "END".

# Output
Print the output with all car numbers which are in the parking lot.


### Examples

| Input  | Output |   
| ------ | ------ |
| IN, CA2844AA <br> IN, CA1234TA <br> OUT, CA2844AA <br> IN, CA9999TT <br> IN, CA2866HI <br> OUT, CA1234TA <br> IN, CA2844AA <br> OUT, CA2866HI <br> IN, CA9876HH <br> IN, CA2822UU <br> END|  CA9999TT <br> CA2844AA <br> CA9876HH <br> CA2822UU  |
| Input  | Output |
| IN, CA2844AA <br> IN, CA1234TA <br> OUT, CA2844AA <br> OUT, CA1234TA <br> END | Parking Lot is Empty        |

##  2.	SoftUni Party
There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular. 
When a guest comes, you have to check if he/she exists on any of the two reservation lists. All reservation numbers will be with 8 chars. All VIP numbers start with a digit.

There will be 2 command lines:
-	First is "PARTY" - the party is on, and guests are coming.
-	The second is "END" - then the party is over, and no more guests will come.

The output shows all guests who didn't come to the party (VIP must be first).

### Examples
| Input  | Output |
| ------ | ------ |
|  7IK9Yo0h | 2 <br>7IK9Yo0h <br> tSzE5t0p |
9NoBUajQ
Ce8vwPmE
SVQXQCbc
tSzE5t0p
PARTY
9NoBUajQ
Ce8vwPmE
SVQXQCbc
END |
| Input  | Output |
| m8rfQBvl | 2 <br> MDzcM9ZK <br> xys2FYzn       | 
fc1oZCE0
UgffRkOn
7ugX7bm0
9CQBGUeJ
2FQZT3uC
dziNz78I
mdSGyQCJ
LjcVpmDL
fPXNHpm1
HTTbwRmM
B5yTkMQi
8N0FThqG
xys2FYzn
MDzcM9ZK
PARTY
2FQZT3uC
dziNz78I
mdSGyQCJ
LjcVpmDL
fPXNHpm1
HTTbwRmM
B5yTkMQi
8N0FThqG
m8rfQBvl
fc1oZCE0
UgffRkOn
7ugX7bm0
9CQBGUeJ
END|       |



## 3.	"Voina" – Number Game

Write a program that:
-	Reads 20 numbers for both players, separated with " " (single space).
-	Every player can hold unique numbers.

Each Round, both players get the top number from their deck. The player with the bigger number gets both numbers and adds them to the bottom of his sequence.

The game ends after 50 rounds or if any player loses all of his numbers.

# Input
-	Numbers – Integer
# Output
-	Output must be "First player win!", "Second player win!" or "Draw!".

### Examples 

| Input  | Output |   
| ------ | ------ |
| 26 58 16 92 44 65 65 77 57 23 71 57 7 52 85 44 32 70 38 23     | Second player win!  |
| 43 95 33 51 62 93 57 55 0 31 32 95 68 34 30 51 37 32 11 97       |         |
| Input  | Output |   
|74 78 82 42 19 39 29 69 20 42 31 77 57 36 76 26 4 9 83 42     | First player win!     |
| 15 43 80 71 22 88 78 35 28 30 46 41 76 51 76 18 14 52 47 38      |         |

## 4.	Count Real Numbers
Write a program that counts the occurrence of real numbers. The input is a single line with real numbers separated by a space. Print the numbers in the order of appearance. All numbers must be formatted to one digit after the decimal point.

## Input

### Examples

| Input  | Output |   
| ------ | ------ |
| -2.5 4 3 -2.5 -5.5 4 3 3 -2.5 3     | -2.5 -> 3 <br> 4.0 -> 2 <br> 3.0 -> 4 <br> -5.5 -> 1 |
| Input  | Output |   
|2.3 4.5 4.5 5.5 5.5 2.3 3.0 3.0 4.5 4.5 3.0 3.0 4.0 3.0 5.5 3.0 2.3 5.5 4.5 3.0      | 2.3 -> 3 <br> 4.5 -> 5 <br> 5.5 -> 4 <br >3.0 -> 7 <br> 4.0	-> 1|


## 5.	Average Students Grades
Write a program, which reads the name of a student and their grades and adds them to the student record, then prints grades along with their average grade – ordered the output by the students' names.

## Input
On the first line N – the number of students, then on the next, N lines student name with grade.

### Examples

| Input  | Output |   
| ------ | ------ |
| 7          |   Alex -> 2.00 3.00 (avg: 2.50) <br> Maria -> 5.50 2.50 3.46 (avg: 3.82) <br> Stephan -> 5.20 3.20 (avg: 4.20) |
Stephan 5.20
Maria 5.50
Stephan 3.20
Maria 2.50
Alex 2.00
Maria 3.46
Alex 3.00 |      |
| Input  | Output |  
| 4         |   Alex -> 4.50 5.00 (avg: 4.75) <br> Peter -> 3.00 3.66 (avg: 3.33) |
Alex 4.50
Peter 3.00
Alex 5.00
Peter 3.66 |      |

## 6.	Product Shop
Write a program that prints information about food shops in Sofia and the products they store. Until the "Revision" command you will receive an input in the format: "{shop}, {product}, {price}".

Keep in mind that if you get a store that already exists, you must gather product information.

Your output must be ordered by shop name and must be in the format:

"{shop}-> <br>
Product: {product}, Price: {price}"

The price should be formatted to one digit after the decimal point.

### Examples

| Input  | Output |   
| ------ | ------ |
| lidl, peach, 1.20 |  fantastico-> <br> Product: apple, Price: 1.2 <br> Product: grape, Price: 2.2 <br> kaufland-> <br> Product: banana, Price: 1.1 <br> lidl-> <br> Product: peach, Price: 1.2 <br> Product: juice, Price: 2.3 |
lidl, juice, 2.30
fantastico, apple, 1.20
kaufland, banana, 1.10
fantastico, grape, 2.20
Revision |        |
| Input  | Output |   
| tmarket, peanuts, 2.20   |    GoGrill-> <br> Product: meatballs, Price: 3.3 <br> Product: HotDog, Price: 1.4 <br> tmarket-> <br> Product: peanuts, Price: 2.2 <br> Product: sweets, Price: 2.2      |
GoGrill, meatballs, 3.30
GoGrill, HotDog, 1.40
tmarket, sweets, 2.20
Revision |         |


## 7.	Cities by Continent and Country
Write a program to read continents, countries, and their cities put them on a nested map, and print them in the order of their first appearance.

### Examples

| Input  | Output |   
| ------ | ------ |
| 9           |         Europe: <br> Bulgaria -> Sofia, Plovdiv <br> Poland -> Warsaw, Poznan <br> Germany -> Berlin <br> Asia: <br> China -> Beijing, Shanghai <br>Japan -> Tokyo <br> Africa: <br>Nigeria -> Abuja |              
Europe Bulgaria Sofia
Asia China Beijing
Asia Japan Tokyo
Europe Poland Warsaw
Europe Germany Berlin
Europe Poland Poznan
Europe Bulgaria Plovdiv
Africa Nigeria Abuja
Asia China Shanghai |        |
| Input  | Output |   
|  3          |     Europe: <br> Germany -> Berlin <br> Bulgaria -> Varna <br> Africa: <br> Egypt -> Cairo  |
Europe Germany Berlin
Europe Bulgaria Varna
Africa Egypt Cairo |            |
|  4 4 4             |   6 7 8 9    |
|  Nuke it from orbit               |  11 12 13 14      |
|               |  16 17 18         |
|           |      19      |


## 8.	Academy Graduation
Write a program that:
<ul>
    <li>Reads from console number of students for a track.</li>
-	<li>Reads on pair of rows:</li>
        <ul>
            <li>The first line is the name of the student.</li>
            <li>The second line is his score for a different number of courses.</li>
        </ul>
    <li>Print on console "{name} is graduated with {average scores}".</li>
</ul>


### Examples

| Input  | Output |   
| ------ | ------ |
|3        | George is graduated with 4.375 <br> Maria is graduated with 5.125 <br>Peter is graduated with 5.25  |
George
3.75 5
Maria
4.25 6
Peter
6 4.5 |      |
| Cloud 7 7        |   Player: Killed by Eruption      |
| Eruption 6 7         |   Final position: 8, 7       |
| Eruption 8 7           |         |
| Eruption 8 7           |          |
| Input  | Output |   
| 500000        |   Heigan: Defeated!     |
| Cloud 7 6        |   Player: 12500     |
| Eruption 7 8         |   Final position: 7, 11      |
| Eruption 7 7           |         |
| Cloud 7 8          |          |
| Eruption 7 9           |          |
| Eruption 6 14          |          |
| Eruption 7 11           |          |
| Input  | Output |   
| 12500.66         |   Heigan: 2949997.36    |
| Cloud 7 7        |   Player: Killed by Plague Cloud      |
| Cloud 7 7        |   Final position: 7, 7       |
| Cloud 7 7           |         |
| Cloud 7 7           |          |


## 9.	Largest 3 Numbers

Read a list of integers and print the largest 3 of them. If there are less than 3, print all of them.

### Examples
| Input  | Output |
| ------ | ------ |
| 10 30 15 20 50 5    | 50 30 20      |
| Input  | Output |
| 20 30    | 30 20       |    


## 10.	*Radioactive Mutant Vampire Bunnies
Browsing through GitHub, you come across an old JS Basics teamwork game. It is about very nasty bunnies that multiply extremely fast. There's also a player that has to escape from their lair. The last thing that is left is the algorithm that decides if the player will escape the lair or not. You like the game, so you decide to port it to Java because that's your language of choice.

First, you will receive a line holding integers N and M, representing the rows and columns in the lair. Then you receive N strings that can only consist of ".", "B", "P". The bunnies are marked with "B", the player is marked with "P", and everything else is free space, marked with a dot ".". They represent the initial state of the lair. There will be only one player. Then you will receive a string with commands such as LLRRUUDD – where each letter represents the player's next move (Left, Right, Up, Down).

After each step of the player, each of the bunnies spread to the up, down, left, and right (neighboring cells marked as "." changes their value to B). If the player moves to a bunny cell or a bunny reaches the player, the player has died. If the player goes out of the lair without encountering a bunny, the player has won.
When the player dies or wins, the game ends. All the activities for this turn continue (e.g., all the bunnies spread normally), but there are no more turns. There will be no stalemates where the moves of the player end before he dies or escapes.

Finally, print the final state of the lair with every row on a separate line. On the last line, print either "dead: {row} {col}" or "won: {row} {col}". Row and col are the coordinates of the cell where the player has died or the last cell he has been in before escaping the lair.

## Input
-	On the first line of input, the numbers N and M are received – the number of rows and columns in the lair.
-	On the next N lines, each row is received as a string. The string will contain only ".", "B", "P". All strings will be the same length. There will be only one "P" for all the input.
-	On the last line, the directions are received in the form of a string containing "R", "L", "U", "D".

## Output
-	On the first N lines, print the final state of the bunny lair.
-	On the last line, print the outcome – "won: {row} {col}"  or "dead: {row} {col}".

## Constraints
-	The dimensions of the lair are in the range [3…20].
-	The directions string length is in the range [1…20].


### Examples
| Input  | Output |
| ------ | ------ |
| 5 8    | BBBBBBBB<br> BBBBBBBB<br> BBBBBBBB<br> .BBBBBBB <br>..BBBBBB  |
| .......B | won: 3 0           |
|...B....  |          |
| ....B..B  |            |
| ........  |              |
| ..P.....   |              |
|   ULLL  |              |
| Input  | Output |
| 4 5    | .B...<br> BBB..<br> BBBB.<br> BBB.. |
| ..... | dead: 3 1          |
| .....  |          |
| .B...  |            |
|...P.  |              |
| LLLLLLLL   |              |


##  11.	 Reverse Matrix Diagonals
You are given a matrix (2D array) of integers. You have to print the matrix diagonal but in reversed order. Print each diagonal on a new line.

## Input
On the first line, single integer the number R of rows in the matrix. On each of the next R lines, C numbers are separated by single spaces. Note that R and C may have different values. 

## Output
The output should consist of R lines, each consisting of exactly C characters, separated by spaces, representing the matrix diagonals reversed.

## Constraints
All the integers will be in the range [1….1000].


### Examples

| Input  | Output |   
| ------ | ------ |
| 3 4         |   10      |
| 21 20 18 15            |   11 12       |
| 19 17 14 12            |  13 14 15        |
| 16 13 11 10          |  16 17 18         |
|                       |  19 20               |
|                      |   21                    |
| Input  | Output |   
|  1 3              |     1      |
|  3 2 1              |   2    |
|                      | 3    |
| Input  | Output |   
|  3 3              |     10      |
|  18 17 15              |   11 12    |
|   16 14 12                   | 13 14 15    |
|   13 11 10              | 16 17    |
|                         |  18          |


## 12.*** the Matrix
You are given a matrix (2D array) of lowercase alphanumeric characters (a-z, 0-9), a starting position – defined by a start row startRow and a start column startCol – and a filling symbol fillChar. Let's call the symbol originally at startRow and startCol the startChar. Write a program, which, starting from the symbol at startRow and startCol, changes to fillChar every symbol in the matrix which:

-	is equal to startChar AND
-	can be reached from startChar by going up (row – 1), down (row + 1), left (col – 1) and right (col + 1) and “stepping” ONLY on symbols equal startChar 

So, you basically start from startRow and startCol and can move either by changing the row OR column (not both at once, i.e. you can't go diagonally) by 1 and can only go to positions that have the startChar written on them. Once you find all those positions, you change them to fillChar. 

In other words, you need to implement something like the Fill tool in MS Paint, but for a 2D char array instead of a bitmap.

## Input
On the first line, two integers will be entered – the number R of rows and number C of columns.

On each of the next R lines, C characters separated by single spaces will be entered – the symbols of the Rth row of the matrix, starting from the 0th column and ending at the C-1 column.

On the next line, a single character – the fillChar – will be entered.

On the last line, two integers – startRow and startCol – will be entered, separated by a single space.

## Output
The output should consist of R lines, each consisting of exactly C characters, NOT SEPARATED by spaces, representing the matrix after the fill operation has been finished.

## Constraints
0 < R, C < 20 
0 <= startRow < R 
0 <= startCol < C

All symbols in the input matrix will be lowercase alphanumerics (a-z, 0-9). The fillChar will also be alphanumeric and lowercase.

The total running time of your program should be no more than 0.1s.

The total memory allowed for use by your program is 5MB.

### Examples

| Input  | Output |   
| ------ | ------ |
| 5 3        |   xxx      |
| a a a           |  xxx      |
| a a a            | xbx         |
| a b a        |    xbx       |
| a b a                      |        xbx         |
| x                   |                    |
| 0                   |                    |
| Input  | Output |   
| 5 3        |   aaa      |
| a a a           |  aaa      |
| a b a            | axa        |
| a b a        |    axa      |
| a b a                      |       axa        |
| x                   |                    |
| 2 1                   |                    |
| Input  | Output |   
|  5 6              |    oo11oo      |
|  o o 1 1 o o              |   o1331o   |
|   o 1 o o 1 o                   | 133331  |
|   1 o o o o 1          | o1331o    |
|    o 1 o o 1 o                     |  o1331o        |
|   o o 1 1 o o                    |         |
| 3                   |                    |
| 2 1                   |                    |
| Input  | Output |   
|  5 6              |   oooooo      |
|  o o o o o o             |   ooo1oo   |
|   o o o 1 o o                  | oo1o11  |
|   o o 1 o 1 1         | o11w1z    |
|   o 1 1 w 1 o                    |  1zzzzz        |
|  1 o o o o o                  |         |
| z                   |                    |
| 4 1                   |                    |
| Input  | Output |   
|  5 6              |   z1oo1z      |
|  o 1 o o 1 o          |   z1oo1z   |
|   o 1 o o 1 o                 | z1111z  |
|   o 1 1 1 1 o       | z1zw1z    |
|   o 1 o w 1 o                   |  zzzzzz        |
|  o o o o o o                  |         |
| z                   |                    |
| 4 0                   |                    |

