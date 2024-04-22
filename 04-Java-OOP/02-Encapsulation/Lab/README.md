# Lab: Encapsulation

##  1.	Sort by Name and Age
Create a class Person, which should have private fields for:
-	firstName: String
-	lastName: String
-	age: int
-	toString() - override


### Examples

| Input  | Output |   
| ------ | ------ |
| 5 <br> Angel Ivanov 65 <br> Boris Georgiev 57 <br> Veny Ivanov 27 <br> Angel Harizanov 44 <br> Boris Angelov 35 | Angel Harizanov is 44 years old.<br>Angel Ivanov is 65 years old.<br>Boris Angelov is 35 years old.<br>Boris Georgiev is 57 years old.<br>Veny Ivanov is 27 years old. |
| 4 <br> Sara Cameron 21<br> John Petrovich 53<br> Anna Glen 21 <br> John Alekseevich 43 | Anna Glen is 21 years old. <br>John Alekseevich is 43 years old. <br>John Petrovich is 53 years old. <br>Sara Cameron is 21 years old. |


## 	2.	Salary Increase
Read person with their names, age, and salary. Read percent bonus to every person salary. People younger than 30 get a half bonus. Expand Person from the previous task. Add salary field and getter and setter with proper access.
New fields and methods
-	salary: double 
-	increaseSalary(double bonus)


### Examples
| Input  | Output |
| ------ | ------ |
| 5<br>Angel Ivanov 65 2200<br>Boris Georgiev 57 3333<br>Veny Ivanov 27 600<br>Angel Harizanov 44 666.66<br>Boris Angelov 35 559.4 <br>20 | Angel Ivanov gets 2640.0 leva<br>Boiko Georgiev gets 3999.6 leva<br>Veny Ivanov gets 660.0 leva<br>Angel Harizanov gets 799.992 leva<br>Boris Angelov gets 671.28 leva |
| 4 <br> Sara Cameron 21 1200 <br> John Petrovich 53 850.50 <br> Anna Glen 21 1640 <br> John Alekseevich 43 2100 <br> 13 | Sara Cameron gets 1278.0 leva<br>John Petrovich gets 961.065 leva<br>Anna Glen gets 1746.6 leva<br>John Alekseevich gets 2373.0 leva |


## 3.	Validation Data
Expand Person with proper validation for every field:
-	Names must be at least 3 symbols
-	Age must not be zero or negative
-	Salary can't be less than 460.0 

Print proper message to end-user (look at an example for messages). 

Don't use System.out.println() in Person class.


### Examples 

| Input  | Output |   
| ------ | ------ |
|5<br>Asen Ivanov -6 2200<br>B Borisov 57 3333<br>Ventsislav Ivanov 27 600<br>Asen H 44 666.66<br>Boiko Angelov 35 300<br>20 |  Age cannot be zero or negative integer<br>First name cannot be less than 3 symbols<br>Last name cannot be less than 3 symbols<br>Salary cannot be less than 460 leva<br>Ventsislav Ivanov gets 660.0 leva |
| 4<br>Sara Cameron 21 1200<br>John Petrovich -53 850.50<br>Anna Glen 21 430<br>John Alekseevich 0 2100<br>13 | Age cannot be zero or negative integer<br>Salary cannot be less than 460 leva<br>Age cannot be zero or negative integer<br>Sara Cameron gets 1278.0 leva |   


## 4.	First and Reserve Team
Create a Team class. Add to this team all people you read. All people younger than 40 go on the first team, others go on the reverse team. At the end print first and reserve team sizes.

The class should have private fields for:
-	name: String
-	firstTeam: List&lt;Person>&gt;
-	reserveTeam: List&lt;Person>&gt;

The class should have constructors:
-	Team(String name)

The class should also have private method for setName and public methods for:
-	getName(): String
-	addPlayer(Person person): void
-	getFirstTeam(): List&lt;Person>&gt; (Collections.unmodifiableList)
-	getReserveTeam(): List&lt;Person>&gt; (Collections.unmodifiableList)

### Examples

| Input  | Output |   
| ------ | ------ |
| 5<br>Asen Ivanov 20 2200<br>Boiko Borisov 57 3333<br>Ventsislav Ivanov 27 600<br>Grigor Dimitrov 25 666.66<br>Boiko Angelov 35 555 |   First team have 4 players <br> Reserve team have 1 players     |
| 4<br>Sara Cameron 21 1200<br>John Petrovich 53 850.50<br>Anna Glen 21 475<br>John Alekseevich 27 2100    |  First team have 3 players <br> Reserve team have 1 players |
