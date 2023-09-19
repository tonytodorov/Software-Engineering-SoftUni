import java.util.Scanner;

public class MobileOperator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String timeContract, typeOfContract, addedMobileOperator;
        int numberOfMoths;
        double priceForContract = 0, totalPrice;

        timeContract = scanner.nextLine();
        typeOfContract = scanner.nextLine();
        addedMobileOperator = scanner.nextLine();
        numberOfMoths = Integer.parseInt(scanner.nextLine());

        if(timeContract.equals("one")){
            switch (typeOfContract) {
                case "Small"      : priceForContract = 9.98; break;
                case "Middle"     : priceForContract = 18.99; break;
                case "Large"      : priceForContract = 25.98; break;
                case "ExtraLarge" : priceForContract = 35.99; break;
            }
        }

        if(timeContract.equals("two")){
            switch (typeOfContract) {
                case "Small"      : priceForContract = 8.58; break;
                case "Middle"     : priceForContract = 17.09; break;
                case "Large"      : priceForContract = 23.59; break;
                case "ExtraLarge" : priceForContract = 31.79; break;
            }
        }


        if(addedMobileOperator.equals("yes")){
            if(priceForContract <= 10) {
                priceForContract += 5.5;
            }else if(priceForContract <= 30){
                priceForContract += 4.35;
            }else{
                priceForContract += 3.85;
            }
        }

        totalPrice = priceForContract * numberOfMoths;

        if(timeContract.equals("two")){
            totalPrice *= 0.9625;
        }

        System.out.printf("%.2f lv.", totalPrice);



    }
}
