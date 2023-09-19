import java.util.Scanner;

public class BirthdayParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rentForHall, cake, drinks, animator, totalPrice;
        rentForHall = Double.parseDouble(scanner.nextLine());

        cake = rentForHall * 0.2;
        drinks = cake * 0.55;
        animator = rentForHall / 3;

        totalPrice = rentForHall + cake + drinks + animator;

        System.out.printf("%.1f", totalPrice);
    }
}
