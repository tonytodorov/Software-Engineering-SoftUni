import java.util.Scanner;

public class PipesInPool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int debitPool, debitForFirstHour, debitForSecondHour;
        double freeHours, fullPool, firstPipeDebit, secondPipeDebit, totalDebit;

        debitPool = Integer.parseInt(scanner.nextLine());
        debitForFirstHour = Integer.parseInt(scanner.nextLine());
        debitForSecondHour = Integer.parseInt(scanner.nextLine());
        freeHours = scanner.nextDouble();

        fullPool = ((debitForFirstHour * freeHours) + (debitForSecondHour * freeHours)) * 0.1;
        firstPipeDebit = ((debitForFirstHour * freeHours) / fullPool) * 10;
        secondPipeDebit = ((debitForSecondHour * freeHours) / fullPool) * 10;

        totalDebit = (debitForFirstHour * freeHours) + (debitForSecondHour * freeHours);

        if(totalDebit >= debitPool){
            System.out.printf("For %.1f hours the pool overflows with %.0f liters.", freeHours, totalDebit - debitPool);
        }else{
            System.out.printf("The pool is %.0f%% full. Pipe 1: %.0f%%. Pipe 2: %.0f%%.", fullPool, firstPipeDebit, Math.floor(secondPipeDebit));
        }
    }
}
