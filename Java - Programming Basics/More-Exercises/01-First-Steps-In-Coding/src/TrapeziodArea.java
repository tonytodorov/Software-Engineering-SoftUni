import java.util.Scanner;

public class TrapeziodArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a, b, h, s;
        a = Double.parseDouble(scanner.nextLine());
        b = Double.parseDouble(scanner.nextLine());
        h = Double.parseDouble(scanner.nextLine());

        s =  ((a + b) * h) / 2;

        System.out.printf("%.2f", s);
    }
}
