import java.util.Scanner;

public class Histogram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n, number;
        double p1, p2, p3, p4, p5,
                countP1 = 0, countP2 = 0, countP3 = 0, countP4 = 0, countP5 = 0;
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            number = Integer.parseInt(scanner.nextLine());
            if(number < 200){
                countP1++;
            }else if(number <= 399){
                countP2++;
            }else if(number <= 599){
                countP3++;
            }else if(number <= 799){
                countP4++;
            }else{
                countP5++;
            }
        }

        p1 = (countP1 / n) * 100;
        p2 = (countP2 / n) * 100;
        p3 = (countP3 / n) * 100;
        p4 = (countP4 / n) * 100;
        p5 = (countP5 / n) * 100;

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%", p1, p2, p3, p4, p5);
    }
}
