import java.util.Scanner;

public class CircleAreaAndPerimeter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double r, area, perimeter;
        r = Double.parseDouble(scanner.nextLine());

        area = Math.PI * r * r;
        perimeter = 2 * Math.PI * r;

        System.out.printf("%.2f%n%.2f", area, perimeter);
    }
}
