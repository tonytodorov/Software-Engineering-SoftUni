import java.util.Scanner;

public class TruckDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season;
        double kmForMonth;

        season = scanner.nextLine();
        kmForMonth = Double.parseDouble(scanner.nextLine());

        if (season.equals("Spring") || season.equals("Autumn")){
            if(kmForMonth <= 5000){
                kmForMonth *= 0.75 * 4;
            }else if(kmForMonth <= 10000){
                kmForMonth *= 0.95 * 4;
            }else if (kmForMonth <= 20000){
                kmForMonth *= 1.45 * 4;
            }
        }

        if(season.equals("Summer")){
            if(kmForMonth <= 5000){
                kmForMonth *= 0.9 * 4;
            }else if(kmForMonth <= 10000){
                kmForMonth *= 1.1 * 4;
            }else if (kmForMonth <= 20000){
                kmForMonth *= 1.45 * 4;
            }

        }

        if(season.equals("Winter")){
            if(kmForMonth <= 5000){
                kmForMonth *= 1.05 * 4;
            }else if(kmForMonth <= 10000){
                kmForMonth *= 1.25 * 4;
            }else if (kmForMonth <= 20000){
                kmForMonth *= 1.45 * 4;
            }
        }

        kmForMonth *= 0.9;
        System.out.printf("%.2f", kmForMonth);

    }
}
