import java.util.Scanner;

public class _07_TheatrePromotion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int price = 0;
        if (typeOfDay.equals("Weekday")){
            if (age >= 0 && age <= 18){
                price = 12;
            } else if (age <= 64){
                price = 18;
            } else {
                price = 12;
            }
        }

        if (typeOfDay.equals("Weekend")){
            if (age >= 0 && age <= 18){
                price = 15;
            } else if (age <= 64){
                price = 20;
            } else {
                price = 15;
            }
        }

        if (typeOfDay.equals("Holiday")){
            if (age >= 0 && age <= 18){
                price = 5;
            } else if (age <= 64) {
                price = 12;
            } else {
                price = 10;
            }
        }

        if (age < 0 || age > 122){
            System.out.println("Error!");
        } else{
            System.out.printf("%d$", price);
        }
    }
}
