import java.util.Scanner;

public class CompareNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1, n2, n3;
        n1 = Integer.parseInt(scanner.nextLine());
        n2 = Integer.parseInt(scanner.nextLine());
        n3 = Integer.parseInt(scanner.nextLine());

        int result = getMax(n1, n2);
        System.out.printf("Max number is: %d", Math.max(result, n3));

    }

    public static int getMax(int n1, int n2){
        return Math.max(n1, n2);
    }

}
