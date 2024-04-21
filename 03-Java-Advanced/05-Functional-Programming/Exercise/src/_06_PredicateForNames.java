import java.util.Arrays;
import java.util.Scanner;

public class _06_PredicateForNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .filter(name -> name.length() <= length)
                .forEach(System.out::println);
    }
}
