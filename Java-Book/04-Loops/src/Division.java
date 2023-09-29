import java.util.Scanner;

public class Division {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, number;
        double p1 = 0, p2 = 0, p3= 0;
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            number = Integer.parseInt(scanner.nextLine());
            if(number % 2 == 0){
                p1++;
            }
            if(number % 3 == 0){
                p2++;
            }
            if(number % 4 == 0){
                p3++;
            }
        }

        p1 = (p1 / n) * 100;
        p2 = (p2 / n) * 100;
        p3 = (p3 / n) * 100;

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%", p1, p2, p3);
    }
}
