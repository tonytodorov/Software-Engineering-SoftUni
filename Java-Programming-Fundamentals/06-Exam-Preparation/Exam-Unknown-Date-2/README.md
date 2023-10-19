# Programming Fundamentals Mid Exam Retake - Unknown Date

## 1. Black Flag
Pirates are invading the sea, and you're tasked to help them plunder

Create a program that checks if target plunder is reached. First, you will receive how many days the pirating lasts. Then you will receive how much the pirates plunder for a day. Last you will receive the expected plunder at the end.

Calculate how much plunder the pirates manage to gather. Each day they gather the plunder. Keep in mind that they attack more ships every third day and add additional plunder to their total gain, which is 50% of the daily plunder. Every fifth day the pirates encounter a warship, and after the battle, they lose 30% of their total plunder.

If the gained plunder is more or equal to the target, print the following:

"Ahoy! {totalPlunder} plunder gained."

If the gained plunder is less than the target. Calculate the percentage left and print the following:

"Collected only {percentage}% of the plunder."

Both numbers should be formatted to the 2nd decimal place.


### Input
-	On the 1st line, you will receive the days of the plunder – an integer number in the range [0…100000].
-	On the 2nd line, you will receive the daily plunder – an integer number in the range [0…50].
-	On the 3rd line, you will receive the expected plunder – a real number in the range [0.0…10000.0].


### Output
- In the end, print whether the plunder was successful or not, following the format described above.


### Examples

| Input  | Output |   
| ------ | ------ |
|   5     |  Ahoy! 154.00 plunder gained. |
|   40     |       |
|    100    |        |
| Input  | Output |
|   10     |  Collected only 36.29% of the plunder.  |
|   20     |      |
|   280    |        |


## 2.	Treasure Hunt

The pirates need to carry a treasure chest safely back to the ship, looting along the way.

Create a program that manages the state of the treasure chest along the way. On the first line, you will receive the initial loot of the treasure chest, which is a string of items separated by a "|".

"{loot1}|{loot2}|{loot3} … {lootn}"

The following lines represent commands until "Yohoho!" which ends the treasure hunt:

<ul>
    <li>"Loot {item1} {item2}…{itemn}":</li>
        <ul>
            <li>Pick up treasure loot along the way. Insert the items at the beginning of the chest.</li>
            <li>If an item is already contained, don't insert it.</li>
        </ul>
    <li>"Drop {index}":</li>
        <ul>
            <li>Remove the loot at the given position and add it at the end of the treasure chest.</li>
            <li>If the index is invalid, skip the command.</li>
        </ul>
    <li>"Steal {count}":</li>
        <ul>
            <li>Someone steals the last count of loot items. If there are fewer items than the given count, remove as many as there are.</li>
            <li>Print the stolen items separated by ", ":<br>"{item1}, {item2}, {item3} … {itemn}"</li>
        </ul>
</ul>

In the end, output the average treasure gain, which is the sum of all treasure items' length divided by the count of all items inside the chest formatted to the second decimal point:

"Average treasure gain: {averageGain} pirate credits."

If the chest is empty, print the following message:

"Failed treasure hunt."

### Input
-	On the 1st line, you are going to receive the initial treasure chest (loot separated by "|").
-	On the following lines, until "Yohoho!", you will be receiving commands.

### Output
-	Print the output in the format described above.

### Constraints 
-	The loot items will be strings containing any ASCII code.
-	The indexes will be integers in the range [-200…200]
-	The count will be an integer in the range [1….100]

| Input  | Output |
| ------ | ------ |
| Gold\|Silver\|Bronze\|Medallion\|Cup  | Medallion, Cup, Gold    |
| Loot Wood Gold Coins | Average treasure gain: 5.40 pirate credits.    |
| Loot Siver Pistol  |     |
| Drop 3  |     |
| Steal 3  |     |
| Yohoho! |     |
| Input  | Output |
| Diamonds\|Silver\|Shotgun\|Gold | Coal, Diamonds, Silver, Shotgun, Gold, Medals    |
| Loot Silver Medals Coal | Failed treasure hunt.   |
| Drop -1  |     |
| Drop 1  |     |
| Steal 6  |     |
| Yohoho! |     |

## 3.	ManOWar

The pirates encounter a huge Man-O-War at sea. 

Create a program that tracks the battle and either chooses a winner or prints a stalemate. On the first line, you will receive the status of the pirate ship, which is a string representing integer sections separated by ">". On the second line, you will receive the same type of status, but for the warship: 

"{section1}>{section2}>{section3}… {sectionn}"

On the third line, you will receive the maximum health capacity a section of the ship can reach. 

The following lines represent commands until "Retire":

-	"Fire {index} {damage}" - the pirate ship attacks the warship with the given damage at that section. Check if the index is valid and if not, skip the command. If the section breaks (health <= 0) the warship sinks, print the following and stop the program: "You won! The enemy ship has sunken."
-	"Defend {startIndex} {endIndex} {damage}" - the warship attacks the pirate ship with the given damage at that range (indexes are inclusive). Check if both indexes are valid and if not, skip the command. If the section breaks (health <= 0) the pirate ship sinks, print the following and stop the program:
"You lost! The pirate ship has sunken."
-	"Repair {index} {health}" - the crew repairs a section of the pirate ship with the given health. Check if the index is valid and if not, skip the command. The health of the section cannot exceed the maximum health capacity.
-	"Status" - prints the count of all sections of the pirate ship that need repair soon, which are all sections that are lower than 20% of the maximum health capacity. Print the following:
"{count} sections need repair."


In the end, if a stalemate occurs, print the status of both ships, which is the sum of their individual sections, in the following format:

"Pirate ship status: {pirateShipSum}

Warship status: {warshipSum}"

### Input
-	On the 1st line, you are going to receive the status of the pirate ship (integers separated by '>').
-	On the 2nd line, you are going to receive the status of the warship.
-	On the 3rd line, you will receive the maximum health a section of a ship can reach.
-	On the following lines, until "Retire", you will be receiving commands.

### Output
-	Print the output in the format described above.

### Constraints
-	The section numbers will be integers in the range [1….1000].
-	The indexes will be integers [-200….200].
-	The damage will be an integer in the range [1….1000].
-	The health will be an integer in the range [1….1000].

### Examples 

| Input  | Output |   
| ------ | ------ |
|  12>13>11>20>66  |     2 sections need repair.   |
|  12>22>33>44>55>32>18    |    Pirate ship status: 135          |
|  70   |     Warship status: 205         |
|  Fire 2 11    |              |
|  Fire 8 100    |              |
|  Defend 3 6 11    |              |
|  Defend 0 3 5    |              |
|  Repair 1 33   |              |
|  Status   |              |
|  Retire    |              |
| Input  | Output |
|  2>3>4>5>2   |     Sword, Bow, Iron    |
|  6>7>8>9>10>11     |              |
|  20   |              |
|  Status   |              |
|  Fire 2 3    |              |
|  Defend 0 4 11    |              |
|  Repair 3 18    |              |
|  Retire    |              |



