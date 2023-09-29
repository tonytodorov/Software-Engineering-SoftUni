import java.util.Scanner;

public class IntegerToBase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int numberSystem = Integer.parseInt(scanner.nextLine());

        String result = convertNumber(number, numberSystem);
        System.out.println(result);

    }

    public static String convertNumber(int number, int numberSystem){

        String result = "";

        while (number > 1){
            number /= numberSystem;
            result += number;
        }

        return result;
    }
}
