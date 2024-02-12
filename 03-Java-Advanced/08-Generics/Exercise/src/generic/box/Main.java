package generic.box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<String>> boxList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            Box<String> box = new Box<>(text);
            boxList.add(box);
        }

        boxList.forEach(System.out::println);
    }
}
