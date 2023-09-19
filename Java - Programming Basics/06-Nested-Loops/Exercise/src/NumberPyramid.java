import java.util.Scanner;

public class NumberPyramid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n , counterNum = 1;
        n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(counterNum + " ");
                counterNum++;

                if(counterNum > n){
                    return;
                }
            }
            System.out.println();
        }
    }
}
