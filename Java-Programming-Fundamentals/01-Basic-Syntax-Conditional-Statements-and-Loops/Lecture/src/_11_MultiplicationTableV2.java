import java.util.Scanner;

public class _11_MultiplicationTableV2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < 10; i++) {
            int result = number * multiplier;
            System.out.printf("%d X %d = %d%n", number, multiplier, result);

            if(multiplier >= 10){
                break;
            }

            multiplier++;
        }
    }
}
