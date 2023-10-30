import java.util.*;

public class _06_StudentAcademy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> grades = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!grades.containsKey(name)) {
                grades.put(name, new ArrayList<>());
            }

            grades.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry: grades.entrySet()) {

            double totalSum = 0.00;
            int countGrades = 0;

            for (Double grade: entry.getValue()) {
                totalSum += grade;
                countGrades += 1;
            }

            double result = totalSum / countGrades;

            if (result >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), result);
            }
        }
    }
}
