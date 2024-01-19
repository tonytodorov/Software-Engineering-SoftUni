import java.util.Scanner;

public class _10_PokeMon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int powerN, targetM, exhaustY;
        powerN = Integer.parseInt(scanner.nextLine());
        targetM = Integer.parseInt(scanner.nextLine());
        exhaustY = Integer.parseInt(scanner.nextLine());

        int startPowerN = powerN;
        int countPokes = 0;

        while (powerN >= targetM){
            powerN -= targetM;
            countPokes++;

            if(powerN == startPowerN / 2){
                if(exhaustY != 0){
                    powerN /= exhaustY;
                }
            }

        }

        System.out.printf("%d%n%d", powerN, countPokes);
    }
}
