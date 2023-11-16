import java.util.Scanner;

public class _04_NetherRealms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String[] parts = text.split("[\\s,]+");

        for (String currentPart : parts) {
            int demonHealth = calculateDemonHealth(currentPart);
            double totalDamage = calculateDamage(currentPart);

            System.out.printf("%s - %d health, %.2f damage%n", currentPart, demonHealth, totalDamage);
        }
    }


    public static int calculateDemonHealth(String currentPart) {

        int demonHealth = 0;

        for (int j = 0; j < currentPart.length(); j++) {
            char letter = currentPart.charAt(j);
            if (!Character.isDigit(letter) && letter != '+' &&
                    letter != '-' &&
                    letter != '/' &&
                    letter != '*' &&
                    letter != '.') {
                demonHealth += letter;
            }
        }

        return demonHealth;
    }

    public static double calculateDamage(String currentPart) {

        String[] numbers = currentPart.split("[A-Za-z]+|[*\\/]+");

        double totalDamage = 0.00;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                double currentNumber = Double.parseDouble(number);
                totalDamage += currentNumber;
            }
        }

        String[] multiplyOrDivide = currentPart.split("[A-Za-z0-9-+.]+");

        for (String currentSign : multiplyOrDivide) {

            if (!currentSign.isEmpty()) {
                for (int i = 0; i < currentSign.length(); i++) {
                    char sign = currentSign.charAt(i);

                    if (sign == '*') {
                        totalDamage *= 2;
                    } else {
                        totalDamage /= 2;
                    }
                }
            }
        }

        return totalDamage;
    }
}
