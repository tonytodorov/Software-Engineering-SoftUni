package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class ToyStoryTest {

    private static final String TOY_MANUFACTURER = "test_manufacturer";
    private static final String TOY_ID = "test_id";
    private static final String START_SHELF = "A";
    private static final String PRIMARY_SHELF = "B";
    private static final String DUMMY_SHELF = "Test";

    ToyStore toyStore;
    Toy toy;

    @Before
    public void setUp() throws OperationNotSupportedException {
        toyStore = new ToyStore();
        toy = new Toy(TOY_MANUFACTURER, TOY_ID);
        toyStore.addToy(START_SHELF, toy);
    }

    @Test
    public void test_Constructor_ShouldCreateCorrectObject() {

    }

    @Test
    public void test_GetToyShelf_ShouldReturnCorrectToyShelf() {
        Map<String, Toy> toyShelf = toyStore.getToyShelf();
        Toy actualToy = toyShelf.get(START_SHELF);

        assertEquals(actualToy.getManufacturer(), TOY_MANUFACTURER);
    }

    @Test
    public void test_AddToyShelf_ShouldAddToyCorrect() throws OperationNotSupportedException {
        String result = toyStore.addToy(PRIMARY_SHELF, new Toy("test", "test"));
        assertEquals("Toy:test placed successfully!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddToyMethod_ShouldThrowException_WhenShelfDoesNotContainKey() throws OperationNotSupportedException {
        toyStore.addToy(DUMMY_SHELF, toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddToyMethod_ShouldThrowException_WhenShelfAlreadyTaken() throws OperationNotSupportedException {
        toyStore.addToy(START_SHELF, toy);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_AddToyMethod_ShouldThrowException_WhenToyExist() throws OperationNotSupportedException {
        toyStore.addToy("C", toy);
    }

    @Test
    public void test_RemoveToyMethod_ShouldRemoveToyCorrect() {
        String result = toyStore.removeToy(START_SHELF, toy);
        assertNull(toyStore.getToyShelf().get("A"));
        assertEquals("Remove toy:test_id successfully!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveToyMethod_ShouldRemoveThrowException_WhenShelfDoesNotExist() {
        toyStore.removeToy(DUMMY_SHELF, toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveToyMethod_ShouldRemoveThrowException_WhenShelfAlreadyTaken() {
        toyStore.removeToy(START_SHELF, new Toy("test", "id"));
    }



}