import java.util.Scanner;

public class DivisionWithoutRemainder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, number, numberDivides2 = 0, numberDivides3 = 0, numberDivides4 = 0;
        double p1, p2, p3;
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(scanner.nextLine());

            if(number % 2== 0){
                numberDivides2++;
            }
            if(number % 3 ==0){
                numberDivides3++;
            }
            if(number % 4 == 0){
                numberDivides4++;
            }
        }

        p1 = (double)numberDivides2 / n * 100;
        p2 = (double)numberDivides3 / n * 100;
        p3 = (double)numberDivides4 / n * 100;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3);

    }
}
