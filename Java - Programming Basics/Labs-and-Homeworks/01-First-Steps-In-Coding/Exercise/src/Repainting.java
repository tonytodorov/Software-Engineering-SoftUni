import java.util.Scanner;

public class Repainting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nylon, paint, paintThinner, hours;
        double totalNylon, totalPaint, totalPaintThinner, totalHours, totalPrice, total;

        nylon = Integer.parseInt(scanner.nextLine());
        paint = Integer.parseInt(scanner.nextLine());
        paintThinner = Integer.parseInt(scanner.nextLine());
        hours = scanner.nextInt();

        totalNylon = (nylon + 2) * 1.50;
        totalPaint = (paint + (paint * 0.1)) * 14.50;
        totalPaintThinner = paintThinner * 5;

        totalPrice = totalNylon + totalPaint + totalPaintThinner + 0.4;
        totalHours = hours * (totalPrice * 0.3);

        total = totalPrice + totalHours;

        System.out.println(total);
    }
}
