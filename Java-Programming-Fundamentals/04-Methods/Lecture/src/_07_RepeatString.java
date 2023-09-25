import java.util.Scanner;

public class _07_RepeatString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int repeatTimes = Integer.parseInt(scanner.nextLine());

        String repeatStr = repeatString(text, repeatTimes);
        System.out.println(repeatStr);

    }

    public static String repeatString(String text, int repeatTimes){

        StringBuilder repeatStr = new StringBuilder();

        for (int i = 0; i < repeatTimes; i++) {
            repeatStr.append(text);
        }

        return repeatStr.toString();
    }
}
