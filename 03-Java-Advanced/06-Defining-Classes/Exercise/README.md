# Exercises: Defining Classes

## 1. Opinion Poll

Create a Person class with two fields String name and int age. Write a program that reads from the console N lines of personal information and then prints all people whose age is more than 30 years, sorted in alphabetical order. Print in the following format "{name} – {age}".

Note: you can use the stream() to filter people.

### Examples

| Input  | Output |   
| ------ | ------ |
| 3 <br> Peter 12 <br> Steven 31 <br> John 48      | John - 48 <br>Steven - 31 |
| 5 <br> Sofia 33 <br> Thomas 88 <br> Camilla 22 <br> Robert 44 <br> Owen 11  | Robert - 44 <br> Sofia - 33 <br> Thomas - 88 |



## 2.	Company Roster
Define a class Employee that holds the following information: name, salary, position, department, email, and age. The name, salary, position, and department are mandatory, while the rest are optional. 

Your task is to write a program that takes N lines of information about employees from the console and calculates the department with the highest average salary, and prints for each employee in that department his name, salary, email, and age - sorted by salary in descending order. If an employee doesn't have an email – in place of that field, you should print "n/a" instead, if he doesn't have an age – print "-1" instead. Print in the following format:

"Highest Average Salary: {department}
{name1} {salary1} {email1} {age1}
{name2} {salary2} {email2} {age2}
…
{namen} {salaryn} {emailn} {agen}"

The salary should be printed to two decimal places after the separator.

Hint: You can define a Department class that holds a list of employees.


### Examples
| Input  | Output |   
| ------ | ------ |
| 4 <br> Peter 120.00 Dev Development peter@abv.bg 28 <br> Tina 333.33 Manager Marketing 33 <br> Sam 840.20 ProjectLeader Development sam@sam.com <br>George 0.20 Freeloader Nowhere 18 | Highest Average Salary: Development <br> Sam 840.20 sam@sam.com -1 <br> Peter 120.00 peter@abv.bg 28 |
| 6<br>Silver 496.37 Temp Coding silver@yahoo.com<br>Sam 610.13 Manager Sales<br>John 609.99 Manager Sales john@abv.bg 44<br>Venci 0.02 Director BeerDrinking beer@beer.br 23<br>Andre 700.00 Director Coding<br>Popeye 13.3333 Sailor SpinachGroup popeye@pop.ey|   Highest Average Salary: Sales<br>Sam 610.13 n/a -1<br>John 609.99 john@abv.bg 44 |



## 3.	* Speed Racing
Your task is to implement a program that keeps track of cars and their fuel and supports methods for moving the cars. Define a class Car that keeps track of a car information Model, fuel amount, fuel cost for 1 kilometer, and distance traveled. A Car Model is unique - there will never be 2 cars with the same model.

On the first line of the input, you will receive a number N - the number of cars you need to track, on each of the next N lines you will receive information for a car in the following format "{Model} {FuelAmount} {FuelCostFor1km}", all cars start at 0 kilometers traveled.

After the N lines, until the command "End" is received, you will receive commands in the following format "Drive {CarModel} {amountOfKm}", implement a method in the Car class to calculate whether a car can move that distance or not. If yes, the car fuel amount should be reduced by the amount of used fuel, and its distance traveled should be increased by the amount of kilometers traveled, otherwise, the car should not move (Its fuel amount and distance traveled should stay the same) and you should print on the console "Insufficient fuel for the drive". After the "End" command is received, print each car in order of appearing in input, and its current fuel amount and distance traveled in the format "{Model} {fuelAmount} {distanceTraveled}", where the fuel amount should be printed to two decimal places after the separator.

### Examples 

| Input  | Output |   
| ------ | ------ |
| 2 <br> AudiA4 23 0.3 <br> BMW-M2 45 0.42 <br> Drive BMW-M2 56 <br> Drive AudiA4 5 <br> Drive AudiA4 13 <br> End | AudiA4 17.60 18 <br> BMW-M2 21.48 56 |
| 3<br>AudiA4 18 0.34<br>BMW-M2 33 0.41<br>Ferrari-488Spider 50 0.47<br>Drive Ferrari-488Spider 97<br>Drive Ferrari-488Spider 35<br>Drive AudiA4 85<br>Drive AudiA4 <br>End | Insufficient fuel for the drive <br> Insufficient fuel for the drive <br> AudiA4 1.00 50 <br> BMW-M2 33.00 0 <br>Ferrari-488Spider 4.41 97 |




