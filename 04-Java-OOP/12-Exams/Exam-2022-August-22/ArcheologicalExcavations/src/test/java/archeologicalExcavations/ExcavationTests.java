package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {

    private static final String EXCAVATION_NAME = "test_excavation";
    private static final int EXCAVATION_CAPACITY = 16;
    private static final int BELOW_ZERO_EXCAVATION_CAPACITY = -82;
    private static final String ARCHAEOLOGIST_NAME = "Ivan";
    private static final int ARCHAEOLOGIST_ENERGY = 120;

    Excavation excavation;
    Archaeologist archaeologist;

    @Before
    public void setUp() {
        excavation = new Excavation(EXCAVATION_NAME, EXCAVATION_CAPACITY);
        archaeologist = new Archaeologist(ARCHAEOLOGIST_NAME, ARCHAEOLOGIST_ENERGY);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_WhenCapacityBelowZero() {
        excavation = new Excavation(EXCAVATION_NAME, BELOW_ZERO_EXCAVATION_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameNull() {
        excavation = new Excavation(null, BELOW_ZERO_EXCAVATION_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameEmpty() {
        excavation = new Excavation("", BELOW_ZERO_EXCAVATION_CAPACITY);
    }

    @Test
    public void test_GetCountMethod_ShouldReturnNumberOfArchaeologist() {
        int actualCount = excavation.getCount();
        assertEquals(1, actualCount);
    }

    @Test
    public void test_GetNameMethod_ShouldReturnExcavationName() {
        String actualName = excavation.getName();
        assertEquals(EXCAVATION_NAME, actualName);
    }

    @Test
    public void test_GetCapacityMethod_ShouldReturnExcavationCapacity() {
        int actualCapacity = excavation.getCapacity();
        assertEquals(EXCAVATION_CAPACITY, actualCapacity);
    }

    @Test
    public void test_AddArchaeologistMethod_ShouldAddArchaeologistCorrect() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddArchaeologistMethod_ShouldThrowException_WhenCapacityEqualArcheologistSize() {
        excavation = new Excavation(EXCAVATION_NAME, 0);
        excavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddArchaeologistMethod_ShouldThrowException_WhenArchaeologistExist() {
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void test_RemoveArchaeologistMethod_ShouldRemoveArchaeologistCorrect() {
        boolean removeArchaeologist = excavation.removeArchaeologist(archaeologist.getName());
        assertTrue(removeArchaeologist);
    }

}
