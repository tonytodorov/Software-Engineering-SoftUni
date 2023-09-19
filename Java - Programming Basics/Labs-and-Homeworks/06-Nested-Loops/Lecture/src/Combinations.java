import java.util.Scanner;

public class Combinations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, count = 0;
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if(i + j + k == n){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
