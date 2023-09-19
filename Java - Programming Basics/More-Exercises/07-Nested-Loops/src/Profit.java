import java.util.Scanner;

public class Profit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOf1Lv, numberOf2Lv, numberOf5Lv, sum, total;

        numberOf1Lv = Integer.parseInt(scanner.nextLine());
        numberOf2Lv = Integer.parseInt(scanner.nextLine());
        numberOf5Lv = Integer.parseInt(scanner.nextLine());
        sum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= numberOf1Lv; i++) {
            for (int j = 0; j <= numberOf2Lv ; j++) {
                for (int k = 0; k <= numberOf5Lv; k++) {
                    total = i + (j * 2) + (k * 5);
                    if(total == sum){
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", i, j, k, sum);
                    }
                }
            }
        }
    }
}
