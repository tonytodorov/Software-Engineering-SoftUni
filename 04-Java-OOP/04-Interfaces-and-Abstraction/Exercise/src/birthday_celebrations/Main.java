package birthday_celebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> birthableList = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] token = input.split("\\s+");

            String type = token[0];
            String name = token[1];

            if ("Citizen".equals(type)) {
                int age = Integer.parseInt(token[2]);
                String id = token[3];
                String birthdate = token[4];

                Citizen citizen = new Citizen(name, age, id, birthdate);
                birthableList.add(citizen);
            } else if ("Pet".equals(type)) {
                String birthdate = token[2];

                Pet pet = new Pet(name, birthdate);
                birthableList.add(pet);
            }

            input = scanner.nextLine();
        }

        String date = scanner.nextLine();

        birthableList.stream()
                .map(Birthable::getBirthDate)
                .filter(birthDate -> birthDate.endsWith(date))
                .forEach(System.out::println);
    }
}
