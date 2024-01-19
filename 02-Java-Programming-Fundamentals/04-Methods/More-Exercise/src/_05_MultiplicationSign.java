import java.util.Scanner;

public class _05_MultiplicationSign {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        String result = checkSign(firstNum, secondNum, thirdNum);
        System.out.println(result);

    }

    public static String checkSign(int n1, int n2, int n3){

        int countZero = 0;
        int countNegative = 0;

        int[] numbers = new int[3];
        numbers[0] = n1;
        numbers[1] = n2;
        numbers[2] = n3;

        String result = "";

        for (int number : numbers) {
            if (number == 0) {
                countZero += 1;
            } else if (number < 0){
                countNegative += 1;
            }
        }

        if(countZero > 0) {
            result = "zero";
        } else if (countNegative % 2 != 0) {
            result = "negative";
        } else {
            result = "positive";
        }

        return result;
    }

}

