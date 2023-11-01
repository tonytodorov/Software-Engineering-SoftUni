# Lab: Objects and Classes

## 1. Randomize Words

You are given a list of words in one line. Randomize their order and print each word on a separate line.

### Examples

| Input  | Output |   
| ------ | ------ |
| Welcome to SoftUni and have fun learning programming This is some message for you |     |
| Input  | Output |
| Java is the best programming language|    |


## 2. Sum Big Numbers

You will receive two numbers (0 to 1050), and print their sum.

Print the result in the following format "The winner is {left/right} with total time: {total time}", formatted with one digit after the decimal point.

| Input  | Output |
| ------ | ------ |
|923847238931983192462832102  | 934573817465075391826664309019448  |
|934572893617836459843471846187346  |          |
| Input  | Output |
|4       | 104   |
|100       |    |


## 3. Big Factorial

You will receive N - the number in the range [0 - 1000]. Calculate the Factorial of N and print the result


### Examples 

| Input  | Output |   
| ------ | ------ |
| 5 |  120    |
| Input  | Output |
| 50 |  30414093201713378043612608166064768844377641568960512000000000000  |


## 4. Songs

Define a class Song, which holds the following information about songs: Type List, Name, and Time.

On the first line, you will receive the number of songs - N.

On the next N-lines, you will be receiving data in the following format: "{typeList}_{name}_{time}".

On the last line, you will receive "Type List" / "all". Print only the names of the songs which are from that Type List / All songs.


### Examples

| Input  | Output |   
| ------ | ------ |
| 3      | DownTown       |
| favourite_DownTown_3:14      |   Kiss     |
| favourite_Kiss_4:16      |    Smooth Criminal      |
| favourite_Smooth Criminal_4:01     |      |
| favourite       |                 |
| Input  | Output |  
| 4      |   Andalouse     |
| favourite_DownTown_3:14      |        |
| listenLater_Andalouse_3:24    |        |
| favourite_In To The Night_3:58   |        |
| favourite_Live It Up_3:48      |                 |
| listenLater      |                 |
| Input  | Output |  
| 2      |   Replay     |
| like_Replay_3:15     |   Photoshop     |
| ban_Photoshop_3:48      |        |
| all    |        |


## 5.	Students

Define a class Student, which holds the following information about students: first name, last name, age, and hometown.

Read the list of students until you receive the "end" command. After that, you will receive a city name. Print only students which are from the given city, in the following format: "{firstName} {lastName} is {age} years old".

### Examples

| Input  | Output |   
| ------ | ------ |
| John Smith 15 Sofia   |   John Smith is 15 years old  |
| Peter Ivanov 14 Plovdiv   | Linda Bridge is 16 years old  |
|  Linda Bridge 16 Sofia    |         |
|   Simon Stone 12 Varna   |         |
|   end     |         |
|   Sofia    |         |
| Input  | Output |  
| Anthony Taylor 15 Chicago  |   Anthony Taylor is 15 years old |
| David Anderson 16 Washington   | Jack Lewis is 14 years old  |
|  Jack Lewis 14 Chicago    |  David Lee is 14 years old       |
|   David Lee 14 Chicago  |         |
|   end     |         |
|   Chicago    |         |

## 5.	Students 2.0

Use the class from the previous problem. If you receive a student who already exists (first name and last name should be unique), overwrite the information.

### Examples

| Input  | Output |   
| ------ | ------ |
| John Smith 15 Sofia   |   John Smith is 16 years old  |
| John Smith 16 Sofia   | Linda Bridge is 17 years old  |
|  Linda Bridge 17 Sofia    |         |
|   Simon Stone 12 Varna   |         |
|   end     |         |
|   Sofia    |         |
| Input  | Output |  
| J S 3 S  |   Simon Stone is 12 years old|
| Peter Ivanov 14 P  | Simon Sone is 12 years old  |
|  P J 104 S   |       |
|   J P 61 S  |         |
|   Simon Stone 12 Varna  |         |
|   Simon Sone 12 Varna  |         |
|   end     |         |
|   Varna    |         |