import java.util.Scanner;

public class HotelRoom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month;
        int numberOfNights;
        double priceForStudio = 0, priceForApartment = 0;

        month = scanner.nextLine();
        numberOfNights = Integer.parseInt(scanner.nextLine());

        if(month.equals("May") || month.equals("October")){
            priceForStudio = numberOfNights * 50;
            priceForApartment = numberOfNights * 65;
            if(numberOfNights >= 7 && numberOfNights <= 14){
                priceForStudio *= 0.95;
            }else{
                priceForStudio *= 0.7;
            }

        }

        if(month.equals("June") || month.equals("September")){
            priceForStudio = numberOfNights * 75.2;
            priceForApartment = numberOfNights * 68.7;
            if(numberOfNights > 14){
                priceForStudio *= 0.8;
            }
        }

        if(month.equals("July") || month.equals("August")){
            priceForStudio = numberOfNights * 76;
            priceForApartment = numberOfNights * 77;
        }

        if(numberOfNights > 14){
            priceForApartment *= 0.9;
        }

        System.out.printf("Apartment: %.2f lv.", priceForApartment);
        System.out.println();
        System.out.printf("Studio: %.2f lv.", priceForStudio);
    }
}
