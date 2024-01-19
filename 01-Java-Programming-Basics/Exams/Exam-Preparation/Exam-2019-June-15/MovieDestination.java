import java.util.Scanner;

public class MovieDestination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget, price = 0.00;
        String destination, season;
        int numberOfDays;

        budget = Double.parseDouble(scanner.nextLine());
        destination = scanner.nextLine();
        season = scanner.nextLine();
        numberOfDays = Integer.parseInt(scanner.nextLine());

        if(destination.equals("Dubai")){
            if(season.equals("Winter")){
                price = numberOfDays * 45000;
            }else if(season.equals("Summer")){
                price = numberOfDays * 40000;
            }
            price *= 0.7;
        }

        if(destination.equals("Sofia")){
            if(season.equals("Winter")){
                price = numberOfDays * 17000;
            }else if(season.equals("Summer")){
                price = numberOfDays * 12500;
            }
            price = price + (price * 0.25);
        }

        if(destination.equals("London")){
            if(season.equals("Winter")){
                price = numberOfDays * 24000;
            }else if(season.equals("Summer")){
                price = numberOfDays * 20250;
            }
        }


        if(price > budget){
            System.out.printf("The director needs %.2f leva more!", price - budget);
        }else{
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", budget - price);
        }

    }
}
