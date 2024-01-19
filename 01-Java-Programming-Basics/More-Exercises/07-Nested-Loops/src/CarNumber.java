import java.util.Scanner;

public class CarNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start, end, sumSecondAndThirdNumbers;
        start = Integer.parseInt(scanner.nextLine());
        end = Integer.parseInt(scanner.nextLine());

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                for (int k = start; k <= end; k++) {
                    for (int l = start; l <= end; l++) {
                        sumSecondAndThirdNumbers = j + k;
                        if(i % 2 == 0) {
                            if (l % 2 != 0) {
                                if (i > l) {
                                    if (sumSecondAndThirdNumbers % 2 == 0) {
                                        System.out.printf("%d%d%d%d ", i, j, k, l);
                                    }
                                }
                            }
                        }else if(i % 2 != 0){
                            if(l % 2 == 0){
                                if(i > l) {
                                    if (sumSecondAndThirdNumbers % 2 == 0) {
                                        System.out.printf("%d%d%d%d ", i, j, k, l);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
