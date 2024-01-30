# Exercise: Regular Expressions

## 1.	Furniture

Write a program to calculate the total cost of different types of furniture. You will be given some lines of input until you receive the line "Purchase". For the line to be valid, it should be in the following format:

">>{furniture name}<<{price}!{quantity}"

The price can be a floating-point number or a whole number. Store the names of the furniture and the total price. In the end, print each bought furniture on a separate line in the format:

"Bought furniture:

{1st name}

{2nd name}

…"

And on the last line, print the following: "Total money spend: {spend money}", formatted to the second decimal point.


### Examples

| Input  | Output |   
| ------ | ------ |
| >>Sofa<<312.23!3      |  Bought furniture:           |
| >>TV<<300!5      |   Sofa          |
| >Invalid<<!5     |     TV        |
| Purchase     |   Total money spend: 2436.69          |
| Input    | Output |
| >>TV<<312.23!3      |  Bought furniture:           |
| >>Monitor<<300!5      |   TV          |
| >>Invalid<<<<!5    |     Monitor        |
| >>Sink<<220!10    |    Sink           |
| >>>>>>Invalid<<!5       |    Total money spend: 4636.69            |
| Purchase     |              |


## 2.	*SoftUni Bar Income
Let's take a break and visit the game bar at SoftUni. It is about time for the people behind the bar to go home, and you are the person who has to draw the line and calculate the money from the products that were sold throughout the day. Until you receive a line with the text "end of shift", you will be given lines of input. But before processing that line, you have to do some validations first.

Each valid order should have a customer, product, count, and price:
-	Valid customer's name should be surrounded by '%' and must start with a capital letter, followed by lower-case letters.
-	Valid product contains any word character and must be surrounded by '<' and '>'.
-	The valid count is an integer surrounded by '|'.
-	The valid price is any real number followed by '$'.

The parts of a valid order should appear in the order given: customer, product, count, and price.

Between each part there can be other symbols, except ('|', '$', '%' and '. ')

For each valid line print on the console: "{customerName}: {product} - {totalPrice}"

When you receive "end of shift", print the total amount of money for the day rounded to 2 decimal places in the following format: "Total income: {income}".

## Input / Constraints
-	Strings must be processed until you receive the text "end of shift".

## Output
-	Print all the valid lines in the format "{customerName}: {product} - {totalPrice}".
-	After receiving "end of shift" print the total amount of money for the day rounded to 2 decimal places in the following format: "Total income: {income}".
-	Allowed working time / memory: 100ms / 16MB.

| Input  | Output |
| ------ | ------ |
| %George%<Croissant>\|2\|10.3$ |    George: Croissant - 20.60             |
| %Peter%<Gum>\|1\|1.3$ |    Peter: Gum - 1.30             |
| %Maria%<Cola>\|1\|2.4$ |   Maria: Cola - 2.40              |
| end of shift |      Total income: 24.30           |
| Input  | Output |
| %InvalidName%<Croissant>\|2\|10.3$      |     Valid: Valid - 200.00            |
| %Peter%<Gum>1.3$      |    Total income: 200.00             |
| %Maria%<Cola>\|1\|2.4     |                 |
| %Valid%<Valid>valid\|10\|valid20$     |                 |



## 3.	*Star Enigma
The war is at its peak, but you, young Padawan, can turn the tides with your programming skills. You are tasked to create a program to decrypt the messages of The Order and prevent the death of hundreds of lives. 

You will receive several messages, which are encrypted using the legendary star enigma. You should decrypt the messages following these rules:

To properly decrypt a message, you should count all the letters [s, t, a, r] - case insensitive and remove the count from the current ASCII value of each symbol of the encrypted message.

After decryption:

Each message should have a planet name, population, attack type ('A', as an attack or 'D', as destruction), and soldier count.

The planet's name starts after '@' and contains only letters from the Latin alphabet. 

The planet population starts after ':' and is an Integer;

The attack type may be "A"(attack) or "D"(destruction) and must be surrounded by "!" (Exclamation mark).

The soldier count starts after "->" and should be an Integer.

The order in the message should be: planet name -> planet population -> attack type -> soldier count. Each part can be separated from the others by any character 
except: '@', '-', '!', ':' and '>'.

## Input / Constraints
-   The first line holds n - the number of messages - integer in the range [1…100].
-	On the next n lines, you will be receiving encrypted messages.

## Output
After decrypting all messages, you should print the decrypted information in the following format:

First print the attacked planets, then the destroyed planets.

"Attacked planets: {attackedPlanetsCount}"
"-> {planetName}"
"Destroyed planets: {destroyedPlanetsCount}"
"-> {planetName}"

The planets should be ordered by name alphabetically.

### Examples 

