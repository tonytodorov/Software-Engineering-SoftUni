import java.util.Scanner;

public class TrainTheTrainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfJury, totalJury = 0;
        String nameOfPresentation;
        double grades, sumGrades, totalGrades = 0.00;
        numberOfJury = Integer.parseInt(scanner.nextLine());

        nameOfPresentation = scanner.nextLine();

        while (!nameOfPresentation.equals("Finish")){
            sumGrades = 0.00;
            for (int j = 0; j < numberOfJury; j++) {
                grades = Double.parseDouble(scanner.nextLine());

                sumGrades += grades;

            }

            totalJury += numberOfJury;
            totalGrades += sumGrades;
            System.out.printf("%s - %.2f.%n", nameOfPresentation, sumGrades / numberOfJury);
            nameOfPresentation = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalGrades / totalJury);
    }
}
