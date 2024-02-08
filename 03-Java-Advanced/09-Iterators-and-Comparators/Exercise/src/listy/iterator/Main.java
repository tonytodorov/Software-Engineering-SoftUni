package listy.iterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ListyIterator listyIterator = new ListyIterator();

        while (!"END".equals(input)) {

            String[] arguments = System.arraycopy();
            String operation = arguments[0];

            if ("Create".equals(operation)) {
                if (arguments.length <= 1) {
                    listyIterator = new ListyIterator();
                } else {
                    listyIterator = new ListyIterator(arguments);
                }
            } else if ("Move".equals(operation)) {
                listyIterator.iterator().next();
            } else if ("Print".equals(operation)) {

            } else if ("HasNext".equals(operation)) {
                boolean result = listyIterator.iterator().hasNext();

                if (result) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }

            input = scanner.nextLine();
        }
    }
}
