import java.util.Scanner;

public class MovieDay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timeForShooting, numberOfScenes, sceneDuration, timeForShootingScenes;
        double neededTimeBeforeShooting, totalNeededTime;

        timeForShooting = Integer.parseInt(scanner.nextLine());
        numberOfScenes = Integer.parseInt(scanner.nextLine());
        sceneDuration = Integer.parseInt(scanner.nextLine());

        neededTimeBeforeShooting = timeForShooting * 0.15;
        timeForShootingScenes = numberOfScenes * sceneDuration;

        totalNeededTime = neededTimeBeforeShooting + timeForShootingScenes;

        if(totalNeededTime > timeForShooting){
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.",
                    totalNeededTime - timeForShooting);
        }else{
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!",
                    timeForShooting - totalNeededTime);
        }


    }
}
