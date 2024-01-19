package exam20and21april2019;

import java.util.Scanner;

public class EasterBake {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfBakes, quantityOfSugar, quantityOfFlour;
        double numberOfSugarPackage = 0.00, numberOfFlourPackage = 0.00,
                sumQuantityOfSugar = 0.00, sumQuantityOfFlour = 0.00,
                maxQuantityOfSugar = Integer.MIN_VALUE, maxQuantityOfFlour = Integer.MIN_VALUE;

        numberOfBakes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfBakes; i++) {
            quantityOfSugar = Integer.parseInt(scanner.nextLine());
            quantityOfFlour = Integer.parseInt(scanner.nextLine());

            if(quantityOfSugar > maxQuantityOfSugar){
                maxQuantityOfSugar = quantityOfSugar;
            }

            if(quantityOfFlour > maxQuantityOfFlour){
                maxQuantityOfFlour = quantityOfFlour;
            }

            sumQuantityOfSugar += quantityOfSugar;
            sumQuantityOfFlour += quantityOfFlour;

            numberOfSugarPackage = Math.ceil(sumQuantityOfSugar / 950);
            numberOfFlourPackage = Math.ceil(sumQuantityOfFlour / 750);

        }

        System.out.printf("Sugar: %.0f%n" +
                "Flour: %.0f%n" +
                "Max used flour is %.0f grams, max used sugar is %.0f grams.",
                numberOfSugarPackage, numberOfFlourPackage, maxQuantityOfFlour, maxQuantityOfSugar);

    }
}
