package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmvilleTests {

    private static final String FARM_NAME = "Farm";
    private static final int FARM_CAPACITY = 142;
    private static final int BELOW_ZERO_FARM_CAPACITY = -38;
    private static final String ANIMAL_TYPE = "Animal";
    private static final double ANIMAL_ENERGY = 20;
    private static final int EXPECTED_RESULT = 1;

    Farm farm;
    Animal animal;

    @Before
    public void setUp() {
        farm = new Farm(FARM_NAME, FARM_CAPACITY);
        animal = new Animal(ANIMAL_TYPE, ANIMAL_ENERGY);
        farm.add(animal);
    }

    @Test
    public void test_Constructor_ShouldCreateCorrectObject() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_WhenCapacityIsBelowZero() {
        farm = new Farm(FARM_NAME, BELOW_ZERO_FARM_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameNull() {
        farm = new Farm(null, FARM_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameEmpty() {
        farm = new Farm("", FARM_CAPACITY);
    }

    @Test
    public void test_GetCountMethod_ShouldReturnCorrectAnimalCollectionSize() {
        int actualFarmCount = farm.getCount();
        assertEquals(EXPECTED_RESULT, actualFarmCount);
    }

    @Test
    public void test_GetNameMethod_ShouldReturnCorrectFarmName() {
        String actualFarmName = farm.getName();
        assertEquals(FARM_NAME, actualFarmName);
    }

    @Test
    public void test_GetCapacityMethod_ShouldReturnCorrectFarmCapacity() {
        int actualFarmCapacity = farm.getCapacity();
        assertEquals(142, actualFarmCapacity);
    }

    @Test
    public void test_AddMethod_ShouldAddAnimalCorrect() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddMethod_ShouldThrowException_WhenFarmCapacityFull() {
        farm = new Farm(FARM_NAME, 0);
        farm.add(animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddMethod_ShouldThrowException_WhenAnimalExist() {
        farm.add(animal);
    }

    @Test
    public void test_RemoveMethod_ShouldRemoveAnimalCorrect() {
        boolean removeAnimal = farm.remove(animal.getType());
        assertTrue(removeAnimal);
    }

    @Test
    public void test_RemoveMethod_ShouldReturnNull_WhenAnimalNotFound() {
        boolean removeAnimal = farm.remove("Test");
        assertFalse(removeAnimal);
    }
}
