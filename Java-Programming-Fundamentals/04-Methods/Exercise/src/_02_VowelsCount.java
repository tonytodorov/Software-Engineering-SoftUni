import java.util.Scanner;

public class _02_VowelsCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int result = vowelsLetters(text);
        System.out.println(result);

    }


    public static int vowelsLetters(String text){

        int countVowelsLetters = 0;

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);

            if(letter == 'a' || letter == 'e' || letter == 'o' || letter == 'u' || letter == 'i' ||
                    letter == 'A' || letter == 'E' || letter == 'O' || letter == 'U' || letter == 'I'){
                countVowelsLetters++;
            }

        }

        return countVowelsLetters;
    }




}
