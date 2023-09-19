import java.util.Scanner;

public class OnTheTimeForTheExam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hourForExam, minutesForExam, hourCome, minutesCome, examTime, arrivalTime, totalMinutesDifference;
        String late = "Late", onTime = "On time", early = "Early";

        hourForExam = Integer.parseInt(scanner.nextLine());
        minutesForExam = Integer.parseInt(scanner.nextLine());
        hourCome = Integer.parseInt(scanner.nextLine());
        minutesCome = Integer.parseInt(scanner.nextLine());

        examTime = (hourForExam * 60) + minutesForExam;
        arrivalTime = (hourCome * 60) + minutesCome;

        totalMinutesDifference = arrivalTime - examTime;

        System.out.println(totalMinutesDifference);

    }
}
