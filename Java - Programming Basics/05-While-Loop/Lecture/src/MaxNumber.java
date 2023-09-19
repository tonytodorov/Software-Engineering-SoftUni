import java.util.Scanner;

public class MaxNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text;
        int number, maxNumber = Integer.MIN_VALUE;
        text = scanner.nextLine();

        while (!text.equals("Stop")){
            number = Integer.parseInt(text);
            if(maxNumber < number){
                maxNumber = number;
            }

            text = scanner.nextLine();
        }
        System.out.println(maxNumber);

    }
}
