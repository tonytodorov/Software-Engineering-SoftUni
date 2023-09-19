import java.util.Scanner;

public class MinNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text;
        int number, minNumber = Integer.MAX_VALUE;
        text = scanner.nextLine();

        while (!text.equals("Stop")){
            number = Integer.parseInt(text);

            if(minNumber > number){
                minNumber = number;
            }
            text = scanner.nextLine();
        }
        System.out.println(minNumber);
    }
}
