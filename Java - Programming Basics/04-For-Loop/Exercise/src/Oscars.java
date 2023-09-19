import java.util.Scanner;

public class Oscars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfActor, nameOfAssessors;
        double pointsFromAcademy, neededPoints = 1250.5, pointFromAssessors;
        int numberOfAssessors;

        nameOfActor = scanner.nextLine();
        pointsFromAcademy = Double.parseDouble(scanner.nextLine());
        numberOfAssessors = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfAssessors ; i++) {
            nameOfAssessors = scanner.nextLine();
            pointFromAssessors = Double.parseDouble(scanner.nextLine());

            pointsFromAcademy += nameOfAssessors.length() * pointFromAssessors / 2;

            if(pointsFromAcademy > neededPoints){
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", nameOfActor, pointsFromAcademy);
                break;
            }
        }

        if (pointsFromAcademy < neededPoints){
            System.out.printf("Sorry, %s you need %.1f more!", nameOfActor, neededPoints - pointsFromAcademy);
        }
    }
}
