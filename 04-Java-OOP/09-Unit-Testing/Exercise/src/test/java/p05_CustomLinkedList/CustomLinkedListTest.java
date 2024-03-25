package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private static final int ZERO_INDEX = 0;
    private static final int BELOW_ZERO_INDEX = -93;
    private static final int GREATER_LIST_SIZE_INDEX = 48;
    private static final int EQUAL_LIST_SIZE_INDEX = 2;
    private static final int EXPECTED_REMOVE_INDEX = -1;
    private static final int EXPECTED_INDEX_OF_RESULT = 0;
    private static final int EXPECTED_INDEX_OF_RESULT_WHEN_ELEMENT_NOT_FOUND = -1;
    CustomLinkedList<String> customLinkedList;

    @Before
    public <T> void setUp() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("name");
        customLinkedList.add("age");
    }

    @Test
    public void test_Constructor_ShouldCreateCorrectObject() {

    }

    @Test
    public void test_AddMethod_ShouldAddItem_AndCreateNewHeadAndTail_WhenListIsEmpty() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("test");
    }

    @Test
    public void test_AddMethod_ShouldAddItem_AndAppendItemAfterTail_WhenListIsNotEmpty() {

    }

    @Test
    public void test_RemoveAtMethod_ShouldRemoveElementAtTheSpecifiedIndex() {
        customLinkedList.removeAt(ZERO_INDEX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveAtMethod_ShouldThrowException_WhenIndexIsBelowZero() {
        customLinkedList.removeAt(BELOW_ZERO_INDEX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveAtMethod_ShouldThrowException_WhenIndexIs_GreaterOnListSize() {
        customLinkedList.removeAt(GREATER_LIST_SIZE_INDEX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveAtMethod_ShouldThrowException_WhenIndexIs_EqualOnListSize() {
        customLinkedList.removeAt(EQUAL_LIST_SIZE_INDEX);
    }

    @Test
    public void test_RemoveMethod_ShouldRemoveElementIfPresent() {
        customLinkedList.remove("name");
    }

    @Test
    public void test_RemoveMethod_ShouldReturn_MinusOne_WhenElementIsNotPresentInList() {
        int actualElement = customLinkedList.remove("nobody");
        assertEquals(EXPECTED_REMOVE_INDEX, actualElement);
    }

    @Test
    public void test_IndexOfMethod_ShouldReturnFirstOccurrenceOfTheElement() {
        int actualIndex = customLinkedList.indexOf("name");
        assertEquals(EXPECTED_INDEX_OF_RESULT, actualIndex);
    }

    @Test
    public void test_IndexOfMethod_ShouldReturn_MinusOne_WhenElementWasNotFound() {
        int actualIndex = customLinkedList.indexOf("anyone");
        assertEquals(EXPECTED_INDEX_OF_RESULT_WHEN_ELEMENT_NOT_FOUND, actualIndex);
    }

    @Test
    public void test_ContainsMethod_ShouldReturnTrue_IfElementIsPresent() {
        boolean isExist = customLinkedList.contains("name");
        assertTrue(isExist);
    }

    @Test
    public void test_ContainsMethod_ShouldReturnFalse_WhenElementWasNotFound() {
        boolean isExist = customLinkedList.contains("non-exist");
        assertFalse(isExist);
    }

    @Test
    public void test_GetMethod_ShouldReturnElementByIndex() {
        String actualElement = customLinkedList.get(ZERO_INDEX);
        assertEquals(customLinkedList.get(ZERO_INDEX), actualElement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetMethod_ShouldThrowException_WhenIndexIsGreaterThanListSize() {
        String actualElement = customLinkedList.get(GREATER_LIST_SIZE_INDEX);
        assertEquals(customLinkedList.get(GREATER_LIST_SIZE_INDEX), actualElement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetMethod_ShouldThrowException_WhenIndexIsBelowZero() {
        String actualElement = customLinkedList.get(BELOW_ZERO_INDEX);
        assertEquals(customLinkedList.get(BELOW_ZERO_INDEX), actualElement);
    }

    @Test
    public void test_SetMethod_ShouldSetElementByIndex() {
        customLinkedList.set(ZERO_INDEX, "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetMethod_ShouldThrowException_WhenIndexIsBelowZero() {
        customLinkedList.set(BELOW_ZERO_INDEX, "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetMethod_ShouldThrowException_WhenIndexIsGreaterThanListSize() {
        customLinkedList.set(GREATER_LIST_SIZE_INDEX, "test");
    }



}
