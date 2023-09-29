import java.util.Arrays;
import java.util.Scanner;

public class CountNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberSought = Integer.parseInt(scanner.nextLine());
        int result = countNumberSought(array, numberSought);

        System.out.printf("Number %d occurs %d times.", numberSought, result);
    }


    public static int countNumberSought(int[] array, int target){

        int count = 0;
        for (int num : array) {
            if (num == target) {
                count++;
            }
        }

        return count;
    }



}
