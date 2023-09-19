import java.util.Scanner;

public class EnergyBooster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit, sizeOfSet;
        int numberOfOrderSets;
        double price = 0.00;

        fruit = scanner.nextLine();
        sizeOfSet = scanner.nextLine();
        numberOfOrderSets = Integer.parseInt(scanner.nextLine());

        if(fruit.equals("Watermelon")){
            if(sizeOfSet.equals("small")){
                price = numberOfOrderSets * 56.00 * 2;
            }else{
                price = numberOfOrderSets * 28.70 * 5;
            }
        }


        if(fruit.equals("Mango")){
            if(sizeOfSet.equals("small")){
                price =  numberOfOrderSets * 36.66 * 2;
            }else{
                price = numberOfOrderSets * 19.60 * 5;
            }
        }


        if(fruit.equals("Pineapple")){
            if(sizeOfSet.equals("small")){
                price = numberOfOrderSets * 42.10 * 2;
            }else{
                price = numberOfOrderSets * 24.80 * 5;
            }
        }

        if(fruit.equals("Raspberry")){
            if(sizeOfSet.equals("small")){
                price = numberOfOrderSets * 20.00 * 2;
            }else{
                price = numberOfOrderSets * 15.20 * 5;
            }
        }

        if(price > 1000){
            price *= 0.5;
        }else if (price >= 400){
            price *= 0.85;
        }

        System.out.printf("%.2f lv.", price);

    }
}
