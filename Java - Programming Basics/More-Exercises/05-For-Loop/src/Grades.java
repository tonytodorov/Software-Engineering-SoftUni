import java.util.Scanner;

public class Grades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents, countFailGrades = 0, countGoodGrades = 0,
                countVeryGoodGrades = 0, countExcellentGrades = 0;
        double grade, sum = 0.00;
        numberOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfStudents; i++) {
            grade = Double.parseDouble(scanner.nextLine());

            if(grade <= 2.99){
                countFailGrades++;
            }else if (grade <= 3.99){
                countGoodGrades++;
            }else if (grade <= 4.99){
                countVeryGoodGrades++;
            }else{
                countExcellentGrades++;
            }

            sum += grade;
        }

        System.out.printf("Top students: %.2f%%%n", 1.0 * countExcellentGrades / numberOfStudents * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", 1.0 * countVeryGoodGrades / numberOfStudents * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", 1.0 * countGoodGrades / numberOfStudents * 100);
        System.out.printf("Fail: %.2f%%%n", 1.0 * countFailGrades / numberOfStudents * 100);
        System.out.printf("Average: %.2f%%", sum / numberOfStudents);

    }
}
