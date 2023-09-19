import java.util.Scanner;

public class USDToBGN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double usd, totalBGN;
        usd = scanner.nextDouble();
        totalBGN = usd * 1.79549;

        System.out.println(totalBGN);
    }
}
