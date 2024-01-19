import java.util.Scanner;

public class OscarsCeremony {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rent;
        double statue, catering, music, totalPrice;
        rent = Integer.parseInt(scanner.nextLine());

        statue = rent * 0.7;
        catering = statue * 0.85;
        music = catering / 2;

        totalPrice = rent + statue + catering + music;

        System.out.printf("%.2f", totalPrice);

    }
}
