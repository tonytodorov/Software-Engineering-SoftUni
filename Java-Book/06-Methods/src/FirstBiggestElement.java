import java.util.Arrays;
import java.util.Scanner;

public class FirstBiggestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = firstBiggestElement(array);
        System.out.printf("Index of first bigger elements is: %d", result);

    }

    public static int firstBiggestElement(int[] array){

        for (int i = 0; i < array.length; i++) {
            if(i == 0){
                if(array[i] > array[i + 1]){
                    return i;
                }
            }else if(array[i] > array[i - 1] && array[i] > array[i + 1]){
                return i;
            }else if(i == array.length - 2){
                if(array[array.length - 1] > array[array.length - 2]){
                    return i;
                }
            }
        }

        return -1;
    }
}
