package generic.swap.string;

import java.util.*;

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
