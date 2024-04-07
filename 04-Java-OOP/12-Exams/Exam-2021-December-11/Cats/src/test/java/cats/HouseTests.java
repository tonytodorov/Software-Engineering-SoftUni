package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {

    private static final String HOUSE_NAME = "MyHouse";
    private static final int HOUSE_CAPACITY = 10;
    private static final String CAT_NAME = "MyCat";
    private static final String DUMMY_CAT_NAME = "Dummy";

    House house;
    Cat cat;

    @Before
    public void setUp() {
        house = new House(HOUSE_NAME, HOUSE_CAPACITY);
        cat = new Cat(CAT_NAME);
        house.addCat(cat);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test(expected =  IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_WhenCapacityIsBelowZero() {
        house = new House(HOUSE_NAME, -23);
    }

    @Test(expected =  NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameNull() {
        house = new House(null, HOUSE_CAPACITY);
    }

    @Test(expected =  NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameEmpty() {
        house = new House("", HOUSE_CAPACITY);
    }

    @Test
    public void test_GetNameMethod_ShouldReturnCorrectHouseName() {
        String actualHouseName = house.getName();
        assertEquals(HOUSE_NAME, actualHouseName);
    }

    @Test
    public void test_GetCapacityMethod_ShouldReturnCorrectHouseCapacity() {
        int actualHouseCapacity = house.getCapacity();
        assertEquals(HOUSE_CAPACITY, actualHouseCapacity);
    }

    @Test
    public void test_GetCountMethod_ShouldReturnCorrectCatCollectionSize() {
        int actualCatCount = house.getCount();
        assertEquals(1, actualCatCount);
    }

    @Test
    public void test_AddCatMethod_ShouldAddCatCorrect() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddCatMethod_ShouldThrowException_WhenCapacityNotEnough() {
        house = new House(HOUSE_NAME, 0);
        house.addCat(cat);
    }

    @Test
    public void test_RemoveCatMethod_ShouldRemoveCatCorrect() {
        house.removeCat(CAT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveCatMethod_ShouldThrowException_WhenCatNotFound() {
        house.removeCat(DUMMY_CAT_NAME);
    }

    @Test
    public void test_CatForSaleMethod_ShouldSellCatCorrect() {
        Cat actualCat = house.catForSale(CAT_NAME);
        assertFalse(actualCat.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CatForSaleMethod_ShouldThrowException_WhenCatNotFound() {
        house.catForSale(DUMMY_CAT_NAME);
    }

    @Test
    public void test_StatisticsMethod_ShouldReturnInformationAboutCat() {
        String actualCatStatistics = house.statistics();
        assertEquals("The cat MyCat is in the house MyHouse!", actualCatStatistics);
    }


}
