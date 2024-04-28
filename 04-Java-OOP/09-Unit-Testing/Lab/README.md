# Lab: Unit Testing

## 1. Test Axe

In the test/java folder, create a package called rpg_lab.

Create a class AxeTest.

Create the following tests:
- Test if the weapon loses durability after each attack;
- Test attacking with a broken weapon.

## 2.	Test Dummy

Create a class DummyTest.

Create the following tests:
- Dummy loses health if attacked.
- Dead Dummy throws an exception if attacked.
- Dead Dummy can give XP.
- Alive Dummy can't give XP.

## 3. Refactor Tests

Refactor the tests for Axe and Dummy classes.

Make sure that:
- Names of test methods are descriptive.
- You use appropriate assertions (assert equals vs assert true).
- You use assertion messages.
- There are no magic numbers.
- There is no code duplication (Don’t Repeat Yourself)


## 4. Fake Axe and Dummy

Test if the hero gains XP when a target dies.

To do this, you need to:
- Make Hero class testable (use Dependency Injection).
- Introduce Interfaces for Axe and Dummy:
    <ul>
        <li>Interface Weapon</li>
        <li>Interface Target</li>
    </ul>

Create a fake Weapon and fake Dummy for the test.

## 5. Mocking

Include Mockito in the project dependencies, then:

- Mock fakes from the previous problem.
- Implement Hero Inventory, holding unequipped weapons:
    <ul>
        <li>method - Iterable<Weapon> getInventory()</li>
    </ul>
- Implement Target giving random weapons upon death:
    <ul>
        <li>field - private List<Weapon> possibleLoot</li>
    </ul>
- Test Hero killing a target getting loot in his inventory.