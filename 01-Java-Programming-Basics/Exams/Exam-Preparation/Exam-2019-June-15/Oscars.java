import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfActor, nameOfAppraiser;
        double pointsFromAcademy, numberOfPointsFromAppraiser, neededPoints = 1250.5;
        int numberOfAppraiser;
        boolean isPointsEnough = false;

        nameOfActor = scanner.nextLine();
        pointsFromAcademy = Double.parseDouble(scanner.nextLine());
        numberOfAppraiser = Integer.parseInt(scanner.nextLine());

        while (numberOfAppraiser > 0){
            nameOfAppraiser = scanner.nextLine();
            numberOfPointsFromAppraiser = Double.parseDouble(scanner.nextLine());
            pointsFromAcademy += nameOfAppraiser.length() * numberOfPointsFromAppraiser / 2;

            if(pointsFromAcademy > neededPoints){
                isPointsEnough = true;
                break;
            }

            numberOfAppraiser--;
        }

        if(isPointsEnough){
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", nameOfActor, pointsFromAcademy);
        }else{
            System.out.printf("Sorry, %s you need %.1f more!", nameOfActor, neededPoints - pointsFromAcademy);
        }

    }
}
