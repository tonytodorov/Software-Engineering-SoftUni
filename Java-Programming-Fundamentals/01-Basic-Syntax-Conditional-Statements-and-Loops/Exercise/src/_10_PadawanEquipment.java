import java.util.Scanner;

public class _10_PadawanEquipment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        double pricePerLightsaber = Double.parseDouble(scanner.nextLine());
        double pricePerRobe = Double.parseDouble(scanner.nextLine());
        double pricePerBelt = Double.parseDouble(scanner.nextLine());

        double lightsaberCount = Math.ceil(numberOfStudents * 1.1);

        double sumLigthSabes = lightsaberCount * pricePerLightsaber;
        double sumRobes = numberOfStudents * pricePerRobe;
        double sumBelts = (numberOfStudents - (numberOfStudents / 6)) * pricePerBelt;

        double totalPrice = sumLigthSabes + sumRobes + sumBelts;

        if(budget >= totalPrice){
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        }else{
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - budget);
        }
    }
}
