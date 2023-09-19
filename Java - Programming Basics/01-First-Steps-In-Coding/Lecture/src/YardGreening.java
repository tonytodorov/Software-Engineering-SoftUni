import java.util.Scanner;

public class YardGreening {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double landscapeArea, totalPrice, discount, total;
        landscapeArea = scanner.nextDouble();

        totalPrice = landscapeArea * 7.61;
        discount = landscapeArea * 7.61 * 0.18;
        total = totalPrice - discount;

        System.out.printf("The final price is %.2f lv.", total);
        System.out.println();
        System.out.printf("The discount is %.2f lv.", discount);




    }
}
