import java.util.Scanner;

public class _06_MiddleCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String result = printMiddleChar(text);
        System.out.println(result);
    }


    public static String printMiddleChar(String text){

        int calculateMiddlePart = (text.length() - 1) / 2;
        String result = "";

        for (int i = calculateMiddlePart; i < calculateMiddlePart + 2; i++) {
            char symbol = text.charAt(i);
            if (text.length() % 2 == 0) {
                result += symbol;
            } else {
                result += symbol;
                break;
            }
        }

        return result;
    }
}
