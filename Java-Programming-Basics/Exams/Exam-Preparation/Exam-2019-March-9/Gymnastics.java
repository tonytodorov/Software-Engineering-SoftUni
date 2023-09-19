import java.util.Scanner;

public class Gymnastics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalPoints = 20;
        double difficulty = 0, performance = 0, totalScore, neededPoints, neededPointsInPercent;
        String country, equipment;
        country = scanner.nextLine();
        equipment = scanner.nextLine();

        if(country.equals("Russia")){
            switch (equipment) {
                case "ribbon": {
                    difficulty = 9.100;
                    performance = 9.400;
                    break;
                }
                case "hoop": {
                    difficulty = 9.300;
                    performance = 9.800;
                    break;
                }
                case "rope": {
                    difficulty = 9.600;
                    performance = 9.000;
                    break;
                }
            }
        }

        if(country.equals("Bulgaria")){
            switch (equipment) {
                case "ribbon": {
                    difficulty = 9.600;
                    performance = 9.400;
                    break;
                }
                case "hoop": {
                    difficulty = 9.550;
                    performance = 9.750;
                    break;
                }
                case "rope": {
                    difficulty = 9.500;
                    performance = 9.400;
                    break;
                }
            }
        }

        if(country.equals("Italy")){
            switch (equipment) {
                case "ribbon": {
                    difficulty = 9.200;
                    performance = 9.500;
                    break;
                }
                case "hoop": {
                    difficulty = 9.450;
                    performance = 9.350;
                    break;
                }
                case "rope": {
                    difficulty = 9.700;
                    performance = 9.150;
                    break;
                }
            }
        }

        totalScore = difficulty + performance;
        neededPoints = totalPoints - totalScore;
        neededPointsInPercent = (neededPoints / totalPoints) * 100;

        System.out.printf("The team of %s get %.3f on %s.%n%.2f%%", country, totalScore,
                                                                    equipment, neededPointsInPercent);
    }
}
