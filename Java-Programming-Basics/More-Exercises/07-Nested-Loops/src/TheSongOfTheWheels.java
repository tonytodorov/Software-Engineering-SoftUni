import java.util.Scanner;

public class TheSongOfTheWheels {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, sum, countPasswords = 1;
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        sum = (i * j) + (k * l);
                        if (sum == n) {
                            if(i < j && k > l) {
                                countPasswords++;
                                System.out.printf("%d%d%d%d ",i, j, k, l);
                            }
//                            if (countPasswords == 4){
//                                System.out.printf("Password: %d%d%d%d",i, j, k, l);
//                            }
                        }
                    }
                }
            }
        }
    }




}