| Input  | Output |   
| ------ | ------ |
| 2          |    Attacked planets: 1   |
|    STCDoghudd4=63333$D$0A53333                            |       -> Alderaa          |
|     EHfsytsnhf?8555&I&2C9555SR                           |   Destroyed planets: 1          |
|                                                           |      -> Cantonica                         |
| Input  | Output |
| 3          |    Attacked planets: 0   |
|   tt(''DGsvywgerx>6444444444%H%1B9444                            |       Destroyed planets: 2         |
|     GQhrr|A977777(H(TTTT                           |   -> Cantonica         |
|     EHfsytsnhf?8555&I&2C9555SR                     |      -> Coruscant        |



# 4.	*Nether Realms
A mighty battle is coming. In the stormy nether realms, demons fight against each other for supremacy in a duel from which only one will survive.

Your job, however, is not so exciting. You must sign in all the participants in the nether realm's mighty battle's demon book. 

A demon's name contains his health and his damage. 

The sum of the asci codes of all characters (excluding numbers (0-9), arithmetic symbols ('+', '-', '*', '/') and delimiter dot ('.')) gives a demon's total health. 

The sum of all numbers in his name forms his base damage. Note that you should consider the plus '+' and minus '-' signs (e.g., +10 is 10 and -10 is -10). However, there are some symbols ('*' and '/') that can further alter the base damage by multiplying or dividing it by 2 (e.g. in the name "m15*/c-5.0", the base damage is 15 + (-5.0) = 10 and then you need to multiply it by 2 (e.g. 10 * 2 = 20) and then divide it by 2 (e.g. 20 / 2 = 10)). 

So, multiplication and division are applied only after all numbers are included in the calculation and the order they appear in the name. 

## Input
The input will be read from the console. The input consists of a single line containing all demon names separated by commas and zero or more spaces in the format: "{demon name}, {demon name}, … , {demon name}"

## Output
Print all demons, each on a separate line in the format:
-	"{demon name} - {health points} health, {damage points} damage"

## Constraints
-	A demon's name will contain at least one character.
-	A demon's name cannot contain blank spaces ' ' or commas ','.
-	A floating-point number will always have digits before and after its decimal separator.
-	The number in a demon's name is considered everything that is a valid integer or floating point number (with a dot '.' used as separator). For example, all these are valid numbers: '4', '+4', '-4', '3.5', '+3.5', '-3.5'.

### Examples 

| Input  | Output |   
| ------ | ------ |
|  M3ph-0.5s-0.5t0.0**          |    M3ph-0.5s-0.5t0.0** - 524 health, 8.00 damage   |
| Input  | Output |
|  M3ph1st0**, Azazel          |    M3ph1st0** - 524 health, 16.00 damage   |
|                                        |    Azazel - 615 health, 0.00 damage                |
| Input  | Output |
|  Gos/ho          |   Gos/ho - 512 health, 0.00 damage   |


# 5.	*Extract Emails
Write a program to extract all email addresses from a given text. The text comes at the only input line. Print the emails on the console, each at a separate line. Emails are considered to be in format <user>@<host>, where: 

-	\<user\> is a sequence of letters and digits, where '.', '-' and '_' can appear between them.
-	\<host\> is a sequence of at least two words, separated by dots '.'. Each word is a sequence of letters and can have hyphens '-' between the letters.

### Examples 

| Input  | Output |   
| ------ | ------ |
|  Please contact us at: support@github.com.         |   support@github.com   |
| Input  | Output |
|  Just send email to s.miller@mit.edu and j.hopking@york.ac.uk for more information.         |   s.miller@mit.edu   |
|                                        |    j.hopking@york.ac.uk                |


# 6.	*Valid Password
Your first task is to determine if the given sequence of characters is a valid online banking password. 

Each line must not contain anything else but a valid password. A password is valid when:
-	It is surrounded by a "_" followed by one or more "."
-	It is at least 6 characters long (without the surrounding "_" or ".")
-	It starts with a capital letter
-	It contains only letters (lower and upper case) and digits
-	It ends with a capital letter

Next, you have to determine which group the password is from. The group is obtained by concatenating all the digits found in the password, if any. If there are no digits present in the password, the default group is "default".

Examples:  

_...ChelseA_. -> group: default

_..Online1BankinG_. -> group: 1

_.A123f23A_.-> group: 12323


## Input
On the first line, you will be given an integer n - the count of passwords that you will be receiving next. 

On the following n lines, you will receive different strings.

## Output
For each password that you process, you need to print a message.

If the password is invalid:
-	"Invalid pass!"

If the password is valid:
-	"Group: {group}"


### Examples 

| Input  | Output |   
| ------ | ------ |
|       3         |    Group: default           |
|       _...ChelseA_.         |       Group: 1        |
|       _..Online1BankinG_.         |   Group: 123            |
|       _.A1f23A_.         |               |
| Input  | Output |
|       5         |    Group: 2          |
|      _.Online2BanK_.        |      Invalid pass!     |
|       __.Pass2Da_.        |       Invalid pass!           |
|      _.InvaliDitem_.      |    Group: 247           |
|     _.My2Pass47S_...     |   Group: default            |
|     _...QAPassV_..     |               |