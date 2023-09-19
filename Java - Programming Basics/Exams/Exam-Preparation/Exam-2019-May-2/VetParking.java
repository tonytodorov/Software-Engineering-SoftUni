import java.util.Scanner;

public class VetParking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDays, hours, countDay = 0;
        double taxForParking = 0.00;
        numberOfDays = Integer.parseInt(scanner.nextLine());
        hours = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfDays; i++) {
            taxForParking = 0;
            for (int j = 1; j <= hours; j++) {

                if (j % 3 == 0){
                    if(i % 2 == 0){
                        taxForParking += 2.5;
                    }
                }

                if(j % 2 == 0){
                    if(i % 3 == 0){
                        taxForParking += 1.25;
                    }
                }

                else{
                    taxForParking += 1;
                }

            }
            countDay++;
            System.out.printf("Day: %d - %.2f leva%n", countDay, taxForParking);
        }



    }
}
