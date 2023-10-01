import java.util.Scanner;

public class LunchBreak {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfSerial;
        int episodeTime, breakTime;
        double lunchTime, relaxTime, totalFreeTime;

        nameOfSerial = scanner.nextLine();
        episodeTime = Integer.parseInt(scanner.nextLine());
        breakTime = scanner.nextInt();

        lunchTime = breakTime * 0.125;
        relaxTime = breakTime * 0.25;

        totalFreeTime = breakTime - (lunchTime + relaxTime);

        if(totalFreeTime >= episodeTime){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",
                    nameOfSerial, Math.ceil(totalFreeTime - episodeTime));
        }else{
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",
                    nameOfSerial, Math.ceil(episodeTime - totalFreeTime));
        }

    }
}
