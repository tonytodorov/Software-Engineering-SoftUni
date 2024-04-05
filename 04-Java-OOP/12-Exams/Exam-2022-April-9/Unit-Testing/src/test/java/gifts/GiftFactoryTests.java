package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class GiftFactoryTests {

    private static final String GIFT_TYPE = "Box";
    private static final double GIFT_MAGIC = 23;
    private static final String EXPECTED_CREATE_GIFT_RESULT = "Successfully added gift Test with magic 98,00.";

    private static final int EXPECTED = 1;

    GiftFactory giftFactory;
    Gift gift;

    @Before
    public void setUp() {
        giftFactory = new GiftFactory();
        gift = new Gift(GIFT_TYPE, GIFT_MAGIC);
        giftFactory.createGift(gift);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test
    public void test_GetCountMethod_ShouldReturn_CorrectGiftCollectionSize() {
        int actualCount = giftFactory.getCount();
        assertEquals(EXPECTED, actualCount);
    }

    @Test
    public void test_CreateGiftMethod_ShouldAddGiftCorrect() {
        String actualGift = giftFactory.createGift(new Gift("Test", 98));
        assertEquals(EXPECTED_CREATE_GIFT_RESULT, actualGift);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateGiftMethod_ShouldThrowException_WhenGiftExist() {
        giftFactory.createGift(gift);
    }

    @Test
    public void test_RemoveGiftMethod_ShouldRemoveGiftCorrect() {
        boolean removeGift = giftFactory.removeGift(GIFT_TYPE);
        assertTrue(removeGift);
    }

    @Test(expected = NullPointerException.class)
    public void test_RemoveGiftMethod_ShouldThrowException_WhenGiftTypeNull() {
        giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void test_RemoveGiftMethod_ShouldThrowException_WhenGiftTypeEmpty() {
        giftFactory.removeGift("");
    }

    @Test
    public void test_GetPresentWithLeastMagicMethod_ShouldReturnGiftWithLeastMagic() {
        Gift actualPresentWithLeastMagic = giftFactory.getPresentWithLeastMagic();
        assertEquals(gift, actualPresentWithLeastMagic);
    }

    @Test
    public void test_GetPresentWithLeastMagicMethod_ShouldReturnNull() {
        giftFactory = new GiftFactory();
        Gift actualPresentWithLeastMagic = giftFactory.getPresentWithLeastMagic();
        assertNull(actualPresentWithLeastMagic);
    }

    @Test
    public void test_GetPresentMethod_ShouldReturnCorrectGift() {
        Gift actualPresentWithLeastMagic = giftFactory.getPresent(GIFT_TYPE);
        assertEquals(gift, actualPresentWithLeastMagic);
    }

    @Test
    public void test_GetPresentMethod_ShouldReturnNull() {
        giftFactory = new GiftFactory();
        Gift actualPresentWithLeastMagic = giftFactory.getPresent(GIFT_TYPE);
        assertNull(actualPresentWithLeastMagic);
    }

    @Test
    public void test_GetPresentMethod_ShouldReturnUnmodifiableCollectionOfGifts() {
        Collection<Gift> presents = giftFactory.getPresents();
        assertEquals(EXPECTED, presents.size());
    }

}
