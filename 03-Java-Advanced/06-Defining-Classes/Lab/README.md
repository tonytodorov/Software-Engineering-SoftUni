# Lab: Defining Classes

## 1.	Car Info
Create a class named Car.

The class should have public fields for:
-	Brand: String
-	Model: String
-	Horsepower: int

### Examples

| Input  | Output |   
| ------ | ------ |
| 3 <br> Chevrolet Impala 390 <br> Mercedes Benz 500 <br> Volga 24 49 | The car is: Chevrolet Impala - 390 HP. <br> The car is: Mercedes Benz - 500 HP. <br> The car is: Volga 24 - 49 HP. |
| 5 <br> This Car 1 <br> Was Made 2 <br> Only For 3 <br> Test Purposes 4 <br> No Way 5 |The car is: This Car - 1 HP.<br>The car is: Was Made - 2 HP.<br>The car is: Only For - 3 HP.<br>The car is: Test Purposes - 4 HP.<br>The car is: No Way - 5 HP.|


## 2.	Car Constructors
Make proper constructors for the Car class so you can create car objects with a different type of input information.
If you miss information about the field of type String set the value to "unknown", and for an integer, fieldset -1.


### Examples
| Input  | Output |   
| ------ | ------ |
| 2 <br> Chevrolet <br> Golf Polo 49 | The car is: Chevrolet unknown - -1 HP. <br> The car is: Golf Polo - 49 HP. |
| 4 <br> Was <br>Only For 3 <br> Test Purposes 4 <br> No Way 5 | The car is: Was unknown - -1 HP. <br> The car is: Only For - 3 HP. <br> The car is: Test Purposes - 4 HP. <br> The car is: No Way - 5 HP. |

## 3.	Bank Account
Create class BankAccount.
The class should have private fields for:
-	Id: int (Starts from 1 and increments for every new account)
-	Balance: double
-	Interest rate: double (Shared for all accounts. Default value: 0.02)
The class should also have public methods for:
-	setInterestRate(double interest): void (static)
-	getInterest(int Years): double
-	deposit(double amount): void
Create a test client supporting the following commands:
-	Create
-	Deposit {Id} {Amount}
-	SetInterest {Interest}
-	GetInterest {ID} {Years}
-	End


### Examples 

| Input  | Output |   
| ------ | ------ |
| Create <br> Deposit 1 20 <br> GetInterest 1 10 <br> End | Account ID1 created <br> Deposited 20 to ID1 <br> 4.00 |
| Create <br> Create <br> Deposit 1 20 <br> Deposit 3 20 <br>Deposit 2 10<br>SetInterest 1.5 <br> GetInterest 1 1 <br> GetInterest 2 1 <br> GetInterest 3 1 <br> End | Account ID1 created <br> Account ID2 created <br> Deposited 20 to ID1 <br> Account does not exist <br> Deposited 10 to ID2 <br> 30.00 <br> 15.00 <br>Account does not exist |
