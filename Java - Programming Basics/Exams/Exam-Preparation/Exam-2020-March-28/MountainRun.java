import java.util.Scanner;

public class MountainRun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordsInSeconds, distanceInMeters, timeInSecondsToClimb1M, timeForClimb;

        recordsInSeconds = Double.parseDouble(scanner.nextLine());
        distanceInMeters = Double.parseDouble(scanner.nextLine());
        timeInSecondsToClimb1M = Double.parseDouble(scanner.nextLine());

        timeForClimb = distanceInMeters * timeInSecondsToClimb1M;
        distanceInMeters = Math.floor((distanceInMeters / 50)) * 30;
        timeForClimb += distanceInMeters;

        if(timeForClimb < recordsInSeconds){
            System.out.printf("Yes! The new record is %.2f seconds.", timeForClimb);
        }else{
            System.out.printf("No! He was %.2f seconds slower.", timeForClimb - recordsInSeconds);
        }
    }
}
