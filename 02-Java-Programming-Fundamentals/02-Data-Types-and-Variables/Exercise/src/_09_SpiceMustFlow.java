import java.util.Scanner;

public class _09_SpiceMustFlow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startYield = Integer.parseInt(scanner.nextLine());
        int totalSpice = 0;
        int countDays = 0;

        while (startYield >= 100){
            int spices = startYield;
            countDays++;
            spices -= 26;
            totalSpice += spices;
            startYield -= 10;
        }

        totalSpice -= 26;

        if(totalSpice < 0){
            totalSpice = 0;
        }

        System.out.printf("%d%n%d", countDays, totalSpice);
    }
}
