package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceTests {

    private static final String SERVICE_NAME = "test_service";
    private static final int SERVICE_CAPACITY = 16;
    private static final String ROBOT_NAME = "test_robot";

    Service service;
    Robot robot;

    @Before
    public void setUp() {
        service = new Service(SERVICE_NAME, SERVICE_CAPACITY);
        robot = new Robot(ROBOT_NAME);
    }

    @Test
    public void test_Constructor_ShouldCreateCorrectObject() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_WhenCapacityIsBelowZero() {
        service = new Service(SERVICE_NAME, -63);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameIsNull() {
        service = new Service(null, SERVICE_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameIsEmpty() {
        service = new Service(" ", SERVICE_CAPACITY);
    }

    @Test
    public void test_GetNameMethod_ShouldReturnCorrectServiceName() {
        String actualName = service.getName();
        assertEquals(SERVICE_NAME, actualName);
    }

    @Test
    public void test_GetCapacityMethod_ShouldReturnCorrectServiceCapacity() {
        int actualCapacity = service.getCapacity();
        assertEquals(SERVICE_CAPACITY, actualCapacity);
    }

    @Test
    public void test_AddMethod_ShouldAddRobotCorrect() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddMethod_ShouldThrowException_WhenServiceCapacityIsEqualToRobotsCollectionSize() {
        service = new Service(SERVICE_NAME, 0);
        service.add(robot);

    }

    @Test
    public void test_RemoveMethod_ShouldRemoveRobotCorrect() {
        service.add(robot);
        service.remove(robot.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveMethod_ShouldThrowException_WhenRobotDoesNotExist() {
        service.remove(robot.getName());
    }

    @Test
    public void test_ForSaleMethod_ShouldSetCorrectReadyForSale() {
        service.add(robot);
        Robot currentRobot = service.forSale(robot.getName());
        assertFalse(currentRobot.isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ForSaleMethod_ShouldThrowException_WhenRobotDoesNotExist() {
        service.remove(robot.getName());
    }


}
