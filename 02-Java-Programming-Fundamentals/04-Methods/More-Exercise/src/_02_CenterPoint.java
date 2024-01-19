import java.util.Scanner;

public class _02_CenterPoint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1, y1, x2, y2;
        x1 = Integer.parseInt(scanner.nextLine());
        y1 = Integer.parseInt(scanner.nextLine());
        x2 = Integer.parseInt(scanner.nextLine());
        y2 = Integer.parseInt(scanner.nextLine());

        if (closestPoints(x1, y1) <= closestPoints(x2, y2)) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }

    }

    public static double closestPoints(int x, int y){
        return Math.sqrt(Math.abs(Math.pow(x, 2) + (Math.pow(y, 2))));
    }

}
