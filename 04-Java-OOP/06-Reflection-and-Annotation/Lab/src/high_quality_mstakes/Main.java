package high_quality_mstakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Class<?> clazz = Reflection.class;

        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be public!%n", method.getName()));

        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be private!%n", method.getName()));

    }
}
