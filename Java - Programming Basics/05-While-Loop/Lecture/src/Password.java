import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username, password, currentPass;

        username = scanner.nextLine();
        password = scanner.nextLine();
        currentPass = scanner.nextLine();

        while(!currentPass.equals(password)){
            currentPass = scanner.nextLine();
        }

        System.out.printf("Welcome %s!", username);
    }
}
