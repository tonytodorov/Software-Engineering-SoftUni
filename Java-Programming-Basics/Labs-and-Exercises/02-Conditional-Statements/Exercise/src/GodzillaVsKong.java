import java.util.Scanner;

public class GodzillaVsKong {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budgetFilm, priceForClothing, priceForDecor, totalBudget;
        int numberOfStatic;

        budgetFilm = Double.parseDouble(scanner.nextLine());
        numberOfStatic = Integer.parseInt(scanner.nextLine());
        priceForClothing = scanner.nextDouble();

        priceForDecor = budgetFilm * 0.1;
        priceForClothing *= numberOfStatic;

        if(numberOfStatic > 150){
            priceForClothing *= 0.9;
        }

        totalBudget = priceForDecor + priceForClothing;

        if(budgetFilm < totalBudget){
            System.out.printf("Not enough money!\n" +  "Wingard needs %.2f leva more.", Math.abs(budgetFilm - totalBudget));
        }else{
            System.out.printf("Action!\n" + "Wingard starts filming with %.2f leva left.", budgetFilm - totalBudget);
        }
    }
}
