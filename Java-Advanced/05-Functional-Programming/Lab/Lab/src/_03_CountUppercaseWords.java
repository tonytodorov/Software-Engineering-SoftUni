import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _03_CountUppercaseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        Predicate<String> isUppercase = word -> Character.isUpperCase(word.charAt(0));

        Function<String[], List<String>> getUppercaseWords = arr -> Arrays.stream(text)
                .filter(isUppercase)
                .collect(Collectors.toList());

        List<String> apply = getUppercaseWords.apply(text);

        System.out.println(apply.size());
        apply.forEach(System.out::println);
    }
}
