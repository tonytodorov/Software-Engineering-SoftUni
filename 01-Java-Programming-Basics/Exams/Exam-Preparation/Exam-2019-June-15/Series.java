import java.util.Scanner;

public class Series {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget, priceForSerial, totalPrice = 0.00;
        int numberOfSerials;
        String nameOfSerial;
        budget = Double.parseDouble(scanner.nextLine());
        numberOfSerials = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfSerials; i++) {
            nameOfSerial = scanner.nextLine();
            priceForSerial = Double.parseDouble(scanner.nextLine());

            switch (nameOfSerial) {
                case "Thrones":
                    priceForSerial *= 0.5;
                    break;
                case "Lucifer":
                    priceForSerial *= 0.6;
                    break;
                case "Protector":
                    priceForSerial *= 0.7;
                    break;
                case "TotalDrama":
                    priceForSerial *= 0.8;
                    break;
                case "Area":
                    priceForSerial *= 0.9;
                    break;
            }

            totalPrice += priceForSerial;
        }

        if(budget >= totalPrice){
            System.out.printf("You bought all the series and left with %.2f lv.", budget - totalPrice);
        }else{
            System.out.printf("You need %.2f lv. more to buy the series!", totalPrice - budget);
        }


    }
}
