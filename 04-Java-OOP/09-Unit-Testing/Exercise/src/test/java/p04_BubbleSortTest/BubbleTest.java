package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {


    @Test
    public void test_Sort_ShouldSortArrayCorrect() {
        int[] actualArray = new int[]{10, 14, 1, 7, 53, 24, -2};
        int[] expectedArray = new int[]{-2, 1, 7, 10, 14, 24, 53};

        Bubble.sort(actualArray);

        for (int i = 0; i < actualArray.length; i++) {
            int actualElement = actualArray[i];
            int expectedElement = expectedArray[i];

            assertEquals(expectedElement, actualElement);
        }
    }

}
