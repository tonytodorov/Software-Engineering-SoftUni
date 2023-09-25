import java.util.Scanner;

public class _02_Grades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        String result = gradeName(grade);
        System.out.println(result);

    }

    public static String gradeName(double grade){

        String gradeName = "";

        if (grade >= 2.00 && grade <= 2.99) {
            gradeName = "Fail";
        } else if (grade >= 3.00 && grade <= 3.49) {
            gradeName = "Poor";
        } else if (grade >= 3.50 && grade <= 4.49) {
            gradeName = "Good";
        } else if (grade >= 4.50 && grade <= 5.49) {
            gradeName = "Very good";
        } else {
            gradeName = "Excellent";
        }

        return gradeName;
    }
}
