import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_FancyBarcodes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "@[#]+([A-Z][A-Za-z0-9]{4,}[A-Z])@[#]+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                StringBuilder productGroup = new StringBuilder();

                for (int j = 0; j < input.length(); j++) {
                    char letter = input.charAt(j);

                    if (Character.isDigit(letter)) {
                        productGroup.append(letter);
                    }
                }

                if (productGroup.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", productGroup);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
