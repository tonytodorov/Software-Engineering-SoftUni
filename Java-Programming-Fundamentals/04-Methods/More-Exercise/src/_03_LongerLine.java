import java.util.Scanner;

public class _03_LongerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1, y1, x2, y2, x3, y3, x4, y4;
        x1 = Integer.parseInt(scanner.nextLine());
        y1 = Integer.parseInt(scanner.nextLine());
        x2 = Integer.parseInt(scanner.nextLine());
        y2 = Integer.parseInt(scanner.nextLine());

        x3 = Integer.parseInt(scanner.nextLine());
        y3 = Integer.parseInt(scanner.nextLine());
        x4 = Integer.parseInt(scanner.nextLine());
        y4 = Integer.parseInt(scanner.nextLine());

        printLongestLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public static void printLongestLine(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        double firstResult = Math.sqrt((Math.pow((x1 - x2), 2)) + Math.pow((y1 - y2), 2));
        double secondResult = Math.sqrt((Math.pow((x3 - x4), 2)) + Math.pow((y3 - y4), 2));

        if (firstResult >= secondResult) {
            closestToZero(x2, y2, x1, y1);
        } else {
            closestToZero(x4, y4, x3, y3);
        }
    }

    public static void closestToZero(int x1, int y1, int x2, int y2) {

        double firstResult = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double secondResult = Math.sqrt(Math.pow(x2, 2)) + (Math.pow(y2, 2));

        if (firstResult <= secondResult) {
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        } else {
            System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        }
    }

}
