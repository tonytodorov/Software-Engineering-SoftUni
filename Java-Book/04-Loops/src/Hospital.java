import java.util.Scanner;

public class Hospital {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int period, numberOfPatience, numberOfDoctors = 7, untreatedPatient = 0, treatedPatient = 0;

        period = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= period; i++) {
            numberOfPatience = Integer.parseInt(scanner.nextLine());

            if(i % 3 == 0 && untreatedPatient > treatedPatient){
                numberOfDoctors++;
            }

            if(numberOfPatience < numberOfDoctors){
                treatedPatient += numberOfPatience;
            }else {
                untreatedPatient += numberOfPatience - numberOfDoctors;
                treatedPatient += numberOfDoctors;
            }

        }
        System.out.printf("Treated patients: %d.\n", treatedPatient);
        System.out.printf("Untreated patients: %d.", untreatedPatient);
    }
}
