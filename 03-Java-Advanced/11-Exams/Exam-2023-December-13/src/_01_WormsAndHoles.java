import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;


public class _01_WormsAndHoles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> worms = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(ArrayDeque::new, ArrayDeque::push, ArrayDeque::addAll);

        ArrayDeque<Integer> holes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(ArrayDeque::new, ArrayDeque::offer, ArrayDeque::addAll);

        int matches = 0;

        while (!worms.isEmpty() && !holes.isEmpty()) {
            int worm = worms.peek();
            int hole = holes.peek();

            if (worm == hole) {
                worms.pop();
                holes.poll();
                matches += 1;
            } else {
                worms.push(worms.pop() - 3);
                if (worms.peek() <= 0) {
                    worms.pop();
                }
                holes.poll();
            }

        }

        if (matches > 0) {
            System.out.printf("Matches: %d%n", matches);
        } else {
            System.out.println("There are no matches.");
        }

        if (worms.isEmpty() && holes.isEmpty()) {
            System.out.println("Every worm found a suitable hole!");
        } else if (worms.isEmpty()) {
            System.out.println("Worms left: none");
        } else {
            System.out.printf("Worms left: %s%n" , printReverse(worms));
        }


        if (holes.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            System.out.println("Holes left: ");
            System.out.printf("Worms left: %s%n" , print(holes));
        }

    }

    public static String printReverse(ArrayDeque<Integer> arrayDeque) {

        Integer[] array = arrayDeque.toArray(new Integer[0]);
        Collections.reverse(Arrays.asList(array));

        return Arrays.stream(array)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static String print(ArrayDeque<Integer> arrayDeque) {

        return arrayDeque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}
