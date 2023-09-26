import java.util.Scanner;

public class _01_SmallestOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int minNumber = minNumber(firstNum, secondNum, thirdNum);
        System.out.println(minNumber);
    }

    public static int minNumber(int firstNum, int secondNum, int thirdNum){

        int firstMin = Math.min(firstNum, secondNum);
        int secondMin = Math.min(secondNum, thirdNum);

        return Math.min(firstMin, secondMin);
    }
}
