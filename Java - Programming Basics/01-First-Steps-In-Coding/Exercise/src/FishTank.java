import java.util.Scanner;

public class FishTank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length, width, height;
        double percent, volumeFishTank, volumeInLitres, total;

        length = Integer.parseInt(scanner.nextLine());
        width = Integer.parseInt(scanner.nextLine());
        height = Integer.parseInt(scanner.nextLine());
        percent = scanner.nextDouble();

        volumeFishTank = length * width * height;
        volumeInLitres = volumeFishTank / 1000;
        total = volumeInLitres * (1 - (percent / 100));

        System.out.println(total);
    }
}
