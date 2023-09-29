import java.util.Scanner;

public class CatTom {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int holiday, workDays, playTime, normDifferent, hours, minutes;

        holiday = scanner.nextInt();

        workDays = 365 - holiday;
        playTime = (workDays * 63) + (holiday * 127);
        normDifferent = 30000 - playTime;

        hours = normDifferent / 60;
        minutes = normDifferent % 60;

        if(playTime >= 30000){
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", Math.abs(hours), Math.abs(minutes));
        }else{
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hours, minutes);
        }
    }
}
