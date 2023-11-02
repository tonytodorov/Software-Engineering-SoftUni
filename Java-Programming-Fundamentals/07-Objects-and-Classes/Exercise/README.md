# Exercise: Objects and Classes

## 1. Advertisement Message

Write a program that generates random fake advertisement messages to extol some product. The messages must consist of 4 parts: laudatory phrase + event + author + city. Use the following predefined parts:

<ul>

<li>Phrases
    <ul>
        <li>"Excellent product."</li>
        <li>"Such a great product."</li>
        <li>"I always use that product."</li>
        <li>"I always use that product."</li>
        <li>"Exceptional product."</li>    
        <li>"I can’t live without this product."</li>
    </ul>
</li>

<li>Events
    <ul>
        <li>"Now I feel good."</li>
        <li>"I have succeeded with this product."</li>
        <li>"Makes miracles. I am happy of the results!"</li>
        <li>"I cannot believe but now I feel awesome."</li>
        <li>"Try it yourself, I am very satisfied."</li>    
        <li>"I feel great!"</li>
    </ul>
</li>

<li>Authors
    <ul>
        <li>"Diana"</li>
        <li>"Petya"</li>
        <li>"Stella"</li>
        <li>"Elena"</li>
        <li>"Katya"</li>
        <li>"Iva"</li>
        <li>"Annie"</li>
        <li>"Eva"</li>
    </ul>
</li>
    

<li>Cities
    <ul>
        <li>"Burgas"</li>
        <li>"Sofia"</li>
        <li>"Plovdiv"</li>
        <li>"Varna"</li>
        <li>"Ruse"</li>
    </ul>
</li>
</ul>

The format of the output message is: "{phrase} {event} {author} – {city}".

As an input, you take the number of messages to be generated. Print each random message on a separate line.

### Examples

| Input  | Output |   
| ------ | ------ |
| 3       |  Such a great product. Now I feel good. Elena – Ruse   |
|        |  Excelent product. Makes miracles. I am happy of the results! Katya – Varna   |
|        | Best product of its category. That makes miracles. Eva – Sofia    |
|        |     |
| Input  | Output |
|    4   | I always use that product. Makes miracles. I am happy of the results! Iva - Ruse     |
|        |  I can’t live without this product. I cannot believe but now I feel awesome. Katya - Burgas   |
|        | Such a great product. Try it yourself, I am very satisfied. Iva - Varna    |
|        |  Best product of its category. I cannot believe but now I feel awesome. Eva - Ruse   |
|        |     |



## 2. Articles

Create an article class with the following properties:

-	Title – a string
-	Content – a string
-	Author – a string

The class should have a constructor and the following methods:

-	Edit (new content) – change the old content with the new one
-	ChangeAuthor (new author) – change the author
-	Rename (new title) – change the title of the article
-	override ToString – print the article in the following format: 
"{title} - {content}: {author}"

Write a program that reads an article in the following format "{title}, {content}, {author}". On the next line, you will get the number n. On the next n lines, you will get one of the following commands: 

-	"Edit: {new content}"
-	"ChangeAuthor: {new author}"
-	"Rename: {new title}". 

At the end, print the final article.


| Input  | Output |
| ------ | ------ |
|some title, some content, some author  |   better title - better content: better author         |
|  3       |          |
|  Edit: better content       |          |
|   ChangeAuthor:  better author      |          |
|   Rename: better title     |          |
| Input  | Output |
| Holy Ghost, content, John Sandford     | 104   |
|  3       |          |
|  ChangeAuthor:  Mitch Albom      |          |
|   ChangeAuthor:  better author      |          |
|   ChangeAuthor:  Kim Heacox   |          |


## 3. Opinion Poll

Using the Person class, write a program that reads from the console N lines of personal information and then prints all people whose age is more than 30 years.


### Examples 

| Input  | Output |   
| ------ | ------ |
| 3      |    Sam - 31    |
| Peter 12      |   Itan - 48     |
| Sam 31     |        |
| Itan 48      |        |
| Input  | Output |
| 5      |   Niko - 33   |
| Niko 33      |   Yana - 88   |
| Yana 88     |   Lisa  - 44     |
| Todor 22      |        |
| Lisa 44      |        |
| Sam 11      |        |


