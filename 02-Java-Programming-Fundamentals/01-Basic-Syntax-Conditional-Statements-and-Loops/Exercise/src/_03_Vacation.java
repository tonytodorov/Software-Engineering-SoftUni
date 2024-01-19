import java.util.Scanner;

public class _03_Vacation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double price = 0.00;

        if(typeOfGroup.equals("Students")){

            if(dayOfWeek.equals("Friday")){
                price = numberOfPeople * 8.45;
            }else if (dayOfWeek.equals("Saturday")){
                price = numberOfPeople * 9.80;
            }else{
                price = numberOfPeople * 10.46;
            }

            if(numberOfPeople >= 30){
                price *= 0.85;
            }
        }

        if(typeOfGroup.equals("Business")){

            if(numberOfPeople >= 100){
                numberOfPeople -= 10;
            }

            if(dayOfWeek.equals("Friday")){
                price = numberOfPeople * 10.90;
            }else if (dayOfWeek.equals("Saturday")){
                price = numberOfPeople * 15.60;
            }else{
                price = numberOfPeople * 16;
            }

        }

        if(typeOfGroup.equals("Regular")){

            if(dayOfWeek.equals("Friday")){
                price = numberOfPeople * 15;
            }else if (dayOfWeek.equals("Saturday")){
                price = numberOfPeople * 20;
            }else{
                price = numberOfPeople * 22.50;
            }

            if(numberOfPeople >= 10 && numberOfPeople <= 20){
                price *= 0.95;
            }
        }

        System.out.printf("Total price: %.2f", price);
    }
}
