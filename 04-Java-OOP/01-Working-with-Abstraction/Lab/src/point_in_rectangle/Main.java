package point_in_rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = read(scanner);

        int n = Integer.parseInt(scanner.nextLine());

        Rectangle rectangle = new Rectangle(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);

        for (int i = 0; i < n; i++) {
            pointsPosition(scanner, rectangle);
        }
    }

    private static void pointsPosition(Scanner scanner, Rectangle rectangle) {
        int[] points = read(scanner);

        Point point = new Point(points[0], points[1]);

        if (rectangle.contains(point)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static int[] read(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
