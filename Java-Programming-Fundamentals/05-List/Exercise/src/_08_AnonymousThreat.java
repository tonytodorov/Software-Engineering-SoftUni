import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08_AnonymousThreat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {

            String[] text = command.split(" ");
            String operation = text[0];

            if (operation.equals("merge")) {
                int startIndex = Integer.parseInt(text[1]);
                int endIndex = Integer.parseInt(text[2]);

                if (startIndex < 0) {
                   endIndexModify(list, endIndex);
                } else if (endIndex > list.size()) {
                   startIndexModify(list, startIndex);
                } else {
                    modifyInRange(list, startIndex, endIndex);
                }
            } else if (operation.equals("divide")) {

            }


            command = scanner.nextLine();
        }
    }

    public static void startIndexModify(List<String> list, int startIndex) {

        for (int i = startIndex; i <= list.size(); i++) {
            String firstElement = list.get(startIndex);
            list.set(startIndex, firstElement + list.get(startIndex + 1));
            list.remove(list.get(startIndex + 1));
        }
    }

    public static void endIndexModify(List<String> list, int endIndex) {

        for (int i = 0; i <= endIndex; i++) {
            String firstElement = list.get(0);
            list.set(0, firstElement + list.get(1));
            list.remove(list.get(1));
        }
    }

    public static void modifyInRange(List<String> list, int startIndex, int endIndex) {

        for (int i = startIndex; i < endIndex; i++) {
            String firstElement = list.get(startIndex);
            list.set(startIndex, firstElement + list.get(startIndex + 1));
            list.remove(list.get(startIndex + 1));
        }
    }
}