## 4. Students

Write a program that receives n count of students and orders them by grade (in descending). Each student should have a first name (string), a last name (string), and a grade (a floating-point number). 

## Input
-	First-line will be a number n.
-	Next n lines you will get student info in the format "{first name} {second name} {grade}".

## Output
-	Print each student in the following format "{first name} {second name}: {grade}".


### Examples

| Input  | Output |   
| ------ | ------ |
| 4      | Rocco Erben: 6.00       |
| Lakia Eason 3.90     |  Prince Messing: 5.49    |
| Prince Messing 5.49     |    Akiko Segers: 4.85      |
| Akiko Segers 4.85    |   Lakia Eason: 3.90   |
| Rocco Erben 6.00     |                 |
| Input  | Output |  
| 4      | Sydnie Britton: 5.79      |
| Sydnie Britton 5.79     |  Mora Tod: 2.78   |
| Amias Mathews 2.30     |    Pete Kendrick: 2.61     |
| Mora Tod 2.78   |   Amias Mathews: 2.30   |
| Pete Kendrick 2.61     |                 |


## 5.	Vehicle Catalogue

You have to make a catalog for vehicles. You will receive two types of vehicles - a car or a truck. 
Until you receive the command "End" you will receive lines of input in the format:

"{typeOfVehicle} {model} {color} {horsepower}"

After the "End" command, you will start receiving models of vehicles. Print for every received vehicle its data in the format:

Type: {typeOfVehicle}
Model: {modelOfVehicle}
Color: {colorOfVehicle}
Horsepower: {horsepowerOfVehicle}

When you receive the command "Close the Catalogue", stop receiving input and print the average horsepower for the cars and the trucks in the format:

"{typeOfVehicles} have average horsepower of {averageHorsepower}."

The average horsepower is calculated by dividing the sum of horsepower for all vehicles of the type by the total count of vehicles from the same type.

Format the answer to the 2nd decimal point.

## Constraints
-	The type of vehicle will always be a car or truck.
-	You will not receive the same model twice.
-	The received horsepower will be an integer in the interval [1…1000].
-	You will receive at most 50 vehicles.
-	Single whitespace will be used for the separator.

### Examples

| Input  | Output |   
| ------ | ------ |
| truck Man red 200  |   Type: Car  |
| truck Mercedes blue 300  | Model: Ferrari  |
|  car Ford green 120   |   Color: red      |
|   car Ferrari red 550   |   Horsepower: 550      |
|   car Lamborghini orange 570    |   Type: Car      |
|   End   |     Model: Ford    |
|   Ferrari   |   Color: green      |
|   Ford   |   Horsepower: 120      |
|   Man   |   Type: Truck      |
|   Close the Catalogue   |    Model: Man     |
|                         |     Color: red              |
|                         |     Horsepower: 200             |
|                         |     Cars have average horsepower of: 413.33.             |
|                         |     Trucks have average horsepower of: 250.00.              |
| Input  | Output |  
| car Opel green 736  |  Cars have average horsepower of: 736.00. |
| End   | Trucks have average horsepower of: 0.00.  |
| Close the Catalogue     |      |


## 6.	Order by Age

You will receive an unknown number of lines. On each line, you will receive an array with 3 elements. The first element will be a string and represents the name of the person. The second element will be a string and will represent the ID of the person. The last element will be an integer which represents the age of the person.
When you receive the command "End", stop taking input and print all the people, ordered by age.

### Examples

| Input  | Output |   
| ------ | ------ |
| George 123456 20  |   Stephan with ID: 524244 is 10 years old.  |
| Peter 78911 15   | Peter with ID: 78911 is 15 years old. |
|  Stephan 524244 10    |   George with ID: 123456 is 20 years old.      |
|   End   |         |
| Input  | Output |  
| Cindy 88611 2  |   Cindy with ID: 88611 is 2 years old.  |
| Kaloyan 13967 3   | Kaloyan with ID: 13967 is 3 years old. |
|  Simona 53316 11   |   Simona with ID: 53316 is 11 years old.      |
|  Gil 31837 72    |        Gil with ID: 31837 is 72 years old.       |
|   End   |         |