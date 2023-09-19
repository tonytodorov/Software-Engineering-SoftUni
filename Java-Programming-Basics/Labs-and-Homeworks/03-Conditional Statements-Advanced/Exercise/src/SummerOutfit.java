import java.util.Scanner;

public class SummerOutfit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees;
        String timeOfNight, outfit = "", shoes = "";

        degrees = Integer.parseInt(scanner.nextLine());
        timeOfNight = scanner.nextLine();

        if(timeOfNight.equals("Morning")){
            if(degrees <= 18){
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            }else if(degrees <= 24){
                outfit = "Shirt";
                shoes = "Moccasins";
            }else{
                outfit = "T-Shirt";
                shoes = "Sandals";
            }
        }

        if(timeOfNight.equals("Afternoon")){
            if(degrees <= 18){
                outfit = "Shirt";
                shoes = "Moccasins";
            }else if(degrees <= 24){
                outfit = "T-Shirt";
                shoes = "Sandals";
            }else{
                outfit = "Swim Suit";
                shoes = "Barefoot";
            }
        }

        if(timeOfNight.equals("Evening")){
            outfit = "Shirt";
            shoes = "Moccasins";
        }

        System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
    }
}
