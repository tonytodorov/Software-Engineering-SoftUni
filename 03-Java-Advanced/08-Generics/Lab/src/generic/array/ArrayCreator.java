package generic.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {

    private T[] array;

    public static <T> T[] create(int length, T item) {
        Object[] arr = new Object[length];
        Arrays.fill(arr, item);
        return (T[]) arr;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] arr = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(arr, item);
        return arr;
    }
}
