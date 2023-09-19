import java.util.Scanner;

public class Bills {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMonths;
        double priceForElectricity, sumElectricity = 0.00, sumWater, sumInternet, sumOthers = 0.00, average;
        numberOfMonths = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfMonths; i++) {
            priceForElectricity = Double.parseDouble(scanner.nextLine());

            sumElectricity += priceForElectricity;
        }

        sumWater = numberOfMonths * 20;
        sumInternet = numberOfMonths * 15;
        sumOthers = (sumElectricity + sumWater + sumInternet) * 1.2;
        average = (sumElectricity + sumWater + sumInternet + sumOthers) / numberOfMonths;

        System.out.printf("Electricity: %.2f lv%n" +
                "Water: %.2f lv%n" +
                "Internet: %.2f lv%n" +
                "Other: %.2f lv%n" +
                "Average: %.2f lv", sumElectricity, sumWater, sumInternet, sumOthers, average);
    }
}
