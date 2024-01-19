import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualSums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumLeftSide = 0;
        int sumRightSide = 0;
        int currentIndex = 0;

        boolean isSumEquals = false;

        for (int i = 1; i < numbers.length; i++) {

            int leftSide = i - 1;
            int rightSide = i + 1;

            while (leftSide >= 0){
                sumLeftSide += numbers[leftSide];
                leftSide--;
            }

            while (rightSide < numbers.length){
                sumRightSide += numbers[rightSide];
                rightSide++;
            }

            if(sumLeftSide == sumRightSide){
                isSumEquals = true;
                currentIndex = i;
                break;
            }

            sumLeftSide = 0;
            sumRightSide = 0;
        }

        if(numbers.length - 1 == 0){
            System.out.println(0);
            return;
        }

        if(isSumEquals){
            System.out.println(currentIndex);
        }else{
            System.out.println("no");
        }
    }
}
