import java.util.Scanner;

public class MathPower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number, pow;
        number = Double.parseDouble(scanner.nextLine());
        pow = Double.parseDouble(scanner.nextLine());

        double result = powNumber(number, pow);
        System.out.printf("%.0f", result);
    }

    public static double powNumber(double number, double pow){
        return Math.pow(number, pow);
    }
}
