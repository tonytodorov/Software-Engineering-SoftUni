import java.util.Scanner;

public class WorldSwimmingRecord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds, distanceInMeters, timeInSecondsFor1Meter, addedTime, totalTime, finalTime;

        recordInSeconds = Double.parseDouble(scanner.nextLine());
        distanceInMeters = Double.parseDouble(scanner.nextLine());
        timeInSecondsFor1Meter = scanner.nextDouble();

        totalTime = distanceInMeters * timeInSecondsFor1Meter;
        addedTime = (Math.floor(distanceInMeters / 15)) * 12.5;

        finalTime =  totalTime + addedTime;

        if(recordInSeconds <= finalTime){
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(recordInSeconds - finalTime));
        }else{
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", finalTime);
        }
    }
}
