import java.util.Scanner;

public class _11_Snowballs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double maxValue = Double.MIN_VALUE;

        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;
        double bestSnowballValue = 0.00;

        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double result = 1.0 * snowballSnow / snowballTime;
            double snowballValue = Math.pow(result, snowballQuality);

            if(snowballValue > maxValue){
                maxValue = snowballValue;
                bestSnowballSnow = snowballSnow;
                bestSnowballTime = snowballTime;
                bestSnowballQuality = snowballQuality;
                bestSnowballValue = snowballValue;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", bestSnowballSnow,
                bestSnowballTime,
                bestSnowballValue,
                bestSnowballQuality);
    }
}
