import java.util.Scanner;

public class Numbers1ToNWith3Steps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i+=3) {
            System.out.println(i);
        }
    }
}
