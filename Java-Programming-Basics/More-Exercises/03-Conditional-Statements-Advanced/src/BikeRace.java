import java.util.Scanner;

public class BikeRace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniorBikers, seniorBikers;
        double priceForJuniors, priceForSeniors, totalPrice;
        String trace;

        juniorBikers = Integer.parseInt(scanner.nextLine());
        seniorBikers = Integer.parseInt(scanner.nextLine());
        trace = scanner.nextLine();

        if(trace.equals("trail")){
            priceForJuniors = juniorBikers * 5.5;
            priceForSeniors = seniorBikers * 7;
        }else if(trace.equals("cross-country")){
            priceForJuniors = juniorBikers * 8;
            priceForSeniors = seniorBikers * 9.5;
        }else if(trace.equals("downhill")){
            priceForJuniors = juniorBikers * 12.25;
            priceForSeniors = seniorBikers * 13.75;
        }else{
            priceForJuniors = juniorBikers * 20;
            priceForSeniors = seniorBikers * 21.5;
        }

        totalPrice = priceForJuniors + priceForSeniors;
        totalPrice *= 0.95;
        if(juniorBikers + seniorBikers >= 50){
            totalPrice *= 0.75;
        }

        System.out.printf("%.2f", totalPrice);


    }
}
