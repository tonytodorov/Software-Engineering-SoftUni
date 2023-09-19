import java.util.Scanner;

public class CarToGo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget;
        String season, typeOfCar = "", carClass = "";

        budget = Double.parseDouble(scanner.nextLine());
        season = scanner.nextLine();

        if(budget <= 100){
            carClass = "Economy class";
            if(season.equals("Summer")){
                typeOfCar = "Carbio";
                budget *= 0.35;
            }else{
                typeOfCar = "Jeep";
                budget *= 0.65;
            }
        }else if(budget <= 500){
            carClass = "Compact class";
            if(season.equals("Summer")){
                typeOfCar = "Carbio";
                budget *= 0.45;
            }else{
                typeOfCar = "Jeep";
                budget *= 0.80;
            }
        }else{
            carClass = "Luxury class";
            typeOfCar = "Jeep";
            budget *= 0.90;
        }

        System.out.printf("%s%n%s - %.2f", carClass, typeOfCar, budget);



    }
}
