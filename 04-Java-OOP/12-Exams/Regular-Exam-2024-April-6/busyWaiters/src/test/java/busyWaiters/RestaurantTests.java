package busyWaiters;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class RestaurantTests {

    private static final String RESTAURANT_NAME = "Restaurant";
    private static final int RESTAURANT_CAPACITY = 150;
    private static final String WAITER_NAME = "Waiter";
    private static final int WAITER_EFFICIENCY = 18;

    Restaurant restaurant;
    FullTimeWaiter fullTimeWaiter;

    @Before
    public void setUp() {
        restaurant = new Restaurant(RESTAURANT_NAME, RESTAURANT_CAPACITY);
        fullTimeWaiter = new FullTimeWaiter(WAITER_NAME, WAITER_EFFICIENCY);
        restaurant.addFullTimeWaiter(fullTimeWaiter);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenRestaurantNameEmpty() {
        restaurant = new Restaurant("", RESTAURANT_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenRestaurantNameNull() {
        restaurant = new Restaurant(null, RESTAURANT_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_WhenRestaurantCapacityBelowZero() {
        restaurant = new Restaurant(RESTAURANT_NAME, -23);
    }

    @Test
    public void test_GetCapacityMethod_ShouldReturnCorrectRestaurantCapacity() {
        int actualCapacity = restaurant.getCapacity();
        assertEquals(RESTAURANT_CAPACITY, actualCapacity);
    }

    @Test
    public void test_GetNameMethod_ShouldReturnCorrectRestaurantName() {
        String actualName = restaurant.getName();
        assertEquals(RESTAURANT_NAME, actualName);
    }

    @Test
    public void test_GetCountMethod_ShouldReturnCorrectNumberOfWaiters() {
        int actualCount = restaurant.getCount();
        assertEquals(1, actualCount);
    }

    @Test
    public void test_GetWaitersMethod_ShouldReturnWaiters() {
        Collection<FullTimeWaiter> waiters = restaurant.getWaiters();
        boolean containsWaiter = waiters.contains(fullTimeWaiter);
        assertTrue(containsWaiter);
    }

    @Test
    public void test_AddFullTimeWaiterMethod_ShouldAddWaiterCorrect() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddFullTimeWaiterMethod_ShouldThrowException_WhenRestaurantDoesNotHaveCapacity() {
        restaurant = new Restaurant(RESTAURANT_NAME, 0);
        restaurant.addFullTimeWaiter(fullTimeWaiter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddFullTimeWaiterMethod_ShouldThrowException_WhenWaiterExist() {
        restaurant.addFullTimeWaiter(fullTimeWaiter);
    }

    @Test
    public void test_RemoveFullTimeWaiterMethod_ShouldRemoveWaiterCorrect() {
        boolean removeFullTimeWaiter = restaurant.removeFullTimeWaiter(fullTimeWaiter.getName());
        assertTrue(removeFullTimeWaiter);
    }

    @Test
    public void test_RemoveFullTimeWaiterMethod_ShouldReturnFalse_WhenWaiterDoesNotExist() {
        boolean removeFullTimeWaiter = restaurant.removeFullTimeWaiter("");
        assertFalse(removeFullTimeWaiter);
    }
}
