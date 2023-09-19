import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, n1;
        n = Integer.parseInt(scanner.nextLine());
        n1 = Integer.parseInt(scanner.nextLine());
        int letter = 97 + n1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 97; k < letter; k++) {
                    for (char l = 97; l < letter; l++) {
                        for (int m = 1; m <= n; m++) {
                            if(m > i && m > j){
                                System.out.printf("%d%d%s%s%d ", i, j, (char)k, l, m);
                            }
                        }
                    }
                }
            }
        }
    }
}
