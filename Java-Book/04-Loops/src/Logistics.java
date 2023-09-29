import java.util.Scanner;

public class Logistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLoads, tonsOfLoads,
                tonsOfLoadsWithMicrobus = 0,
                tonsOfLoadsWithTir = 0,
                tonsOfLoadsWithTrain = 0,
                totalLoads;
        double averagePrice, p1, p2, p3;

        numberOfLoads = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfLoads; i++) {
            tonsOfLoads = Integer.parseInt(scanner.nextLine());
            if(tonsOfLoads <= 3){
                tonsOfLoadsWithMicrobus += tonsOfLoads;
            }else if(tonsOfLoads <= 11){
                tonsOfLoadsWithTir += tonsOfLoads;
            }else{
                tonsOfLoadsWithTrain += tonsOfLoads;
            }
        }

        totalLoads = tonsOfLoadsWithMicrobus + tonsOfLoadsWithTir + tonsOfLoadsWithTrain;

        p1 = (double) tonsOfLoadsWithMicrobus / totalLoads * 100;
        p2 = (double) tonsOfLoadsWithTir / totalLoads * 100;
        p3 = (double) tonsOfLoadsWithTrain / totalLoads * 100;

        averagePrice = (double)((tonsOfLoadsWithMicrobus * 200) + (tonsOfLoadsWithTir * 175) + (tonsOfLoadsWithTrain * 120)) / totalLoads;

        System.out.printf("%.2f\n%.2f%%\n%.2f%%\n%.2f%%", averagePrice, p1, p2, p3);

    }
}
