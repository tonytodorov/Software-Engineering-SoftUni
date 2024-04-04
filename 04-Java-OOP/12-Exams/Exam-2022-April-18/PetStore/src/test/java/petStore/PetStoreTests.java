package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTests {

    private static final String PET_SPECIE = "Dog";
    private static final int PET_KILOGRAMS = 15;
    private static final double PET_PRICE = 342.87;

    PetStore petStore;
    Animal animal;

    @Before
    public void setUp() {
        petStore = new PetStore();
        animal = new Animal(PET_SPECIE, PET_KILOGRAMS, PET_PRICE);
        petStore.addAnimal(animal);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test
    public void test_GetAnimalsMethod_ShouldReturnUnmodifiableCollectionOfAnimals() {
        List<Animal> actualAnimals = petStore.getAnimals();
        assertEquals(animal, actualAnimals.get(0));

    }

    @Test
    public void test_GetCountMethod_ShouldReturnSizeOfPetCollection() {
        int actualCount = petStore.getCount();
        assertEquals(1, actualCount);
    }

    @Test
    public void test_FindAllAnimalsWithMaxKilogramsMethod_ShouldReturnCorrectAnimals() {
        List<Animal> actualAllAnimalsWithMaxKilograms = petStore.findAllAnimalsWithMaxKilograms(9);
        assertEquals(animal, actualAllAnimalsWithMaxKilograms.get(0));

    }

    @Test
    public void test_AddAnimalMethod_ShouldAddAnimalCorrect() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddAnimalMethod_ShouldThrowException_WhenAnimalNull() {
        petStore.addAnimal(null);
    }

    @Test
    public void test_GetTheMostExpensiveAnimalMethod_ShouldReturnCorrectAnimal() {
        Animal theMostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();
        assertEquals(animal, theMostExpensiveAnimal);
    }

    @Test
    public void test_GetTheMostExpensiveAnimalMethod_ShouldReturnNull() {
        petStore = new PetStore();
        Animal actualTheMostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();
        assertNull(actualTheMostExpensiveAnimal);
    }


    @Test
    public void test_findAllAnimalBySpecieMethod_ShouldReturnCorrectAnimals() {
        List<Animal> actualAllAnimalBySpecie = petStore.findAllAnimalBySpecie(PET_SPECIE);
        assertEquals(animal, actualAllAnimalBySpecie.get(0));
    }
}

