import java.util.Scanner;

public class FootballLeague {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacityOfStadium, numberOfFens, countSectorA = 0,
                countSectorB = 0, countSectorV = 0, countSectorG = 0;

        capacityOfStadium = Integer.parseInt(scanner.nextLine());
        numberOfFens = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfFens; i++) {
            String sector = scanner.nextLine();

            if (sector.equals("A")) {
                countSectorA++;
            }else if (sector.equals("B")) {
                countSectorB++;
            }else if (sector.equals("V")) {
                countSectorV++;
            }else if (sector.equals("G")) {
                countSectorG++;
            }

        }

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%",
                1.0 * countSectorA / numberOfFens * 100,
                1.0 * countSectorB / numberOfFens * 100,
                1.0 * countSectorV / numberOfFens * 100,
                1.0 * countSectorG / numberOfFens * 100,
                1.0 * numberOfFens / capacityOfStadium * 100);
    }
}
