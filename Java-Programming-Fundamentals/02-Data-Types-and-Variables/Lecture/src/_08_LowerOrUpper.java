import java.util.Scanner;

public class _08_LowerOrUpper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String letter = scanner.nextLine();
        char text = letter.charAt(0);

        if (Character.isUpperCase(text)){
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
