import java.util.Scanner;

public class ChangeBureau {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfBitcoins;
        double numberOfUan, commission, uan, dollars, total;

        numberOfBitcoins = Integer.parseInt(scanner.nextLine());
        numberOfUan = Double.parseDouble(scanner.nextLine());
        commission = Double.parseDouble(scanner.nextLine());

        uan = numberOfUan * 0.15;
        dollars = uan * 1.76;

        total = ((numberOfBitcoins * 1168) + dollars) / 1.95;
        commission = total - ((total * commission) / 100);

        System.out.printf("%.2f", commission);

    }
}
