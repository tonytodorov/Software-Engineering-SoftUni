package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static final Integer[] INITIALIZE_ARRAY = {1, 2, 3, 4, 5};
    private static final int EXACTLY_CAPACITY = 16;
    private static final int GREATER_CAPACITY = 21;
    private static final int NUMBER = 73;


    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(INITIALIZE_ARRAY);
    }

    @Test
    public void test_ArrayCapacityIsExactly_16_Integers() throws OperationNotSupportedException {
        Integer[] elements = new Integer[EXACTLY_CAPACITY];
        database = new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_ArrayCapacityIsSmallerThan_1_Integers() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_ArrayCapacityIsGreaterThan_16_Integers() throws OperationNotSupportedException {
        Integer[] elements = new Integer[GREATER_CAPACITY];
        database = new Database(elements);
    }

    @Test
    public void test_AddOperation_ShouldAddingElement_OnTheLastPosition() throws OperationNotSupportedException {
        database.add(NUMBER);
        Integer[] elements = database.getElements();
        int lastIndex = elements.length - 1;

        assertEquals(Integer.valueOf(NUMBER), elements[lastIndex]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_AddOperation_ShouldNotAddNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_AddOperation_ShouldIncreaseElementsCount_WhenAddElement() throws OperationNotSupportedException {
        Integer[] elements = database.getElements();

        database.add(NUMBER);
        Integer[] elementsAfterAddOperation = database.getElements();

        assertEquals(elements.length + 1, elementsAfterAddOperation.length);
    }

    @Test
    public void test_RemoveOperation_ShouldRemoveElement_AtTheLastIndex() throws OperationNotSupportedException {

        Integer[] elements = database.getElements();
        Integer element = elements[elements.length - 1];

        database.remove();

        int size = database.getElements().length;
        int expectedSize = INITIALIZE_ARRAY.length - 1;

        assertEquals(expectedSize, size);
        assertEquals(Integer.valueOf(INITIALIZE_ARRAY.length), element);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_RemoveOperation_ShouldNotRemoveElement_FromEmptyDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }

}
