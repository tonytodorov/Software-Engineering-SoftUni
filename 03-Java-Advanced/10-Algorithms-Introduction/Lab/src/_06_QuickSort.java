import java.util.Arrays;
import java.util.Scanner;

public class _06_QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort(numbers, 0, numbers.length - 1);
        printArr(numbers);
    }

    private static void swap(int[] arr, int firstElement, int secondElement) {
        int temp = arr[firstElement];
        arr[firstElement] = arr[secondElement];
        arr[secondElement] = temp;
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitioningIndex = partition(arr, low, high);

            quickSort(arr, low, partitioningIndex - 1);
            quickSort(arr, partitioningIndex + 1, high);
        }
    }

    private static void printArr(int[] arr) {
        for (int element: arr) {
            System.out.print(element + " ");
        }
    }
}
