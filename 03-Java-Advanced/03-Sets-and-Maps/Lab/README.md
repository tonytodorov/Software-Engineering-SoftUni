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