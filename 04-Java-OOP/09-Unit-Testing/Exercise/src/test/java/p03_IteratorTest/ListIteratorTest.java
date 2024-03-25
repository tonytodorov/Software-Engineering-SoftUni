package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {


    ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator("first", "second");
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_ShouldNotCreate_CorrectObject() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void test_MoveMethod_ShouldReturnNextElement() {
        boolean move = listIterator.move();
        assertTrue(move);
    }

    @Test
    public void test_MoveMethod_ShouldNotReturnNextElement() throws OperationNotSupportedException {
        listIterator = new ListIterator();

        boolean move = listIterator.move();
        assertFalse(move);
    }

    @Test
    public void test_HasNextMethod_ShouldReturnTrue_IfNextElementPresent() {
        boolean hasNext = listIterator.hasNext();
        assertTrue(hasNext);
    }

    @Test
    public void test_HasNextMethod_ShouldReturnFalse_IfNextElementNotPresent() throws OperationNotSupportedException {
        listIterator = new ListIterator();

        boolean hasNext = listIterator.hasNext();
        assertFalse(hasNext);
    }

    @Test
    public void test_PrintMethod_ShouldPrint_CurrentElement() {
        listIterator.print();
    }

    @Test(expected = IllegalStateException.class)
    public void test_PrintMethod_ShouldThrowException_WhenIteratorIsEmpty() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }



}
