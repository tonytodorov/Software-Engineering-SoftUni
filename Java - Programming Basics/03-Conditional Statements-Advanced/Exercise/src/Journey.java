import java.util.Scanner;

public class Journey {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget;
        String season, destination = "", typeOfHoliday = "";

        budget = Double.parseDouble(scanner.nextLine());
        season = scanner.nextLine();

        if(budget <= 100){
            destination = "Bulgaria";
            if(season.equals("summer")){
                budget *= 0.3;
                typeOfHoliday = "Camp";
            }else{
                budget *= 0.7;
                typeOfHoliday = "Hotel";
            }
        }else if(budget <= 1000){
            destination = "Balkans";
            if(season.equals("summer")){
                budget *= 0.4;
                typeOfHoliday = "Camp";
            }else{
                budget *= 0.8;
                typeOfHoliday = "Hotel";
            }
        }else{
            destination = "Europe";
            budget *= 0.9;
            typeOfHoliday = "Hotel";
        }

        System.out.printf("Somewhere in %s", destination);
        System.out.println();
        System.out.printf("%s - %.2f", typeOfHoliday, budget);
    }
}
