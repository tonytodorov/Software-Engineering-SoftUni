import java.util.Scanner;

public class EvenPowersOf2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, result = 1;
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n ; i+=2) {
            System.out.println(result);
            result = result * 2 * 2;
        }
    }
}
