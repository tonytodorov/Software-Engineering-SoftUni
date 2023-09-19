import java.util.Scanner;

public class TrekkingMania {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfGroups, numberOfPeople, totalPeople = 0;
        double sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0;
        numberOfGroups = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfGroups; i++) {
            numberOfPeople = Integer.parseInt(scanner.nextLine());

            totalPeople += numberOfPeople;
            if(numberOfPeople <= 5){
                sum1 += numberOfPeople;
            }else if(numberOfPeople <= 12){
                sum2 += numberOfPeople;
            }else if(numberOfPeople <= 25){
                sum3 += numberOfPeople;
            }else if(numberOfPeople <= 40){
                sum4 += numberOfPeople;
            }else{
                sum5 += numberOfPeople;
            }
        }

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%", (sum1 / totalPeople) * 100,
                (sum2 / totalPeople) * 100,
                (sum3 / totalPeople) * 100,
                (sum4 / totalPeople) * 100,
                (sum5 / totalPeople) * 100);
    }
}
