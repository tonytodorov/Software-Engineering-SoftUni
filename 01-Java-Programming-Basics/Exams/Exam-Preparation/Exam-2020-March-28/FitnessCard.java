import java.util.Scanner;

public class FitnessCard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget, price = 0.00;
        String gender, sport;
        int age;

        budget = Double.parseDouble(scanner.nextLine());
        gender = scanner.nextLine();
        age = Integer.parseInt(scanner.nextLine());
        sport = scanner.nextLine();

        if(gender.equals("f")){
            if(sport.equals("Gym")){
                price = 35;
            }else if(sport.equals("Boxing")){
                price = 37;
            }else if(sport.equals("Yoga")){
                price = 42;
            }if(sport.equals("Zumba")){
                price = 31;
            }if(sport.equals("Dances")){
                price = 53;
            }if(sport.equals("Pilates")){
                price = 37;
            }
        }

        if(gender.equals("m")){
            if(sport.equals("Gym")){
                price = 42;
            }else if(sport.equals("Boxing")){
                price = 41;
            }else if(sport.equals("Yoga")){
                price = 45;
            }if(sport.equals("Zumba")){
                price = 34;
            }if(sport.equals("Dances")){
                price = 51;
            }if(sport.equals("Pilates")){
                price = 39;
            }
        }

        if(age <= 19){
            price *= 0.8;
        }

        if(budget > price){
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        }else{
            System.out.printf("You don't have enough money! You need $%.2f more.", price - budget);
        }


    }
}
