import java.util.Arrays;
import java.util.Scanner;

public class _03_ZigZagArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        int countIterates = 1;

        for (int i = 0; i < firstArray.length; i++) {

            int[] array = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (countIterates % 2 != 0) {
                firstArray[i] = array[0];
                secondArray[i] = array[1];
            } else {
              firstArray[i] = array[1];
              secondArray[i] = array[0];
            }

            countIterates++;
        }

        printArray(firstArray);

        System.out.println();

        printArray(secondArray);
        
    }

    public static void printArray(int[] array){

        for (int num: array) {
            System.out.printf("%d ", num);
        }
    }


}
