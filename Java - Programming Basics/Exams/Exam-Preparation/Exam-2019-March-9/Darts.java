import java.util.Scanner;

public class Darts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfPlayer, command = "";
        int numberOfPoints, startingPoints = 301, countSuccessShots = 0, countFailedShots = 0;
        boolean isGameFinish = false;
        nameOfPlayer = scanner.nextLine();

        while (!"Retire".equals(command = scanner.nextLine())){
            numberOfPoints = Integer.parseInt(scanner.nextLine());

            if(command.equals("Triple")){
                numberOfPoints *= 3;
            }else if(command.equals("Double")){
                numberOfPoints *= 2;
            }

            if(numberOfPoints > startingPoints){
                countFailedShots++;
                continue;
            }

            startingPoints -= numberOfPoints;
            countSuccessShots++;

            if(startingPoints <= 0){
                isGameFinish = true;
                break;
            }
        }

        if(isGameFinish){
            System.out.printf("%s won the leg with %d shots.", nameOfPlayer, countSuccessShots);
        }else{
            System.out.printf("%s retired after %d unsuccessful shots.", nameOfPlayer, countFailedShots);
        }
    }
}
