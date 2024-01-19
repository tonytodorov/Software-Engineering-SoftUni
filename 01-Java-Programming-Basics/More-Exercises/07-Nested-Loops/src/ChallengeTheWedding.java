import java.util.Scanner;

public class ChallengeTheWedding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMens, numberOfWomen, numberOfTables, countTables = 0;

        numberOfMens = Integer.parseInt(scanner.nextLine());
        numberOfWomen = Integer.parseInt(scanner.nextLine());
        numberOfTables = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfMens; i++) {
            for (int j = 1; j <= numberOfWomen ; j++) {
                countTables++;
                if(countTables > numberOfTables){
                    return;
                }
                System.out.printf("(%d <-> %d) ", i, j);
            }
        }
    }
}
