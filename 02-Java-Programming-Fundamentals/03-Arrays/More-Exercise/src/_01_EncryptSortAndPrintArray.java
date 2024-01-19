import java.util.Arrays;
import java.util.Scanner;

public class _01_EncryptSortAndPrintArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] result = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            for (int j = 0; j < text.length(); j++) {
                char letter = text.charAt(j);

                if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ||
                        letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U'){
                    sum += letter * text.length();
                } else {
                    sum += letter / text.length();
                }
            }

            result[i] = sum;
            sum = 0;
        }

        Arrays.sort(result);

        for (int num: result) {
            System.out.println(num);
        }
    }
}
