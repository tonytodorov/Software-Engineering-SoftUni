package generic.count.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<String>> boxList = new ArrayList<>();
        Box<String> box = null;

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();

            box = new Box<>(name);
            boxList.add(box);
        }

        Box<String> word = new Box<>(scanner.nextLine());
        int compare = box.count(boxList, word);

        System.out.println(compare);
    }
}
