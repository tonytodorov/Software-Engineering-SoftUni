import java.util.Scanner;

public class SumNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber, nextNumbers, sum = 0;

        firstNumber = Integer.parseInt(scanner.nextLine());

        while(sum < firstNumber){
            nextNumbers = Integer.parseInt(scanner.nextLine());
            sum += nextNumbers;
        }
        System.out.println(sum);
    }
}
