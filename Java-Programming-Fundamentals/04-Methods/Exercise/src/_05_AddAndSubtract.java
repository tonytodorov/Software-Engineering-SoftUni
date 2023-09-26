import java.util.Scanner;

public class _05_AddAndSubtract {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int calculation = calculate(firstNum, secondNum, thirdNum);
        System.out.println(calculation);

    }

    public static int calculate(int firstNum, int secondNum, int thirdNum){
        return (firstNum + secondNum) - thirdNum;
    }
}
