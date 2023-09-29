import java.util.Arrays;
import java.util.Scanner;

public class _05_LuckyNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] thirdArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] fourthArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i : firstArr) {
            for (int j : secondArr) {
                for (int k : thirdArr) {
                    for (int l : fourthArr) {
                        if (i == j && k == l) {
                            System.out.printf("%d%d%d%d%n", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}
