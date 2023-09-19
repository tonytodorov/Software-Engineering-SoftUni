import java.util.Scanner;

public class SkiTrip {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int holidayTime, numberOfNights;
        double price, totalPriceWithDiscount = 0;
        String typeOfRoom, rating;

        holidayTime = Integer.parseInt(scanner.nextLine());
        typeOfRoom = scanner.nextLine();
        rating = scanner.nextLine();

        numberOfNights = holidayTime - 1;

        if(typeOfRoom.equals("room for one person")){
            totalPriceWithDiscount = numberOfNights * 18;
        }

        if(typeOfRoom.equals("apartment")){
            if(holidayTime < 10){
                price = numberOfNights * 25;
                totalPriceWithDiscount = price * 0.7;
            }else if(holidayTime < 15){
                price = numberOfNights * 25;
                totalPriceWithDiscount = price * 0.65;
            }else{
                price = numberOfNights * 25;
                totalPriceWithDiscount = price * 0.5;
            }
        }

        if(typeOfRoom.equals("president apartment")){
            if(holidayTime < 10){
                price = numberOfNights * 35;
                totalPriceWithDiscount = price * 0.9;
            }else if(holidayTime < 15){
                price = numberOfNights * 35;
                totalPriceWithDiscount = price * 0.85;
            }else{
                price = numberOfNights * 35;
                totalPriceWithDiscount = price * 0.8;
            }
        }

        if(rating.equals("positive")){
            totalPriceWithDiscount = totalPriceWithDiscount + (totalPriceWithDiscount * 0.25);
        }else{
            totalPriceWithDiscount = totalPriceWithDiscount - (totalPriceWithDiscount * 0.1);
        }

        System.out.printf("%.2f", totalPriceWithDiscount);

    }
}
