import java.util.Scanner;

public class Notifications {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String typeOfOperation = scanner.nextLine();
            switch (typeOfOperation) {
                case "error" -> {
                    String errorType = scanner.nextLine();
                    String reason = scanner.nextLine();
                    int errorCode = Integer.parseInt(scanner.nextLine());
                    errorMessage(errorType, reason, errorCode);
                }
                case "warning" -> {
                    String warning = scanner.nextLine();
                    warningMessage(warning);
                }
                case "success" -> {
                    String operation = scanner.nextLine();
                    String reason = scanner.nextLine();
                    successMessage(operation, reason);
                }
            }
        }
    }

    public static void errorMessage(String errorType, String reason, int errorCode){

        String errorMessage = "Error: Failed to execute " + errorType + ".";
        System.out.println(errorMessage);

        printEqualSign(errorMessage);

        System.out.printf("Reason: %s.%n", reason);
        System.out.printf("Error code: %d%n", errorCode);
    }

    public static void warningMessage(String warning){

        String warningMessage = "Warning: " + warning + ".";
        System.out.println(warningMessage);

        printEqualSign(warningMessage);
    }

    public static void successMessage(String operation, String reason){

        String successMessage = "Successfully executed " + operation + ".";
        System.out.println(successMessage);

        printEqualSign(successMessage);

        System.out.printf("%s.%n",reason);
    }

    public static void printEqualSign(String message){

        for (int i = 0; i < message.length(); i++) {
            System.out.print("=");
        }

        System.out.println();
    }
}
