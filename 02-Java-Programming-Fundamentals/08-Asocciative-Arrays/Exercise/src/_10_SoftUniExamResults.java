import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10_SoftUniExamResults {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Integer> studentInfo = new LinkedHashMap<>();
        Map<String, Integer> language = new LinkedHashMap<>();

        while (!command.equals("exam finished")) {

            String[] data = command.split("-");

            String name = data[0];
            String programLanguage = data[1];

            if (programLanguage.equals("banned")) {
                studentInfo.remove(name);
            } else {
                int points = Integer.parseInt(data[2]);

                if (!language.containsKey(programLanguage)) {
                    language.put(programLanguage, 0);
                }

                language.put(programLanguage, language.get(programLanguage) + 1);

                if (!studentInfo.containsKey(name)) {
                    studentInfo.put(name, points);
                }

            }

            command = scanner.nextLine();
        }

        System.out.println("Results:");

        for (Map.Entry<String, Integer> entry: studentInfo.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }

        System.out.println("Submissions:");

        for (Map.Entry<String, Integer> entry: language.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}
