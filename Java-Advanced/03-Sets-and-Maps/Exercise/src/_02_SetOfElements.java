import java.util.*;

public class _02_SetOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setLength = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstSetLength = setLength[0];
        int secondSetLength = setLength[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 0; i < secondSetLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        String smallestSet = smallestSetSize(firstSet, secondSet);

        if (smallestSet.equals("first")) {
            getSameElements(firstSet, secondSet);
        } else if (smallestSet.equals("second")) {
            getSameElements(secondSet, firstSet);
        } else {
            getSameElements(firstSet, secondSet);
        }
    }

    public static String smallestSetSize(Set<Integer> firstSet, Set<Integer> secondSet) {

        String smallestSet = "";

        if (firstSet.size() > secondSet.size()) {
            smallestSet = "second";
        } else  {
            smallestSet = "first";
        }

        return smallestSet;
    }

    public static void getSameElements(Set<Integer> firstSet, Set<Integer> secondSet) {

        while (!firstSet.isEmpty()) {
            int number = firstSet.iterator().next();
            firstSet.remove(number);

            if (secondSet.contains(number)) {
                System.out.printf("%d ", number);
            }
        }
    }
}
