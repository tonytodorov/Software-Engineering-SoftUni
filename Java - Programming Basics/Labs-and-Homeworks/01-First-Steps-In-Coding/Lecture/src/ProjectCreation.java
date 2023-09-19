import java.util.Scanner;

public class ProjectCreation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String architectName;
        int numberOfProject, neededHours;

        architectName = scanner.nextLine();
        numberOfProject = scanner.nextInt();

        neededHours = numberOfProject * 3;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.",
                architectName, neededHours, numberOfProject);

    }
}
