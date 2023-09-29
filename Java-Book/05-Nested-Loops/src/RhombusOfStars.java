import java.util.Scanner;

public class RhombusOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println(Spaces(n - i) + repeatStr("* ", i));
        }

        for (int i = n - 1; i >= 1; i--) {
            System.out.println(Spaces(n - i) + repeatStr("* ", i));
        }
    }


    public static String repeatStr(String symbol, int n){

        String repeatSymbol = "";
        for (int i = 0; i < n; i++) {
            repeatSymbol += symbol;
        }

        return repeatSymbol;
    }

    public static String Spaces(int n) {

        String space = "";
        for (int i = 0; i < n; i++) {
            space += " ";
        }

        return space;
    }
}
