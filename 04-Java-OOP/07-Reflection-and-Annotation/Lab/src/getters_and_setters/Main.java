package getters_and_setters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Class<?> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s will return class %s%n",
                        method.getName(),
                        method.getReturnType().getName()));

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Arrays.stream(parameterTypes)
                            .forEach(p -> System.out.printf("%s and will set field of class %s%n",
                                    method.getName(), p.getName()));
                });
    }
}
