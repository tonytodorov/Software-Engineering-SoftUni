import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int number = Integer.parseInt(scanner.nextLine());
        
        int[] copyArr = new int[arr.length];

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != number) {
                copyArr[index] = arr[i];
                index++;
            } else {
                index--;
            }
        }

        arr = copyArr;

        Arrays.stream(arr).forEach(System.out::println);
    }
}
