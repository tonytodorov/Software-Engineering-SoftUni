import java.util.Scanner;

public class ExamPreparation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poorGrades, grade, countPoorGrades = 0, countGoodGrades = 0, sum = 0;
        String nameOfTask, lastProblem = "";
        boolean isEnough = false;

        poorGrades = Integer.parseInt(scanner.nextLine());

        while (countPoorGrades < poorGrades){
            nameOfTask = scanner.nextLine();

            if("Enough".equals(nameOfTask)){
                isEnough = true;
                break;
            }

            grade = Integer.parseInt(scanner.nextLine());

            if(grade <= 4){
                countPoorGrades++;
            }

            countGoodGrades++;
            sum += grade;
            lastProblem = nameOfTask;
        }

        if (isEnough){
            System.out.printf("Average score: %.2f%nNumber of problems: %d%nLast problem: %s",
                    (double)sum / countGoodGrades, countGoodGrades, lastProblem);
        }else{
            System.out.printf("You need a break, %d poor grades.", countPoorGrades);
        }


    }
}
