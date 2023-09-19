import java.util.Scanner;

public class TravelAgency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfCity, typeOfPackage, vipClient;
        int numberOfDays;
        double price = 0.00;

        nameOfCity = scanner.nextLine();
        typeOfPackage = scanner.nextLine();
        vipClient = scanner.nextLine();
        numberOfDays = Integer.parseInt(scanner.nextLine());
        boolean isValidPackage = false;
        boolean isValidCity = false;


        if(nameOfCity.equals("Bansko") || nameOfCity.equals("Borovets")) {


            if(typeOfPackage.equals("noEquipment")){
                price = 80;
                if(vipClient.equals("yes")) {
                    price *= 0.95;
                }
            }else if(typeOfPackage.equals("withEquipment")){
                price = 100;
                if(vipClient.equals("yes")) {
                    price *= 0.90;
                }
            }else{
                isValidPackage = true;
            }




        }

        if(nameOfCity.equals("Varna") || nameOfCity.equals("Burgas")) {
            if(typeOfPackage.equals("noBreakfast")){
                price = 100;
                if(vipClient.equals("yes")) {
                    price *= 0.93;
                }
            }else if(typeOfPackage.equals("withBreakfast")){
                price = 130;
                if(vipClient.equals("yes")) {
                    price *= 0.88;
                }
            }else{
                isValidPackage = true;
            }
        }


        if (numberOfDays < 1){
            System.out.println("Days must be positive number!");
        }else if (isValidPackage){
            System.out.println("Invalid input!");
        }else{
            System.out.printf("The price is %.2flv! Have a nice time!", price * numberOfDays);
        }



    }
}
