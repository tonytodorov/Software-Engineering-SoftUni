import java.util.Arrays;
import java.util.Scanner;

public class _05_MergeSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(numbers, 0, numbers.length - 1);
        printArr(numbers);
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int firstArrSize = mid - left + 1;
        int secondArrSize = right - mid;

        int[] tempLeftArr = new int[firstArrSize];
        int[] tempRightArr = new int[secondArrSize];

        for (int i = 0; i < tempLeftArr.length; i++) {
            tempLeftArr[i] = arr[left + i];
        }

        for (int i = 0; i < tempRightArr.length; i++) {
            tempRightArr[i] = arr[mid + i + 1];
        }

        int tempLeftIndex = 0;
        int tempRightIndex = 0;
        int k = left;

        while (tempLeftIndex < tempLeftArr.length && tempRightIndex < tempRightArr.length) {
            if (tempLeftArr[tempLeftIndex] <= tempRightArr[tempRightIndex]) {
                arr[k] = tempLeftArr[tempLeftIndex];
            } else {
                arr[k] = tempRightArr[tempRightIndex];
                tempRightIndex++;
            }

            k++;
        }

        while (tempLeftIndex < tempLeftArr.length) {
            arr[k] = tempLeftArr[tempLeftIndex];
            tempLeftIndex++;
            k++;
        }

        while (tempRightIndex < tempRightArr.length) {
            arr[k] = tempRightArr[tempRightIndex];
            tempRightIndex++;
            k++;
        }
    }

    private static void sort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void printArr(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
