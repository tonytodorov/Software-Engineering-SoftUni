import java.util.Scanner;

public class FruitShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit, dayOfWeek;
        double quantity, price = 0;

        fruit = scanner.nextLine();
        dayOfWeek = scanner.nextLine();
        quantity = Double.parseDouble(scanner.nextLine());

        boolean isWeekDay = dayOfWeek.equals("Monday")
                || dayOfWeek.equals("Tuesday")
                || dayOfWeek.equals("Wednesday")
                || dayOfWeek.equals("Thursday")
                || dayOfWeek.equals("Friday");

        boolean isHoliday = dayOfWeek.equals("Saturday")
                || dayOfWeek.equals("Sunday");

        boolean isValid = true;

        if(isWeekDay){
            switch (fruit) {
                case "banana":
                    price = quantity * 2.5;
                    break;
                case "apple":
                    price = quantity * 1.2;
                    break;
                case "orange":
                    price = quantity * 0.85;
                    break;
                case "grapefruit":
                    price = quantity * 1.45;
                    break;
                case "kiwi":
                    price = quantity * 2.7;
                    break;
                case "pineapple":
                    price = quantity * 5.5;
                    break;
                case "grapes":
                    price = quantity * 3.85;
                    break;
                default:
                    isValid = false;
            }
        }

        else if(isHoliday){
            switch (fruit) {
                case "banana":
                    price = quantity * 2.7;
                    break;
                case "apple":
                    price = quantity * 1.25;
                    break;
                case "orange":
                    price = quantity * 0.90;
                    break;
                case "grapefruit":
                    price = quantity * 1.60;
                    break;
                case "kiwi":
                    price = quantity * 3;
                    break;
                case "pineapple":
                    price = quantity * 5.60;
                    break;
                case "grapes":
                    price = quantity * 4.2;
                    break;
                default:
                    isValid = false;
            }
        }else{
            isValid = false;
        }

        if (isValid) {
            System.out.printf("%.2f", price);
        }else{
            System.out.println("error");
        }
    }
}
