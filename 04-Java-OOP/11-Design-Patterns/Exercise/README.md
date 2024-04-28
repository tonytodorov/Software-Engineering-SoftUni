# Exercises: Design Patterns

## 1. Singleton

Create a Hashcode class that has a String point field and its only instance. There is also a constructor that initializes the point, as well as a getInstance() method based on the Singleton Design Pattern. Create a HashcodeDemo class in which to test the Hashcode class method. You can take the real hashcode with the .hashCode() method.

## 2. Cake Factory

The CakeInterface and the abstract class Cake that implements it are given. Your task is to create 4 types of different cakes – BiscuitCake, ChocolateCake, SpinachCake, and WhiteCake, that use the methods of the Cake class.

Then, with the help of Factory Design Pattern, create a class CakeFactory, in there will be a single method - createCake, according to the 4 parameters of the cake and the type (Chocolate, White, Spinach, Biscuit). The last thing is to make a Pastryshop class that contains an instance of CakeFactory. The idea of this class is to place an order - create the cake, use the three methods and return it.

## 3. Phonebook

Given the Contact and Phonebook classes, your task is to familiarize yourself with their structure, then you need to refactor the Contact class relying on the Builder Design Pattern.

Next, write a program to execute the following commands until "END" is received:

- "INFO" - Reads a name from the console and prints the complete contact information.

- "DELETE" - Reads a name from the console and deletes the contact from the phone book.

- "PHONEBOOK" - Prints the complete information of all contacts.

- "END" - The program ends its operation.