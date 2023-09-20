import java.util.Arrays;
import java.util.Scanner;

public class _01_SortNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[3];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        Arrays.sort(array);

        System.out.println(array[2]);
        System.out.println(array[1]);
        System.out.println(array[0]);


    }
}
