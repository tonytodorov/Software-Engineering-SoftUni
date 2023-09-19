import java.util.Scanner;

public class InvalidNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        number = scanner.nextInt();

        if(number >= 100 && number <= 200 || number == 0){

        }else {
            System.out.println("invalid");
        }
    }
}
