import java.text.DecimalFormat;
import java.util.*;

public class _08_AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }

            for (Double grade: grades) {
                students.get(name).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> entry: students.entrySet()) {

            double sumGrades = 0.00;
            int countGrades = 0;

            for (Double grade: entry.getValue()) {
                sumGrades += grade;
                countGrades += 1;
            }

            double averageGrade = sumGrades / countGrades;

            System.out.printf("%s is graduated with %s%n", entry.getKey(),
                    new DecimalFormat("#.##################").format(averageGrade));
        }
    }
}
