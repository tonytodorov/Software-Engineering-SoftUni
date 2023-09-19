import java.util.Scanner;

public class ExcellentResult {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        boolean isValid = num >= 5 && num <= 6;

        if(isValid){
            System.out.println(num);
        }
    }
}
