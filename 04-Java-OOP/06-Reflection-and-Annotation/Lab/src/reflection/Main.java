package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());

        Class<?>[] interfaces = clazz.getInterfaces();

        Arrays.stream(interfaces).forEach(System.out::println);

        Constructor<Reflection> constructor = clazz.getConstructor();
        Reflection reflection = constructor.newInstance();

        System.out.println(reflection);

    }
}
