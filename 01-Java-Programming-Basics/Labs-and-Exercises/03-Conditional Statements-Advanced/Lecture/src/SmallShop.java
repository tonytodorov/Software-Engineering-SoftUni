import java.util.Scanner;

public class SmallShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product, city;
        double quantity, price = 0;

        product = scanner.nextLine();
        city = scanner.nextLine();
        quantity = Double.parseDouble(scanner.nextLine());

        if(city.equals("Sofia")){
            if(product.equals("coffee")){
                price = quantity * 0.5;
            }else if(product.equals("water")){
                price = quantity * 0.8;
            }else if(product.equals("beer")){
                price = quantity * 1.2;
            }else if(product.equals("sweets")){
                price = quantity * 1.45;
            }else{
                price = quantity * 1.6;
            }
        }


        if(city.equals("Plovdiv")){
            if(product.equals("coffee")){
                price = quantity * 0.4;
            }else if(product.equals("water")){
                price = quantity * 0.7;
            }else if(product.equals("beer")){
                price = quantity * 1.15;
            }else if(product.equals("sweets")){
                price = quantity * 1.3;
            }else{
                price = quantity * 1.5;
            }
        }

        if(city.equals("Varna")){
            if(product.equals("coffee")){
                price = quantity * 0.45;
            }else if(product.equals("water")){
                price = quantity * 0.7;
            }else if(product.equals("beer")){
                price = quantity * 1.1;
            }else if(product.equals("sweets")){
                price = quantity * 1.35;
            }else{
                price = quantity * 1.55;
            }
        }


        System.out.println(price);

    }
}
