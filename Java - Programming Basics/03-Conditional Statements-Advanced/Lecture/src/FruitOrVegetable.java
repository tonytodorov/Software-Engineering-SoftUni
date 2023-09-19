import java.util.Scanner;

public class FruitOrVegetable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfProduct;

        nameOfProduct = scanner.nextLine();

        if(nameOfProduct.equals("banana")
                || nameOfProduct.equals("apple")
                || nameOfProduct.equals("kiwi")
                || nameOfProduct.equals("cherry")
                || nameOfProduct.equals("lemon")
                || nameOfProduct.equals("grapes")){
            System.out.println("fruit");
        }else if(nameOfProduct.equals("tomato")
                || nameOfProduct.equals("cucumber")
                || nameOfProduct.equals("pepper")
                || nameOfProduct.equals("carrot")){
            System.out.println("vegetable");
        }else{
            System.out.println("unknown");
        }


    }
}
