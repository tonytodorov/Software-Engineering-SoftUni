import java.util.Scanner;

public class _04_MorseCodeTranslator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String[] data = text.split(" ");

        String result = "";

        for (String currentText : data) {
            String letter = morseCode(currentText);
            result += letter;
        }

        System.out.println(result);
    }

    public static String morseCode(String text) {

        String result = "";

        if (text.equals(".-")) {
            result += "A";
        } else if (text.equals("-...")) {
            result += "B";
        } else if (text.equals("-.-.")) {
            result += "C";
        } else if (text.equals("-..")) {
            result += "D";
        } else if (text.equals(".")) {
            result += "E";
        } else if (text.equals("..-.")) {
            result += "F";
        } else if (text.equals("--.")) {
            result += "G";
        } else if (text.equals("....")) {
            result += "H";
        } else if (text.equals("..")) {
            result += "I";
        } else if (text.equals(".---")) {
            result += "J";
        } else if (text.equals("-.-")) {
            result += "K";
        } else if (text.equals(".-..")) {
            result += "L";
        } else if (text.equals("--")) {
            result += "M";
        } else if (text.equals("-.")) {
            result += "N";
        } else if (text.equals("---")) {
            result += "O";
        } else if (text.equals(".--.")) {
            result += "P";
        } else if (text.equals("--.-")) {
            result += "Q";
        } else if (text.equals(".-.")) {
            result += "R";
        } else if (text.equals("...")) {
            result += "S";
        } else if (text.equals("-")) {
            result += "T";
        } else if (text.equals("..-")) {
            result += "U";
        } else if (text.equals("...-")) {
            result += "V";
        } else if (text.equals(".--")) {
            result += "W";
        } else if (text.equals("-..-")) {
            result += "X";
        } else if (text.equals("-.--")) {
            result += "Y";
        } else if (text.equals("--..")) {
            result += "Z";
        } else if (text.equals("|")) {
            result += " ";
        }

        return result;
    }
}
