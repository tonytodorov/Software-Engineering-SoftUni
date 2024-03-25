package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    Person person;

    @Before
    public void setUp() {
        person = new Person(1, "Ivan");
    }

    @Test
    public void test_Constructor_ShouldCreateCorrectObject() {

    }
    @Test
    public void test_Constructor_ShouldReturnCorrect_Id() {
        int id = person.getId();
        assertEquals(person.getId(), id);
    }

    @Test
    public void test_Constructor_ShouldReturnCorrect_Username() {
        String username = person.getUsername();
        assertEquals(person.getUsername(), username);
    }
}
