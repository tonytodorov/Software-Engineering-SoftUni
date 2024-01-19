import java.util.Scanner;

public class FlowerShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfChrysanthemums, numberOfRoses, numberOfTulips;
        String season, holiday;
        double totalPrice = 0.00;

        numberOfChrysanthemums = Integer.parseInt(scanner.nextLine());
        numberOfRoses = Integer.parseInt(scanner.nextLine());
        numberOfTulips = Integer.parseInt(scanner.nextLine());
        season = scanner.nextLine();
        holiday = scanner.nextLine();

        if(season.equals("Spring") || season.equals("Summer")){
            totalPrice = (numberOfChrysanthemums * 2) + (numberOfRoses * 4.1) + (numberOfTulips * 2.5);
        }

        if(season.equals("Autumn") || season.equals("Winter")){
            totalPrice = (numberOfChrysanthemums * 3.75) + (numberOfRoses * 4.5) + (numberOfTulips * 4.15);
        }

        if(holiday.equals("Y")){
           totalPrice *= 1.15;
        }

        if(numberOfTulips > 7 && season.equals("Spring")){
            totalPrice *= 0.95;
        }

        if(numberOfRoses >= 10 && season.equals("Winter")){
            totalPrice *= 0.9;
        }

        if(numberOfChrysanthemums + numberOfRoses + numberOfTulips > 20){
            totalPrice *= 0.8;
        }

        totalPrice += 2;
        System.out.printf("%.2f", totalPrice);
    }
}
