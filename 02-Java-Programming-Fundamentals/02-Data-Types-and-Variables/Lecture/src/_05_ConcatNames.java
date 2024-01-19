import java.util.Scanner;

public class _05_ConcatNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delemiter = scanner.nextLine();

        System.out.printf("%s%s%s", firstName, delemiter, lastName);
    }
}
