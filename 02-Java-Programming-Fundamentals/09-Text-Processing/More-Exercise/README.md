# More Exercises: Strings and Text Processing

## 1.	Extract Person Information

Write a program that reads n lines of strings and extracts the name and age of a given person. The person's name will be between "@" and "|". The person's age will be between "#" and "*". 

Example: "Hello my name is @Peter| and I am #20* years old." 

For each found name and age, print a line in the following format "{name} is {age} years old."


### Examples

| Input  | Output |   
| ------ | ------ |
| 2      | George is 18 years old.  |
| Here is a name @George| and an age #18*      | Billy is 35 years old.  |
| Another name @Billy| #35* is his age      |                      |
| Input    | Output |
| 3      | lilly is 5 years old.  |
| random name @lilly| random digits #5* age      | Marry is 19 years old.  |
| @Marry| with age #19*      |         Garry is 48 years old.             |
| here Comes @Garry| he is #48* years old      |                      |


## 2. Ascii Sumator

Write a program that prints a sum of all characters between two given characters (their ASCII code). In the first line, you will get a character. In the second line, you get another character. On the last line, you get a random string. Find all the characters between the two given and print their ASCII sum.

| Input  | Output |
| ------ | ------ |
| .      | 363    |
| @      |        |
| dsg12gr5653feee5       |     |
| Input  | Output |
| ?      | 262    |
| E      |        |
| @ABCEF |        |


## 3.	**Treasure Finder
Write a program that decrypts a message by a given key and gathers information about the hidden treasure type and its coordinates. On the first line, you will receive a key (sequence of numbers). On the next few lines, until you receive "find", you will get lines of strings. You have to loop through every string and decrease the ASCII code of each character with a corresponding number of the key sequence. The way you choose a key number from the sequence is by just looping through it. If the length of the key sequence is less than the string sequence, you start looping from the beginning of the key. For more clarification, see the example below. After decrypting the message, you will get a type of treasure and its coordinates. The type will be between the symbol "&" and the coordinates will be between the symbols "<" and ">". For each line print the type and the coordinates in format "Found {type} at {coordinates}".


### Examples 

| Input  | Output |   
| ------ | ------ |
| 1 2 1 3 |     Found gold at 10N70W    |
|    ikegfp'jpne)bv=41P83X@                  |  Found Silver at 32S43W       |
|    ujfufKt)Tkmyft'duEprsfjqbvfv=53V55XA    |                              |
|    find                                     |                            |
| Input  | Output |
| 1 2 2    |   Found silver at Sofia  |
|      nqtf(ujnxft(gtqn>Uphkb@          |   File extension: cs      |
|    find                              |                           |



## 4.	*Morse Code Translator
Write a program that translates messages from Morse code to English (capital letters). Use this page to help you (without the numbers). The words will be separated by a space (' '). There will be a "|" character which you should replace with ' ' (space).


### Examples

| Input  | Output |   
| ------ | ------ |
| .. | -- .- -.. . | -.-- --- ..- | .-- .-. .. - . | .- | .-.. --- -. --. | -.-. --- -.. .   |  I MADE YOU WRITE A LONG CODE   |
| Input  | Output |  
| .. | .... --- .--. . | -.-- --- ..- | .- .-. . | -. --- - | -- .- -.. |  I HOPE YOU ARE NOT MAD |


##  5.	HTML
You will receive 3 lines of input. On the first line, you will receive a title of an article. On the next line, you will receive the content of that article. On the next n lines, until you receive "end of comments", you will get the comments about the article. Print the whole information in HTML format. The title should be in "h1" tag (<h1></h1>); the content in article tag (<article></article>); each comment should be in div tag (<div></div>). For more clarification, see the example below


### Examples

| Input  | Output |
| ------ | ------ |
| SoftUni Article     |                      |
| Some content of the SoftUni article      |        |
|      some comment                  |        |
|      more comment                  |        |
|      last comment                  |        |
|      end of comments                  |        |
| Input  | Output |
| ------ | ------ |
| The Reckoning     |                      |
| John Grishams The Reckoning is the master storytellers most powerful, surprising, and accomplished novel yet.      |        |
|      some comment1                  |        |
|      more comment2                  |        |
|      last comment3                  |        |
|      end of comments                  |        |