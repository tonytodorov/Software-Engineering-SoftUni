package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DatabaseTest {

    Database database;

    private static final Person[] INITIAL_ARRAY = {
            new Person(1, "Ivan"),
            new Person(2, "George")};
    private static final Person[] PEOPLE = {
            new Person(1, "Ivan"),
            new Person(2, "Ivan"),
            new Person(3, "Ivan"),
            new Person(4, "Ivan"),
            new Person(5, "Ivan"),
            new Person(6, "Ivan"),
            new Person(7, "Ivan"),
            new Person(8, "Ivan"),
            new Person(9, "Ivan"),
            new Person(10, "Ivan"),
            new Person(11, "Ivan"),
            new Person(12, "Ivan"),
            new Person(13, "Ivan"),
            new Person(14, "Ivan"),
            new Person(15, "Ivan"),
            new Person(16, "Ivan"),
            new Person(17, "Ivan"),
            new Person(18, "Ivan"),
            new Person(19, "Ivan"),
    };

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(INITIAL_ARRAY);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {
        Person[] actualArray = database.getElements();
        assertEquals(INITIAL_ARRAY.length, actualArray.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_ShouldThrowException_WhenElementSmallerThan_1() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_ShouldThrowException_WhenElementGreaterThan_16() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void test_AddOperation_ShouldThrowException_WhenMultipleUsersHaveSame_ID() throws OperationNotSupportedException {
        database.add(new Person(1, "George"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_AddOperation_ShouldThrowException_WhenNegative_ID_Present() throws OperationNotSupportedException {
        database = new Database(
                new Person(1, "Ivan"),
                new Person(-32, "George"));

        Person[] elements = database.getElements();

        Person currentPerson = Arrays.stream(elements)
                .filter(person -> person.getId() < 0)
                .findFirst()
                .orElse(null);

        if (null != currentPerson) {
            throw new OperationNotSupportedException();
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_AddOperation_ShouldThrowException_WhenNull_ID_Present() throws OperationNotSupportedException {
        database = new Database(
                new Person(0, "Ivan"),
                new Person(-32, "George"));

        Person[] elements = database.getElements();

        Person currentPerson = Arrays.stream(elements)
                .filter(person -> person.getId() == 0)
                .findFirst()
                .orElse(null);

        if (null != currentPerson) {
            throw new OperationNotSupportedException();
        }
    }

    @Test
    public void test_RemoveOperation_ShouldRemoveElement_AtTheLastIndex() throws OperationNotSupportedException {

        Person[] actualArray = database.getElements();
        Person person = actualArray[actualArray.length - 1];

        database.remove();

        Person[] expectedArray = database.getElements();

        assertEquals(expectedArray.length, actualArray.length - 1);
        assertEquals(INITIAL_ARRAY[1], person);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_RemoveOperation_ShouldNotRemoveElement_FromEmptyDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }
    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsernameMethod_ShouldThrowException_WhenUsernameIsNotPresent() throws OperationNotSupportedException {
        database.findByUsername("Hristo");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsernameMethod_ShouldThrowException_WhenUsernameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsernameMethod_ShouldNotReturnUsername_WhenTheLettersDoNotMatch() throws OperationNotSupportedException {
        database.findByUsername("ivan");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByIdMethod_ShouldThrowException_When_Id_NotPresent() throws OperationNotSupportedException {
        database.findById(141251);
    }


}
