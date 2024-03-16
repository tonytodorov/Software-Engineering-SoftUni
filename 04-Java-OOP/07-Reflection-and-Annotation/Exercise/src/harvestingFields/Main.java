package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<?> clazz = RichSoilLand.class;
        Field[] declaredFields = clazz.getDeclaredFields();

        String input = scanner.nextLine();

        while (!"HARVEST".equals(input)) {

            if ("private".equals(input)) {
                List<Field> privateFields = getPrivateFields(declaredFields);
                printFields(privateFields);
            } else if ("protected".equals(input)) {
                List<Field> protectedFields = getProtectedFields(declaredFields);
                printFields(protectedFields);
            } else if ("public".equals(input)) {
                List<Field> publicFields = getPublicFields(declaredFields);
                printFields(publicFields);
            } else {
                printAllFields(declaredFields);
            }

            input = scanner.nextLine();
        }
    }

    private static List<Field> getPrivateFields(Field[] declaredFields) {
        return Arrays.stream(declaredFields)
                .filter(field -> Modifier.isPrivate(field.getModifiers()))
                .collect(Collectors.toList());
    }

    private static List<Field> getProtectedFields(Field[] declaredFields) {
        return Arrays.stream(declaredFields)
                .filter(field -> Modifier.isProtected(field.getModifiers()))
                .collect(Collectors.toList());
    }

    private static List<Field> getPublicFields(Field[] declaredFields) {
        return Arrays.stream(declaredFields)
                .filter(field -> Modifier.isPublic(field.getModifiers()))
                .collect(Collectors.toList());
    }

    private static void printFields(List<Field> fields) {
        fields.forEach(field -> System.out.printf("%s %s %s%n",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName()));
    }

    private static void printAllFields(Field[] declaredFields) {
        Arrays.stream(declaredFields)
                .forEach(field -> System.out.printf("%s %s %s%n",
                        Modifier.toString(field.getModifiers()),
                        field.getType().getSimpleName(),
                        field.getName()));
    }
}
