import java.util.Arrays;
import java.util.Scanner;

public class _07_BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int searchedNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(binarySearch(numbers, searchedNumber));
    }

    private static int binarySearch(int[] arr, int number) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == number) {
                return mid;
            } else if (arr[mid] < number) {
                left = mid + 1;
            } else if (arr[mid] > number){
                right = mid - 1;
            }
        }

        return -1;
    }
}
