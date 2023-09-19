import java.util.Scanner;

public class FuelTank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfFuel;
        int quantity;

        typeOfFuel = scanner.nextLine();
        quantity = Integer.parseInt(scanner.nextLine());

        switch (typeOfFuel) {
            case "Diesel":
            case "Gas":
            case "Gasoline":
                if (quantity < 25) {
                    System.out.printf("Fill your tank with %s!", typeOfFuel);
                }else{
                    System.out.printf("You have enough %s.", typeOfFuel);
                }
                break;
            default:
                System.out.println("Invalid fuel!");
        }
    }
}
