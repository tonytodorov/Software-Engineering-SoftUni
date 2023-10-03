import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_AppendArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(list);
        String result = list.toString().replaceAll("[\\]\\[,]", "").trim();
        result = result.replaceAll("\\s+", " ");

        System.out.println(result);
    }
}
