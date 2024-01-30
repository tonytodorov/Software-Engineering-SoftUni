# Lab: Regular Expressions

## 1.	Match Full Name
Write a Java Program to match full names from a list of names and print them on the console.

A valid full name has the following characteristics:
-	It consists of two words.
-	Each word starts with a capital letter.
-	After the first letter, it only contains lowercase letters afterward.
-	Each of the two words should be at least two letters long.
-	The two words are separated by a single space.

### Examples

| Input  | Output |   
| ------ | ------ |
| Ivan Ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Georgi Georgiev, Ivan   Ivanov      | Ivan Ivanov Georgi Georgiev  |
| Input    | Output |
| peter georgiev, peter Georgiev, Peter GeoRgiev, PEter GEorgiev, Peter Georgiev, Anna Petrova      | Peter Georgiev Anna Petrova  |


## 2.	Match Phone Number
Write a regular expression to match a valid phone number from Sofia. After you find all valid phones, print them on the console, separated by a comma and a space ", ".

A valid number has the following characteristics:
-	It starts with "+359".
-	Then, it is followed by the area code (always 2).
-	After that, it's followed by the number itself - the number consists of 7 digits (separated into two groups of 3 and 4 digits, respectively). 
-	The different parts are separated by either a space or a hyphen ('-').


| Input  | Output |
| ------ | ------ |
| +359 2 222 2222,359-2-222-2222, +359/2/222/2222, +359-2 222 2222 +359 2-222-2222, +359-2-222-222, +359-2-222-22222 +359-2-222-2222 | +359 2 222 2222, +359-2-222-2222    |
| Input  | Output |
| +359 2 222 2222,359-2-222-2222, +359/2/222/2222, +359-2 222 2222 +359 2-222-2222, +359-2-222-222, +359-2-222-22222 +359-2-222-2222      | +359 2 222 2222, +359-2-222-2222   |



## 3.	Match Dates
Write a program that matches a date in the format "dd{separator}MMM{separator}yyyy". Use named capturing groups in your regular expression.

Every valid date has the following characteristics:
-	Always starts with two digits, followed by a separator.
-	After that, it has one uppercase and two lowercase letters (e.g., Jan, Mar).
-	After that, it has a separator and exactly 4 digits (for the year).
-	The separator could be either of three things: a period ("."), a hyphen ("-") or a forward-slash ("/").
-	The separator needs to be the same for the whole date (e.g., 13.03.2016 is valid, 13.03/2016 is NOT). Use a group back reference to check for this.


### Examples 

| Input  | Output |   
| ------ | ------ |
| 13/Jul/1928, 10-Nov-1934, , 01/Jan-1951,f 25.Dec.1937 23/09/1973, 1/Feb/2016 |     Day: 13, Month: Jul, Year: 1928    |
|                                |  Day: 10, Month: Nov, Year: 1934       |
|                                |  Day: 25, Month: Dec, Year: 1937       |
| Input  | Output |
| 01/Jan-1951 29/Feb/2024 1/Jan-1951 27-Feb-2007 1/Jan-1951 1/Mar/2016 23/october/197 |    Day: 29, Month: Feb, Year: 2024    |
|                                |  Day: 27, Month: Feb, Year: 2007      |