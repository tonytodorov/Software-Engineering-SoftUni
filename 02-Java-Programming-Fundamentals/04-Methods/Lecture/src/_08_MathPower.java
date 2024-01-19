import java.text.DecimalFormat;
import java.util.Scanner;

public class _08_MathPower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int pow = Integer.parseInt(scanner.nextLine());

        double result = mathPow(number, pow);
        System.out.println(new DecimalFormat("0.#####").format(result));

    }

    public static double mathPow(double number, int pow) {
        return Math.pow(number, pow);
    }
}
