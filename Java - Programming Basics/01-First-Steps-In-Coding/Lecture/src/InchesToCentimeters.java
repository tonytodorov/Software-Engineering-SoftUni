import java.util.Scanner;

public class InchesToCentimeters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double inch, result;
        inch = scanner.nextDouble();
        result = inch * 2.54;

        System.out.println(result);


    }
}
