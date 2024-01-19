import java.util.Scanner;

public class AluminumJoinery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfJoinery;
        String typeOfJoinery, typeOfDelivery;
        double price = 0.00;

        numberOfJoinery = Integer.parseInt(scanner.nextLine());
        typeOfJoinery = scanner.nextLine();
        typeOfDelivery = scanner.nextLine();

        switch (typeOfJoinery) {
            case "90X130": {
                price = numberOfJoinery * 110;
                if (numberOfJoinery > 60) {
                    price *= 0.92;
                } else {
                    price *= 0.95;
                }
                break;
            }
            case "100X150": {
                price = numberOfJoinery * 140;
                if (numberOfJoinery > 80) {
                    price *= 0.90;
                } else {
                    price *= 0.94;
                }
                break;
            }
            case "130X180": {
                price = numberOfJoinery * 190;
                if (numberOfJoinery > 50) {
                    price *= 0.88;
                } else {
                    price *= 0.93;
                }
                break;
            }
            case "200X300": {
                price = numberOfJoinery * 250;
                if (numberOfJoinery > 50) {
                    price *= 0.86;
                } else {
                    price *= 0.91;
                }
                break;
            }
        }

        if(typeOfDelivery.equals("With delivery")){
            price += 60;
        }

        if(numberOfJoinery >= 99){
            price *= 0.96;
        }


        if(numberOfJoinery <= 10){
            System.out.println("Invalid order");
        }else{
            System.out.printf("%.2f BGN", price);
        }

    }
}
