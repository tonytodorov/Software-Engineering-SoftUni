import java.util.Scanner;

public class FinalCompetition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDancers;
        double points, winMoney, moneyForCharity, moneyForDancers;
        String season, place;

        numberOfDancers = Integer.parseInt(scanner.nextLine());
        points = Double.parseDouble(scanner.nextLine());
        season = scanner.nextLine();
        place = scanner.nextLine();

        winMoney = numberOfDancers * points;

        if(season.equals("summer")) {
            if(place.equals("Bulgaria")){
                winMoney *= 0.95;
            }else{
                winMoney *= 1.5;
                winMoney *= 0.90;
            }
        }

        if(season.equals("winter")){
            if(place.equals("Bulgaria")){
                winMoney *= 0.92;
            }else{
                winMoney *= 1.5;
                winMoney *= 0.85;
            }
        }

        moneyForCharity = winMoney * 0.75;
        moneyForDancers = (winMoney - moneyForCharity) / numberOfDancers;

        System.out.printf("Charity - %.2f%n", moneyForCharity);
        System.out.printf("Money per dancer - %.2f", moneyForDancers);



    }
}
