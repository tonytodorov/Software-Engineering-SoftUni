import java.util.*;

public class _05_Courses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, List<String>> students = new LinkedHashMap<>();

        while (!command.equals("end")) {

            String[] data = command.split(" : ");
            String course = data[0];
            String studentName = data[1];

            if (!students.containsKey(course)) {
                students.put(course, new ArrayList<>());
            }

            students.get(course).add(studentName);

            command = scanner.nextLine();
        }


        for (Map.Entry<String, List<String>> entry: students.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());

            for (String student: entry.getValue()) {
                System.out.printf("-- %s%n", student);
            }
        }
    }
}
