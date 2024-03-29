package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarShopTests {

    private static final String MODEL = "A6";
    private static final int HORSE_POWER = 340;
    private static final double PRICE = 35_000;
    private static final int EXPECTED_VALUE = 1;
    CarShop carShop;
    Car car;

    @Before
    public void setUp() {
        carShop = new CarShop();
        car = new Car(MODEL, HORSE_POWER, PRICE);
        carShop.add(car);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test
    public void test_GetCarsMethod_ShouldReturnAllCars() {
        List<Car> cars = carShop.getCars();
        assertEquals(EXPECTED_VALUE, cars.size());
    }

    @Test
    public void test_GetCountMethod_ShouldReturnCarsCollectionSize() {
        int actualCount = carShop.getCount();
        assertEquals(EXPECTED_VALUE, actualCount);
    }

    @Test
    public void test_FindAllCarsWithMaxHorsePowerMethod_ShouldReturnCorrectCars() {
        List<Car> allCarsWithMaxHorsePower = carShop.findAllCarsWithMaxHorsePower(30);
        assertEquals(EXPECTED_VALUE, allCarsWithMaxHorsePower.size());
    }

    @Test
    public void test_AddMethod_ShouldAddCarCorrect() {
        assertEquals(EXPECTED_VALUE, carShop.getCars().size());
    }

    @Test(expected = NullPointerException.class)
    public void test_AddMethod_ShouldThrowException_WhenCarIsNull() {
        carShop.add(null);
    }

    @Test
    public void test_RemoveMethod_ShouldRemoveCarCorrect() {
        boolean removeCar = carShop.remove(car);
        assertTrue(removeCar);
    }

    @Test
    public void test_GetTheMostLuxuryCar_ShouldFindCorrectCar() {
        Car mostLuxuryCar = carShop.getTheMostLuxuryCar();
        assertEquals(car.getPrice(), mostLuxuryCar.getPrice(), 0);
    }

    @Test
    public void test_FindAllCarByModel_ShouldReturnAllCarsByModel() {
        List<Car> allCarByModel = carShop.findAllCarByModel(MODEL);
        assertEquals(EXPECTED_VALUE, allCarByModel.size());
    }




}

