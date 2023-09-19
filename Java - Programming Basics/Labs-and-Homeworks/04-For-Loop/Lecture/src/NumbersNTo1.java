import java.util.Scanner;

public class NumbersNTo1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; n--) {
            System.out.println(n);
        }
    }
}
