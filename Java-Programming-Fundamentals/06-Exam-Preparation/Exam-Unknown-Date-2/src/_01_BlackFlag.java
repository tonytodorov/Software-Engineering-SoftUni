import java.util.Scanner;

public class _01_BlackFlag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int piratesPlunder = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());

        double totalPlunder = 0;

        for (int i = 1; i <= days; i++) {
            totalPlunder += piratesPlunder;

            if (i % 3 == 0) {
                totalPlunder += piratesPlunder * 0.5;
            }

            if (i % 5 == 0) {
                totalPlunder *= 0.7;
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            double percent = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percent);
        }
    }
}
