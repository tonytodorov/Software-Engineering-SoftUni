import java.util.*;

public class _05_AverageStudentGrade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }

            students.get(name).add(grade);
        }

        for (Map.Entry<String, ArrayList<Double>> entry: students.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());

            double averageGrade = 0.00;
            int countGrades = 0;

            for (Double grade: entry.getValue()) {
                averageGrade += grade;
                countGrades += 1;
                System.out.printf("%.2f ", grade);
            }

            System.out.printf("(avg: %.2f)%n", averageGrade / countGrades);
        }
    }
}
