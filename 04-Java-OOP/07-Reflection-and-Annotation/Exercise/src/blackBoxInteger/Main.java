package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class<?> clazz = BlackBoxInt.class;

        Constructor<?> constructor = clazz.getDeclaredConstructor(Integer.TYPE);
        constructor.setAccessible(true);
        Object obj = constructor.newInstance(0);

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] token = input.split("_");

            String operation = token[0];

            if ("add".equals(operation)) {
                Method add = clazz.getDeclaredMethod("add", int.class);
                add.setAccessible(true);
                add.invoke(obj, Integer.parseInt(token[1]));
            } else if ("subtract".equals(operation)) {
                Method subtract = clazz.getDeclaredMethod("subtract", int.class);
                subtract.setAccessible(true);
                subtract.invoke(obj, Integer.parseInt(token[1]));
            } else if ("divide".equals(operation)) {
                Method divide = clazz.getDeclaredMethod("divide", int.class);
                divide.setAccessible(true);
                divide.invoke(obj, Integer.parseInt(token[1]));
            } else if ("multiply".equals(operation)) {
                Method multiply = clazz.getDeclaredMethod("multiply", int.class);
                multiply.setAccessible(true);
                multiply.invoke(obj, Integer.parseInt(token[1]));
            } else if ("rightShift".equals(operation)) {
                Method rightShift = clazz.getDeclaredMethod("rightShift", int.class);
                rightShift.setAccessible(true);
                rightShift.invoke(obj, Integer.parseInt(token[1]));
            } else if ("leftShift".equals(operation)) {
                Method leftShift = clazz.getDeclaredMethod("leftShift", int.class);
                leftShift.setAccessible(true);
                leftShift.invoke(obj, Integer.parseInt(token[1]));
            }

            Field innerValue = clazz.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            int value = (int) innerValue.get(obj);

            System.out.println(value);
            input = scanner.nextLine();
        }
    }
}
