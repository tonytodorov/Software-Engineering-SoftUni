package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {

    Garage garage;
    Car car;

    @Before
    public void setUp() {
        garage = new Garage();
        car = new Car("test", 200, 20_000);
        garage.addCar(car);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test
    public void test_GetCarsMethod_ShouldReturnCollectionOfCars() {
        List<Car> cars = garage.getCars();
        assertEquals(car, cars.get(0));
    }

    @Test
    public void test_GetCountMethod_ShouldReturnTheNumberOfCars() {
        int cars = garage.getCount();
        assertEquals(1, cars);
    }

    @Test
    public void test_FindAllCarsWithMaxSpeedAboveMethod_ShouldReturnCorrectCars() {
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(100);
        assertEquals(car, allCarsWithMaxSpeedAbove.get(0));
    }

    @Test
    public void test_AddCarMethod_ShouldAddCarCorrect() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddCarMethod_ShouldThrowException_WhenCarNull() {
        garage.addCar(null);
    }

    @Test
    public void test_GetTheMostExpensiveCarMethod_ShouldReturnCorrectCar() {
        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();
        assertEquals(car, theMostExpensiveCar);
    }

    @Test
    public void test_GetTheMostExpensiveCarMethod_ShouldReturnNull_WhenNotFoundCar() {
        garage = new Garage();
        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();
        assertNull(theMostExpensiveCar);
    }

    @Test
    public void test_FindAllCarsByBrandMethod_ShouldReturnCorrectCars() {
        List<Car> actualCars = garage.findAllCarsByBrand("test");
        assertEquals(car, actualCars.get(0));
    }

}