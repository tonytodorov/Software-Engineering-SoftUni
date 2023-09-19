import java.util.Scanner;

public class HousePainting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x, y, h, frontAndBehindWall, sideWalls, roof, wallsForGreenPaint;

        x = Double.parseDouble(scanner.nextLine());
        y = Double.parseDouble(scanner.nextLine());
        h = Double.parseDouble(scanner.nextLine());

        frontAndBehindWall = (2 * (x * x)) - (1.2 * 2);
        sideWalls = (2 * (x * y)) - (2 * (1.5 * 1.5));
        roof = (2 * (x * y)) + (2 * ((x * h) / 2));

        wallsForGreenPaint =  frontAndBehindWall + sideWalls;

        System.out.printf("%.2f%n", wallsForGreenPaint / 3.4);
        System.out.printf("%.2f", roof / 4.3);


    }
}
