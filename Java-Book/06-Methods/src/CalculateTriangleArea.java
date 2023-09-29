import java.util.Scanner;

public class CalculateTriangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a, b;
        a = Double.parseDouble(scanner.nextLine());
        b = Double.parseDouble(scanner.nextLine());

        double area = calculateTriangleArea(a, b);
        System.out.printf("%.2f", area);
    }


    public static double calculateTriangleArea(double a, double b){
        return (a * b) / 2;
    }
}
