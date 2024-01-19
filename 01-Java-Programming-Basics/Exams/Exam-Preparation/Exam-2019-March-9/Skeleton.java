import java.util.Scanner;

public class Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutes, seconds, secondFor100Meters, timeForControl;
        double lengthForSprint, reductionTime, marinTime;

        minutes = Integer.parseInt(scanner.nextLine());
        seconds = Integer.parseInt(scanner.nextLine());
        lengthForSprint = Double.parseDouble(scanner.nextLine());
        secondFor100Meters = Integer.parseInt(scanner.nextLine());

        timeForControl = (minutes * 60) + seconds;
        reductionTime = (lengthForSprint / 120) * 2.5;
        marinTime = ((lengthForSprint / 100) * secondFor100Meters) - reductionTime;

        if(marinTime <= timeForControl){
            System.out.printf("Marin Bangiev won an Olympic quota!%nHis time is %.3f.", marinTime);
        }else{
            System.out.printf("No, Marin failed! He was %.3f second slower.", marinTime - timeForControl);
        }
    }
}
