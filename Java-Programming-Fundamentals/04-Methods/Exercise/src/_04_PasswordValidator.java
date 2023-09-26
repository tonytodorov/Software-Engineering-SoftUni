import java.util.Scanner;

public class _04_PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        boolean isLengthValid = isLengthValid(text);
        boolean isSymbolsValid = isSymbolsValid(text);
        boolean isContainsTwoOrMoreDigits = isContainsTwoOrMoreDigits(text);

        if (isLengthValid && isSymbolsValid && isContainsTwoOrMoreDigits) {
            System.out.println("Password is valid");
        } else {
            if (!isLengthValid) {
                System.out.println("Password must be between 6 and 10 characters");
            }

            if (!isSymbolsValid) {
                System.out.println("Password must consist only of letters and digits");
            }

            if (!isContainsTwoOrMoreDigits) {
                System.out.println("Password must have at least 2 digits");
            }
        }
    }

    public static boolean isLengthValid(String text){
        return text.length() >= 6 && text.length() <= 10;
    }

    public static boolean isSymbolsValid(String text){

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol >= 33 && symbol <= 47 || symbol >= 58 && symbol <= 64
                    || symbol >= 91 && symbol <= 96 || symbol >= 123) {
                return false;
            }
        }
        return true;
    }

    public static boolean isContainsTwoOrMoreDigits(String text){

        int countDigits = 0;

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if(symbol > 47 && symbol < 58){
                countDigits++;
            }
        }

        return countDigits >= 2;
    }

}
