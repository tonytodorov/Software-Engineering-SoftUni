package stuntClimb;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbingTests {

    private static final String PEAK_NAME = "Musala";
    private static final String CLIMBER_NAME = "Ivan";
    private static final int CLIMBER_STRENGTH = 78;

    private static final int INITIAL_CAPACITY = 12;
    private static final int BELOW_ZERO_CAPACITY = -73;
    Climbing climbing;
    @Before
    public void setUp() {
        climbing = new Climbing(PEAK_NAME, INITIAL_CAPACITY);
        climbing.addRockClimber(new RockClimber(CLIMBER_NAME, CLIMBER_STRENGTH));
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameIsNull() {
        climbing = new Climbing(null, INITIAL_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameIsEmpty() {
        climbing = new Climbing("", INITIAL_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_WhenCapacityIsBelowZero() {
        climbing = new Climbing(CLIMBER_NAME, BELOW_ZERO_CAPACITY);
    }

    @Test
    public void test_GetCountMethod_ShouldReturnCorrectCountOfClimbers() {
        int actualCount = climbing.getCount();
        assertEquals(1, actualCount);
    }

    @Test
    public void test_GetNameMethod_ShouldReturnCorrectClimberName() {
        String actualName = climbing.getName();
        assertEquals(PEAK_NAME, actualName);
    }

    @Test
    public void test_GetCapacityMethod_ShouldReturnCorrectCapacity() {
        int actualCapacity = climbing.getCapacity();
        assertEquals(INITIAL_CAPACITY, actualCapacity);
    }

    @Test
    public void test_AddRockClimberMethod_ShouldAddClimberCorrect() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddRockClimberMethod_ShouldThrowException_WhenClimbersSizeEqualsCapacity() {
        climbing = new Climbing(PEAK_NAME, 0);
        climbing.addRockClimber(new RockClimber(CLIMBER_NAME, CLIMBER_STRENGTH));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddRockClimberMethod_ShouldThrowException_IfClimberExist() {
        climbing.addRockClimber(new RockClimber(CLIMBER_NAME, CLIMBER_STRENGTH));
    }

    @Test
    public void test_RemoveRockClimberMethod_ShouldReturnTrue_WhenRemoveClimberCorrect() {
        boolean removedClimber = climbing.removeRockClimber(CLIMBER_NAME);
        assertTrue(removedClimber);
    }

    @Test
    public void test_RemoveRockClimberMethod_ShouldReturnFalse_WhenTryRemoveClimberThatDoNotExist() {
        boolean removedClimber = climbing.removeRockClimber("George");
        assertFalse(removedClimber);
    }

}
