import java.util.Scanner;

public class UniquePinCodes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1, n2, n3;
        n1 = Integer.parseInt(scanner.nextLine());
        n2 = Integer.parseInt(scanner.nextLine());
        n3 = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n1; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= n2; j++) {
                    if (isPrime(j)) {
                        for (int k = 1; k <= n3; k++) {
                            if (k % 2 == 0) {
                                System.out.printf("%d %d %d %n", i, j, k);
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}


