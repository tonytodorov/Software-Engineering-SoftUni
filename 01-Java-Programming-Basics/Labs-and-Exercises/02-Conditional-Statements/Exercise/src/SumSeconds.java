import java.util.Scanner;

public class SumSeconds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstTime, secondTime, thirdTime, totalTime, totalMinutes, totalSeconds;
        firstTime = Integer.parseInt(scanner.nextLine());
        secondTime = Integer.parseInt(scanner.nextLine());
        thirdTime = Integer.parseInt(scanner.nextLine());

        totalTime = firstTime + secondTime + thirdTime;

        totalMinutes = totalTime / 60;
        totalSeconds =  totalTime % 60;

        if(totalSeconds < 10){
            System.out.printf("%d:0%d", totalMinutes, totalSeconds);
        }else{
            System.out.printf("%d:%d", totalMinutes, totalSeconds);
        }
    }
}
