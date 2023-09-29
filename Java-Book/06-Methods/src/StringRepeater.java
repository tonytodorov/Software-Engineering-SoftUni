import java.util.Scanner;

public class StringRepeater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        String result = repeatString(text, count);
        System.out.println(result);

    }

    public static String repeatString(String text, int count){
        return String.valueOf(text).repeat(Math.max(0, count));
    }

}
