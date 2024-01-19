import java.util.Scanner;

public class _01_IntegerOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (i < 2){
                sum += number;
            } else if (i < 3){
                sum /= number;
            } else {
                sum *= number;
            }
        }

        System.out.println(sum);
    }
}
