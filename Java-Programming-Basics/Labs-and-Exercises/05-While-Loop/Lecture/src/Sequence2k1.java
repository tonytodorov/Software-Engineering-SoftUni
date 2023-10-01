import java.util.Scanner;

public class Sequence2k1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, nextN = 1;
        n = Integer.parseInt(scanner.nextLine());

        while(nextN <= n){
            System.out.println(nextN);
            nextN = nextN * 2 + 1;
        }
    }
}
