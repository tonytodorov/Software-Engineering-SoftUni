import java.util.Arrays;
import java.util.Scanner;

public class _06_PredicateForNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .filter(v -> v.length() <= n)
                .forEach(System.out::println);
    }
}