## 4.  Raw Data
You are the owner of a courier company, and you want to make a system for tracking your cars and their cargo. Define a class Car that holds information about the model, engine, cargo, and a collection of exactly 4 tires. The engine, cargo, and tire should be separate classes, create a constructor that receives all information about the Car and creates and initializes its inner components (engine, cargo, and tires).

On the first line of the input, you will receive a number N - the number of cars you have, on each of the next N lines, you will receive information about a car in the format: 

"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}", where the speed, power, weight and tire age are integers, tire pressure is a double. 

After the N lines, you will receive a single line with one of 2 commands "fragile" or "flamable", if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1 if the command is "flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250. The cars should be printed in order of appearing in the input.	

### Examples 
| Input  | Output |   
| ------ | ------ |
| 2 <br> ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4 <br> Citroen2CV 190 165 1200 fragile 0.9 3 0.85 2 0.95 2 1.1 1 <br> fragile  | Citroen2CV |
| 4<br>ChevroletExpress 215 255 1200 flamable 2.5 1 2.4 2 2.7 1 2.8 1<br>ChevroletAstro 210 230 1000 flamable 2 1 1.9 2 1.7 3 2.1 1<br>DaciaDokker 230 275 1400 flamable 2.2 1 2.3 1 2.4 1 2 1<br>Citroen2CV 190 165 1200 fragile 0.8 3 0.85 2 0.7 5 0.95 2<br>flamable | ChevroletExpress <br> DaciaDokker |



## 5.	Car Salesman
Define two classes Car and Engine. A Car has a model, engine, weight, and color. An Engine has a model, power, displacement, and efficiency. A Car's weight, color, Engine displacements, and efficiency are optional. 

On the first line, you will read a number N which will specify how many lines of engines you will receive, on each of the next N lines, you will receive information about an Engine in the following format "{Model} {Power} {Displacement} {Efficiency}". After the lines with engines, on the next line, you will receive a number M - specifying the number of Cars that will follow, on each of the next M lines the information about a Car will follow in the following format "{Model} {Engine} {Weight} {Color}", where the engine in the format will be the model of an existing Engine. When creating the object for a Car, you should keep a reference to the real engine in it, instead of just the engine's model, note that the optional properties might be missing from the formats.

Your task is to print each car (in the order you received them) and its information in the format defined below. If any of the optional fields have not been given, print "n/a" in its place instead of:

"{CarModel}:
{EngineModel}:
Power: {EnginePower}
Displacement: {EngineDisplacement}
Efficiency: {EngineEfficiency}
Weight: {CarWeight}
Color: {CarColor}"


### Examples 
| Input  | Output |   
| ------ | ------ |
| 2 <br> V8-101 220 50 <br> V4-33 140 28 B <br> 3 <br> FordFocus V4-33 1300 Silver <br> FordMustang V8-101 <br> VolkswagenGolf V4-33 Orange |  FordFocus: <br>V4-33: <br>Power: 140 <br>Displacement: 28<br>Efficiency: B<br>Weight: 1300<br>Color: Silver<br>FordMustang:<br>V8-101:<br>Power: 220<br>Displacement: 50<br>Efficiency: n/a<br>Weight: n/a<br>Color: n/a<br>VolkswagenGolf:<br>V4-33:<br>Power: 140<br>Displacement: 28<br>Efficiency: B<br>Weight: n/a<br>Color: Orange|
| 4 <br> DSL-10 280 B <br> V7-55 200 35 <br> DSL-13 305 55 A+ <br> V7-54 190 30 D <br> 4 <br> FordMondeo DSL-13 Purple <br>VolkswagenPolo V7-54 1200 Yellow <br> VolkswagenPassat DSL-10 1375 Blue <br> FordFusion DSL-13 | FordMondeo:<br>DSL-13:<br>Power: 305<br>Displacement: 55<br>Efficiency: A+<br>Weight: n/a<br>Color: Purple<br>VolkswagenPolo:<br>V7-54:<br>Power: 190<br>Displacement: 30<br>Efficiency: D<br>Weight: 1200<br>Color: Yellow<br>VolkswagenPassat:<br>DSL-10:<br>Power: 280<br>Displacement: n/a<br>Efficiency: B<br>Weight: 1375<br>Color: Blue<br>FordFusion:<br>DSL-13:<br>Power: 305<br>Efficiency: A+<br>Weight: n/a<br>Color: n/a |