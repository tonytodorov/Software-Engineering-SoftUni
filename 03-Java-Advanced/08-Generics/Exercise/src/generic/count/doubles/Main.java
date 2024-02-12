package generic.count.doubles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Double>> boxList = new ArrayList<>();
        Box<Double> box = null;

        for (int i = 0; i < n; i++) {
            double number = Double.parseDouble(scanner.nextLine());

            box = new Box<>(number);
            boxList.add(box);
        }

        Box<Double> number = new Box<>(Double.parseDouble(scanner.nextLine()));
        int compare = box.count(boxList, number);

        System.out.println(compare);
    }
}
