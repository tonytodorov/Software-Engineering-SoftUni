import java.util.Scanner;

public class OperationsBetweenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N1, N2, result;
        double total;
        String operator;

        N1 = Integer.parseInt(scanner.nextLine());
        N2 = Integer.parseInt(scanner.nextLine());
        operator = scanner.nextLine();


        if(operator.equals("+")) {
            result = N1 + N2;
            if (result % 2 == 0) {
                System.out.printf("%d + %d = %d - %s", N1, N2, result, "even");
            }else{
                System.out.printf("%d + %d = %d - %s", N1, N2, result, "odd");
            }
        }

        if(operator.equals("-")) {
            result = N1 - N2;
            if (result % 2 == 0) {
                System.out.printf("%d - %d = %d - %s", N1, N2, result, "even");
            }else{
                System.out.printf("%d - %d = %d - %s", N1, N2, result, "odd");
            }
        }

        if(operator.equals("*")) {
            result = N1 * N2;
            if (result % 2 == 0) {
                System.out.printf("%d * %d = %d - %s", N1, N2, result, "even");
            }else{
                System.out.printf("%d * %d = %d - %s", N1, N2, result, "odd");
            }
        }

        if(operator.equals("/")) {
            total = (float)N1 / N2;
            if (N2 != 0) {
                System.out.printf("%d / %d = %.2f", N1, N2, total);
            }else{
                System.out.printf("Cannot divide %d by zero", N1);
            }
        }

        if(operator.equals("%")) {
            total = (float)N1 % N2;
            if (N2 != 0) {
                System.out.printf("%d %% %d = %.0f", N1, N2, total);
            }else{
                System.out.printf("Cannot divide %d by zero", N1);
            }
        }
    }
}
