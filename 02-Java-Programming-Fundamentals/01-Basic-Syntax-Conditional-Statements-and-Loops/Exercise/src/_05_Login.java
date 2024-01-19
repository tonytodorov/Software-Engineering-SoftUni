import java.util.Scanner;

public class _05_Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String text = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            char letter = username.charAt(i);
            text += letter;
        }

        String password = scanner.nextLine();
        int count = 0;
        boolean isFourthTime = false;

        while (!password.equals(text)){
            count++;

            if(count >= 4){
                isFourthTime = true;
                break;
            }

            System.out.println("Incorrect password. Try again.");
            password = scanner.nextLine();
        }

        if(isFourthTime){
            System.out.printf("User %s blocked!", username);
        }else{
            System.out.printf("User %s logged in.", username);
        }
    }
}
