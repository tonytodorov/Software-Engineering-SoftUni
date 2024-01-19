# Programming Fundamentals Mid Exam - Unknown Date

## 1. Bonus Scoring System
Create a program that calculates bonus points for each student enrolled in a course. On the first line, you are going to receive the number of students. On the second line, you will receive the total number of lectures in the course. The course has an additional bonus, which you will receive on the third line. On the following lines, you will be receiving the count of attendances for each student.

The bonus is calculated with the following formula:

{total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})

Find the student with the maximum bonus and print them, along with his attendance, in the following format:

"Max Bonus: {max bonus points}."
"The student has attended {student attendances} lectures."

Round the bonus points at the end to the nearest larger number.

### Input/Constraints
-	On the first line, you are going to receive the number of the students – an integer in the range [0…50].
-	On the second line, you will receive the number of the lectures – an integer number in the range [0...50].
-	On the third line, you will receive the additional bonus – an integer number in the range [0….100].
-	On the following lines, you will be receiving the attendance of each student.
-	There will never be students with equal bonuses.

### Output
-	Print the maximum bonus points and the attendance of the given student, rounded to the nearest larger number, scored by a student in this course in the format described above.


### Examples

| Input  | Output |   
| ------ | ------ |
|   5     |  Max bonus: 34.  |
|   25     |   The student has attended 24 lectures.     |
|    30    |        |
|    12    |        |
|    19    |        |
|    24    |        |
|    16    |        |
|    20    |        |
| Input  | Output |
|   10     |  Max bonus: 18.  |
|   30     |   The student has attended 28 lectures.     |
|   14    |        |
|    8    |        |
|    23    |        |
|    27    |        |
|    28    |        |
|    15    |        |
|    17    |        |
|    25    |        |
|    26    |        |
|    5    |        |
|    18    |        |

## 2.	Mu Online

You have initial health 100 and initial bitcoins 0. You will be given a string representing the dungeon's rooms. Each room is separated with '|' (vertical bar): "room1|room2|room3…"

Each room contains a command and a number, separated by space. The command can be:

<ul>
    <li>"potion"</li>
        <ul>
            <li>You are healed with the number in the second part. But your health cannot exceed your initial health (100).</li>
            <li>First print: "You healed for {amount} hp."</li>
            <li>After that, print your current health: "Current health: {health} hp."</li>
        </ul>
    <li>"chest"</li>
        <ul>
            <li>You've found some bitcoins, the number in the second part.</li>
            <li>Print: "You found {amount} bitcoins."</li>
        </ul>
    <li>In any other case, you are facing a monster, which you will fight. The second part of the room contains the attack of the monster. You should remove the monster's attack from your health. </li>
        <ul>
            <li>If you are not dead (health <= 0), you've slain the monster, and you should print: "You slayed {monster}."</li>
            <li>If you've died, print "You died! Killed by {monster}." and your quest is over. Print the best room you've managed to reach: "Best room: {room}"</li>
        </ul>
</ul>

If you managed to go through all the rooms in the dungeon, print on the following three lines:

"You've made it!<br>
Bitcoins: {bitcoins}<br>
Health: {health}"

### Input/Constraints 
You receive a string representing the dungeon's rooms, separated with '|' (vertical bar): "room1|room2|room3…".

### Output
Print the corresponding messages described above.

| Input  | Output |
| ------ | ------ |
| rat 10\|bat 20\|potion 10\|rat 10\|chest 100\|boss 70\|chest 1000    | You slayed rat.   |
|     |  You slayed bat.   |  
|   |  You healed for 10 hp.   |
|     |   Current health: 80 hp.  |
|      |  You slayed rat.   |  
|      |  You found 100 bitcoins.   |  
|    |   You died! Killed by boss.  |  
|   |  Best room: 6   |  
| Input  | Output |
| cat 10\|potion 30\|orc 10\|chest 10\|snake 25\|chest 110  | You slayed cat.   |
|   |  You healed for 10 hp.   |
|     |   Current health: 100 hp.  |
|      |  You slayed orc.   |  
|      |  You found 10 bitcoins.   |  
|    |   You slayed snake.  |  
|   |  You found 10 bitcoins.   |  
|   |  You've made it!           |  
|   |  Bitcoins: 120   |  
|   |  Health: 65   |  


## 3.	Inventory

You will receive a journal with some collecting items, separated with a comma and a space (", "). After that, until receiving "Craft!" you will be receiving different commands split by " - ":

-	"Collect - {item}" - you should add the given item to your inventory. If the item already exists, you should skip this line.
-	"Drop - {item}" - you should remove the item from your inventory if it exists.
-	"Combine Items - {old_item}:{new_item}" - you should check if the old item exists. If so, add the new item after the old one. Otherwise, ignore the command.
-	"Renew – {item}" – if the given item exists, you should change its position and put it last in your inventory.

### Output
After receiving "Craft!" print the items in your inventory, separated by ", ".


### Examples 

| Input  | Output |   
| ------ | ------ |
|  Iron, Wood, Sword   |     Iron, Sword, Gold    |
|  Collect - Gold     |              |
|  Drop - Wood    |              |
|  Craft!    |              |
| Input  | Output |
|  Iron, Sword   |     Sword, Bow, Iron    |
|  Drop - Bronze     |              |
|  Combine Items - Sword:Bow    |              |
|  Renew - Iron   |              |
|  Craft!    |              |


