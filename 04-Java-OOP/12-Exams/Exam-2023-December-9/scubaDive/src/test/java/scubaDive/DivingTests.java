package scubaDive;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivingTests {

    private static final String INITIAL_DIVING_NAME = "Sozopol";
    private static final String INITIAL_DIVER_NAME = "George";
    private static final int INITIAL_OXYGEN = 64;
    private static final int INITIAL_CAPACITY = 12;
    private static final int BELOW_ZERO_CAPACITY = -52;
    private static final int ONE = 1;
    Diving diving;

    @Before
    public void setUp() {
        diving = new Diving(INITIAL_DIVING_NAME, INITIAL_CAPACITY);
        diving.addDeepWaterDiver(new DeepWaterDiver(INITIAL_DIVER_NAME, INITIAL_OXYGEN));
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameIsNull() {
        diving = new Diving(null, INITIAL_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameIsEmpty() {
        diving = new Diving("", INITIAL_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_WhenCapacityBelowZero() {
        diving = new Diving(INITIAL_DIVING_NAME, BELOW_ZERO_CAPACITY);
    }

    @Test
    public void test_GetCountMethod_ShouldReturnCorrectCollectionSize() {
        int actualCount = diving.getCount();
        assertEquals(ONE, actualCount);
    }

    @Test
    public void test_GetNameMethod_ShouldReturnCorrectDivingName() {
        String actualDivingName = diving.getName();
        assertEquals(INITIAL_DIVING_NAME, actualDivingName);
    }

    @Test
    public void test_GetCapacityMethod_ShouldReturnCorrectInitialCapacity() {
        diving = new Diving(INITIAL_DIVING_NAME, ONE);

        int actualCapacity = diving.getCapacity();
        assertEquals(ONE, actualCapacity);
    }

    @Test
    public void test_AddDeepWaterDiverMethod_ShouldAddDiver() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddDeepWaterDiverMethod_ShouldThrowException_WhenCollectionSizeIsEqualCapacity() {
        diving = new Diving(INITIAL_DIVING_NAME, 0);
        diving.addDeepWaterDiver(new DeepWaterDiver(INITIAL_DIVER_NAME, INITIAL_OXYGEN));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddDeepWaterDiverMethod_ShouldThrowException_WhenDiverExistInCollection() {
        diving.addDeepWaterDiver(new DeepWaterDiver(INITIAL_DIVER_NAME, INITIAL_OXYGEN));
    }

    @Test
    public void test_RemoveDeepWaterDiverMethod_ShouldRemoveDiverCorrect() {
        assertTrue(diving.removeDeepWaterDiver(INITIAL_DIVER_NAME));
    }

    @Test
    public void test_RemoveDeepWaterDiverMethod_ShouldReturnFalse_WhenDiverDoesNotExist() {
         assertFalse(diving.removeDeepWaterDiver("Test"));
    }

}
