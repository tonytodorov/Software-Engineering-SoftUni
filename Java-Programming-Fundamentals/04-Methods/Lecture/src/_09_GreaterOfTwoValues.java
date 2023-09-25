import java.util.Scanner;

public class _09_GreaterOfTwoValues {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        if (dataType.equals("int")) {
            int firstNum = Integer.parseInt(scanner.nextLine());
            int secondNum = Integer.parseInt(scanner.nextLine());

            int result = getMax(firstNum, secondNum);
            System.out.println(result);
        } else if (dataType.equals("char")){
            String firstText = scanner.nextLine();
            String secondText = scanner.nextLine();

            char firstLetter = firstText.charAt(0);
            char secondLetter = secondText.charAt(0);

            int result = getMax(firstLetter, secondLetter);
            System.out.println((char) result);
        } else {
            String firstText = scanner.nextLine();
            String secondText = scanner.nextLine();

            String result = getMax(firstText, secondText);
            System.out.println(result);
        }

    }

    public static int getMax(int firstNum, int secondNum) {
        return Math.max(firstNum, secondNum);
    }

    public static int getMax(char firstLetter, char secondLetter) {
        return Math.max(firstLetter, secondLetter);
    }

    public static String getMax(String firstText, String secondText){

        char firstLetter = firstText.charAt(0);
        char secondLetter = secondText.charAt(0);

        if(firstLetter > secondLetter){
            return firstText;
        }

        return secondText;
    }
}
