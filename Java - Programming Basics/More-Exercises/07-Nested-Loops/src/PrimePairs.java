import java.util.Scanner;

public class PrimePairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumberStart, secondNumberStart, firstNumberEnd, secondNumberEnd;
        firstNumberStart = Integer.parseInt(scanner.nextLine());
        secondNumberStart = Integer.parseInt(scanner.nextLine());
        firstNumberEnd = Integer.parseInt(scanner.nextLine());
        secondNumberEnd = Integer.parseInt(scanner.nextLine());

        firstNumberEnd += firstNumberStart;
        secondNumberEnd += secondNumberStart;

        for (int i = firstNumberStart; i <= firstNumberEnd; i++) {
            for (int j = secondNumberStart; j <= secondNumberEnd; j++) {
                if(isPrime(i)){
                    if(isPrime(j)){
                        System.out.printf("%d%d%n", i, j);
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
