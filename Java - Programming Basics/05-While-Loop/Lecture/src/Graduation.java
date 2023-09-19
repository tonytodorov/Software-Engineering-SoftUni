import java.util.Scanner;

public class Graduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfStudent;
        int year = 1, countPoorGrades = 0;
        double grades, sum = 0.00, averageGrade;
        nameOfStudent = scanner.nextLine();

        while (year <= 12){
            if(countPoorGrades > 1){
                break;
            }

            grades = Double.parseDouble(scanner.nextLine());

            if(grades < 4){
                countPoorGrades++;
                continue;
            }

            sum += grades;
            year++;
        }

        if (countPoorGrades < 1){
            averageGrade = sum / 12;
            System.out.printf("%s graduated. Average grade: %.2f%n", nameOfStudent, averageGrade);
        }else{
            System.out.printf("%s has been excluded at %d grade", nameOfStudent, year);
        }
    }
}
