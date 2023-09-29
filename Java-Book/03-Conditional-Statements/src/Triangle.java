import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1, y1, x2, y2, x3, y3, a, h;
        double s;
        x1 = Integer.parseInt(scanner.nextLine());
        y1 = Integer.parseInt(scanner.nextLine());
        x2 = Integer.parseInt(scanner.nextLine());
        y2 = Integer.parseInt(scanner.nextLine());
        x3 = Integer.parseInt(scanner.nextLine());
        y3 = Integer.parseInt(scanner.nextLine());

        a = Math.abs(x2 - x3);
        h = Math.abs(y1 - y2);
        s = (double)(a * h) / 2;

        System.out.println(s);
    }
}
