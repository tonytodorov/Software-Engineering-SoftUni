import java.util.Scanner;

public class FruitShop {

    public static double price;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit, dayOfWeek;
        double quantity;

        fruit = scanner.nextLine();
        dayOfWeek = scanner.nextLine();
        quantity = Double.parseDouble(scanner.next());

        boolean isWorkDay = dayOfWeek.equals("Monday")
                || dayOfWeek.equals("Tuesday")
                || dayOfWeek.equals("Wednesday")
                || dayOfWeek.equals("Thursday")
                || dayOfWeek.equals("Friday");

        boolean isHoliday = dayOfWeek.equals("Saturday")
                || dayOfWeek.equals("Sunday");


        if(isWorkDay){
            price = switch (fruit) {
                case "banana" -> quantity * 2.5;
                case "apple" -> quantity * 1.2;
                case "orange" -> quantity * 0.85;
                case "grapefruit" -> quantity * 1.45;
                case "kiwi" -> quantity * 2.7;
                case "pineapple" -> quantity * 5.5;
                default -> quantity * 3.85;
            };
        }
        if(isHoliday){
            price = switch (fruit) {
                case "banana" -> quantity * 2.7;
                case "apple" -> quantity * 1.25;
                case "orange" -> quantity * 0.90;
                case "grapefruit" -> quantity * 1.60;
                case "kiwi" -> quantity * 3;
                case "pineapple" -> quantity * 5.6;
                default -> quantity * 4.2;
            };
        }
        System.out.printf("%.2f", price);
    }
}
