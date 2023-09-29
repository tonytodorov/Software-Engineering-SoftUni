import java.util.Scanner;

public class Sunglasses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String firstRow = repeatString("*", n * 2) + Spaces(n) + repeatString("*", n * 2);
        System.out.println(firstRow);

        for (int i = 0; i < n - 2; i++) {
            System.out.print(repeatString("*", 1) +
                    repeatString("/", (n * 2) - 2) +
                    repeatString("*", 1));

            if(i == (((n - 1) / 2) - 1)){
                System.out.print(repeatString("|", n));
            }else {
                System.out.print(Spaces(n));
            }


            System.out.println(repeatString("*", 1) +
                    repeatString("/", (n * 2) - 2) +
                    repeatString("*", 1));
        }

        System.out.println(firstRow);
    }

    public static String repeatString(String symbol, int n){

        String repeatSymbol = "";
        for (int i = 0; i < n; i++) {
            repeatSymbol += symbol;
        }
        return repeatSymbol;
    }

    public static String Spaces(int n){

        String space = "";
        for (int i = 0; i < n; i++) {
            space += " ";
        }
        return space;
    }
}
