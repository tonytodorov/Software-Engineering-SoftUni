import java.util.Scanner;

public class House {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String upperSide, midSide, downSide;
        int countStars = -1;
        int n = Integer.parseInt(scanner.nextLine());

        if(n % 2 == 0) {
            for (int i = 1; i < (n / 2); i++) {
                upperSide = repeatStr("_", ((n - (2 * i)) / 2)) +
                        repeatStr("*", 2 * i) +
                        repeatStr("_", ((n - (2 * i)) / 2));
                System.out.println(upperSide);
            }
        }else{
            for (int i = 1; i <= (n / 2); i++) {
                upperSide = repeatStr("_", ((n - i) / 2)) +
                        repeatStr("*", countStars + 2) +
                        repeatStr("_", ((n - i) / 2));
                System.out.println(upperSide);
                countStars += 2;
            }
        }

        midSide = repeatStr("*", n);
        System.out.println(midSide);

        for (int i = 1; i <= (n / 2) ; i++) {
            downSide = "|" + repeatStr("*", n - 2) + "|";
            System.out.println(downSide);
        }
    }


    public static String repeatStr(String symbol, int n){

        String text = "";
        for (int i = 0; i < n; i++) {
            text += symbol;
        }

        return text;
    }
}
