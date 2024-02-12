package generic.swap.integers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Integer>> boxList = new ArrayList<>();
        Box<Integer> box = null;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            box = new Box<>(number);
            boxList.add(box);
        }

        int[] indexes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstIndex = indexes[0];
        int secondIndex = indexes[1];

        box.swap(boxList, firstIndex, secondIndex);
        boxList.forEach(System.out::println);
    }
}
