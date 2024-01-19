import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_RandomizeWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        Random random = new Random();
        int listSize = list.size();

        while (!list.isEmpty()) {
            int randomWord = random.nextInt(listSize);
            System.out.println(list.get(randomWord));
            list.remove(randomWord);
            listSize--;
        }
    }
}
