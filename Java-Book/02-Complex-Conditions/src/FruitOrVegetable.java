import java.util.Scanner;

public class FruitOrVegetable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type;
        type = scanner.nextLine();

        if(type.equals("banana")
                || type.equals("apple")
                || type.equals("kiwi")
                || type.equals("cherry")
                || type.equals("lemon")){
            System.out.println("fruit");
        }else if(type.equals("tomato")
                || type.equals("cucumber")
                || type.equals("pepper")
                || type.equals("carrot")){
            System.out.println("vegetables");
        }else{
            System.out.println("unknown");
        }
    }
}
