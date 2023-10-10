# Programming Fundamentals Mid Exam Retake - 07 April 2020

## 1. Counter-Strike

Write a program that keeps track of every won battle against an enemy. You will receive initial energy. Afterward, you will start receiving the distance you need to reach an enemy until the "End of battle" command is given, or you run out of energy.

The energy you need for reaching an enemy is equal to the distance you receive. Each time you reach an enemy, you win a battle, and your energy is reduced. Otherwise, if you don't have enough energy to reach an enemy, end the program and print: "Not enough energy! Game ends with {count} won battles and {energy} energy".

Every third won battle increases your energy with the value of your current count of won battles.

Upon receiving the "End of battle" command, print the count of won battles in the following format:

"Won battles: {count}. Energy left: {energy}" 

### Input
-	On the first line, you will receive initial energy – an integer [1-10000].
-	On the following lines, you will be receiving the distance of an enemy – an integer [1-10000].

### Output
-	The description contains the proper output messages for each case and the format they should be printed.


### Examples

| Input  | Output |   
| ------ | ------ |
|   100    |  Not enough energy! Game ends with 7 won battles and 0 energy |
|    10     |        |
|    10    |        |
|    10    |        |
|    1    |        |
|    2    |        |
|    3    |        |
|    73    |        |
|    10    |        |
| Input  | Output |
|   200     |  Won battles: 4. Energy left: 94  |
|   54     |        |
|   14    |        |
|   28    |        |
|   13    |        |
|   End of battle    |        |

## 2.	Shoot for the Win

Write a program that helps you keep track of your shot targets. You will receive a sequence with integers, separated by a single space, representing targets and their value. Afterward, you will be receiving indices until the "End" command is given, and you need to print the targets and the count of shot targets.

Every time you receive an index, you need to shoot the target on that index, if it is possible. 

Every time you shoot a target, its value becomes -1, and it is considered a shot. Along with that, you also need to:
-	Reduce all the other targets, which have greater values than your current target, with its value. 
-	Increase all the other targets, which have less than or equal value to the shot target, with its value.

Keep in mind that you can't shoot a target, which is already shot. You also can't increase or reduce a target, which is considered a shot.

When you receive the "End" command, print the targets in their current state and the count of shot targets in the following format:

"Shot targets: {count} -> {target1} {target2}… {targetn}"


### Input / Constraints
-	On the first line of input, you will receive a sequence of integers, separated by a single space – the targets sequence.
-	On the following lines, until the "End" command, you be receiving integers each on a single line – the index of the target to be shot.

### Output
- The format of the output is described above in the problem description.

| Input  | Output |
| ------ | ------ |
| 24 50 36 70     | Shot targets 3 -> -1 -1 130 -1     |
| 0    |     |  
| 4     |     |
| 3     |     |
| 1     |     |  
| End     |     |   
| Input  | Output |
| 30 30 12 60 54 66     | Shot targets: 4 -> -1 120 -1 66 -1 -1  |
| 5     |     |  
| 2     |     |
| 4     |     |
| 0     |     |  
| End     |     |  

## 3.	Moving Target

You are at the shooting gallery again, and you need a program that helps you keep track of moving targets. On the first line, you will receive a sequence of targets with their integer values, split by a single space. Then, you will start receiving commands for manipulating the targets until the "End" command. The commands are the following:
<ul>
 <li>"Shoot {index} {power}"</li>
 <ul>
     <li>Shoot the target at the index if it exists by reducing its value by the given power (integer value).</li> 
     <li>Remove the target if it is shot. A target is considered shot when its value reaches 0.</li>
</ul>
 <li>"Add {index} {value}"</li>
 <ul>
     <li>Insert a target with the received value at the received index if it exists. </li> 
     <li>If not, print: "Invalid placement!"</li>
</ul>
 <li>"Strike {index} {radius}"</li>
 <ul>
     <li>Remove the target at the given index and the ones before and after it depending on the radius.</li> 
     <li>If any of the indices in the range is invalid, print: "Strike missed!" and skip this command.</li>
</ul>
<li>"End"</li>
 <ul>
     <li>Print the sequence with targets in the following format and end the program: "{target1}|{target2}…|{targetn}"
</ul>


</ul>

### Input / Constraints
-	On the first line, you will receive the sequence of targets – integer values [1-10000].
-	On the following lines, until the "End" will be receiving the command described above – strings.
-	There will never be a case when the "Strike" command would empty the whole sequence.

### Output
-	Print the appropriate message in case of any command if necessary.
-	In the end, print the sequence of targets in the format described above.

### Examples 

| Input  | Output |   
| ------ | ------ |
|   52 74 23 44 96 110    |     Invalid placement! <br> 52\|100  |
|      Shoot 5 10           |                 |
|      Shoot 1 80           |                 |
|      Strike 2 1           |                 |
|      Add 22 3           |                 |
|      End         |                 |
| Input  | Output |
|  1 2 3 4 5   |  Strike missed! <br> 1\|2\|3\|4\|5   |
|  Strike 0 1   |        |
|  End   |        |



