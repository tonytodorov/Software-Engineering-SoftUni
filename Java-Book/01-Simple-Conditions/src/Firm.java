import java.util.Scanner;

public class Firm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int neededHours, numberOfDays, numberOfEmployees;
        double freeDays, totalWorkTime;

        neededHours = Integer.parseInt(scanner.nextLine());
        numberOfDays = Integer.parseInt(scanner.nextLine());
        numberOfEmployees = scanner.nextInt();

        freeDays = numberOfDays * 0.9;
        totalWorkTime = (numberOfEmployees * freeDays * 8) + (numberOfEmployees * freeDays * 2);

        if(totalWorkTime >= neededHours){
            System.out.printf("Yes!%.0f hours left.", Math.floor(totalWorkTime - neededHours));
        }else{
            System.out.printf("Not enough time!%.0f hours needed.", Math.floor(neededHours - totalWorkTime));
        }
    }
}
