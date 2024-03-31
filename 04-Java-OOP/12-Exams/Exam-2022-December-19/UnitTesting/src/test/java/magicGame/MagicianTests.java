package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MagicianTests {

    private static final String MAGICIAN_USERNAME = "Wizard";
    private static final int MAGICIAN_HEALTH = 114;
    private static final String MAGIC_NAME = "RedMagic";
    private static final int MAGIC_BULLETS = 31;
    private static final int BELOW_ZERO_MAGICIAN_HEALTH = -84;

    Magician magician;
    Magic magic;

    @Before
    public void setUp() {
        magician = new Magician(MAGICIAN_USERNAME, MAGICIAN_HEALTH);
        magic = new Magic(MAGIC_NAME, MAGIC_BULLETS);
        magician.addMagic(magic);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenUsernameIsNull() {
        magician = new Magician(null, MAGICIAN_HEALTH);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenUsernameLengthIsBelowZero() {
        magician = new Magician("", MAGICIAN_HEALTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_WhenHealthIsBelowZero() {
        magician = new Magician(MAGICIAN_USERNAME, BELOW_ZERO_MAGICIAN_HEALTH);
    }

    @Test
    public void test_GetUsernameMethod_ShouldReturnCorrectUsername() {
        String actualUsername = magician.getUsername();
        assertEquals(MAGICIAN_USERNAME, actualUsername);
    }

    @Test
    public void test_GetHealthMethod_ShouldReturnCorrectHealth() {
        int actualHealth = magician.getHealth();
        assertEquals(MAGICIAN_HEALTH, actualHealth);
    }

    @Test
    public void test_GetMagicsMethod_ShouldReturnCollectionOfMagics() {
        List<Magic> actualMagics = magician.getMagics();
        assertEquals(1, actualMagics.size());
    }

    @Test
    public void test_TakeDamageMethod_ShouldTakeDamageCorrect() {
        magician.takeDamage(20);
        int expectedResult = MAGICIAN_HEALTH - 20;

        assertEquals(expectedResult, magician.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void test_TakeDamageMethod_ShouldThrowException_WhenHealthIsBelowZero() {
        magician = new Magician(MAGICIAN_USERNAME, 0);
        magician.takeDamage(160);

    }

    @Test
    public void test_AddMagicMethod_ShouldAddMagicCorrect() {

    }

    @Test(expected = NullPointerException.class)
    public void test_AddMagicMethod_ShouldThrowExceptionWhenMagicIsNull() {
        magician.addMagic(null);
    }

    @Test
    public void test_RemoveMagicMethod_ShouldRemoveMagicCorrect() {
        boolean removeMagic = magician.removeMagic(magic);
        assertTrue(removeMagic);
    }

    @Test
    public void test_GetMagicMethod_ShouldReturnCorrectMagic() {
        Magic actualMagic = magician.getMagic(MAGIC_NAME);
        assertEquals(MAGIC_NAME, actualMagic.getName());
    }





}
