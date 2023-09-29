import java.util.Scanner;

public class Harvest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int harvest, neededLitersWine, numberOfWorkers;
        double grapesFor1M, grapesForWine, wine;

        harvest = Integer.parseInt(scanner.nextLine());
        grapesFor1M = Double.parseDouble(scanner.nextLine());
        neededLitersWine = Integer.parseInt(scanner.nextLine());
        numberOfWorkers = scanner.nextInt();

        grapesForWine = harvest * grapesFor1M * 0.40;
        wine = grapesForWine / 2.5;

        if (neededLitersWine <= wine){
            System.out.printf("Good harvest this year! Total wine: %.0f liters.", Math.floor(wine));
            System.out.println();
            System.out.printf("%.0f liters left -> %.0f liters per person.",
                    Math.ceil(wine - neededLitersWine),
                    Math.ceil((wine - neededLitersWine)) / numberOfWorkers);
        }else{
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(neededLitersWine - wine));
        }
    }
}
