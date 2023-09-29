import java.util.Arrays;
import java.util.Scanner;

public class CompareElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index = Integer.parseInt(scanner.nextLine());
        boolean isIndexValid = isIndexValid(array, index);

        if(isIndexValid){
            String result = compareElements(array, index);
            System.out.println(result);
        }else{
            System.out.println("Index out of bound.");
        }

    }

    public static boolean isIndexValid(int[] array, int index){
        return index <= array.length;
    }

    public static String compareElements(int[] array, int index){

        String result = "";
        if(array[index] > array[index - 1] && array[index] > array[index + 1]){
            result = "Element is greater than two neighbours elements.";
        }else{
            result = "Element is smaller than two neighbours elements.";
        }

        return result;
    }

}
