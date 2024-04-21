import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _10_PredicateParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());


        String command = scanner.nextLine();

        while (!"Party!".equals(command)) {
            String[] tokens = command.split("\\s+");
            String operation = tokens[0];

            if ("Double".equals(operation)) {
                doublyNames(names, tokens);
            } else if ("Remove".equals(operation)) {
                removeNames(names, tokens);
            }

            command = scanner.nextLine();
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!", names.stream()
                    .sorted()
                    .collect(Collectors.joining(", ")));
        }
    }

    private static void doublyNames(List<String> names, String[] tokens) {
        String operationType = tokens[1];

        if (operationType.equals("StartsWith")) {
            String prefix = tokens[2];

            List<String> result = names.stream()
                    .filter(name -> name.startsWith(prefix))
                    .collect(Collectors.toList());

            names.addAll(result);
        } else if (operationType.equals("EndsWith")) {
            String postfix = tokens[2];

            List<String> result = names.stream()
                    .filter(name -> name.endsWith(postfix))
                    .collect(Collectors.toList());

            names.addAll(result);
        } else if (operationType.equals("Length")) {
            int length = Integer.parseInt(tokens[2]);

            List<String> result = names.stream()
                    .filter(name -> name.length() == length)
                    .collect(Collectors.toList());

            names.addAll(result);
        }
    }

    private static void removeNames(List<String> names, String[] tokens) {
        String operationType = tokens[1];

        if (operationType.equals("StartsWith")) {
            String prefix = tokens[2];

            List<String> result = names.stream()
                    .filter(name -> name.startsWith(prefix))
                    .collect(Collectors.toList());

            names.removeAll(result);
        } else if (operationType.equals("EndsWith")) {
            String postfix = tokens[2];

            List<String> result = names.stream()
                    .filter(name -> name.endsWith(postfix))
                    .collect(Collectors.toList());

            names.removeAll(result);
        } else if (operationType.equals("Length")) {
            int length = Integer.parseInt(tokens[2]);

            List<String> result = names.stream()
                    .filter(name -> name.length() == length)
                    .collect(Collectors.toList());

            names.removeAll(result);
        }
    }
}
