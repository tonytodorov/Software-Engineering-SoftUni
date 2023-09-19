import java.util.Scanner;

public class Salary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfOpenTabs, salary;
        String nameOfSite;

        numberOfOpenTabs = Integer.parseInt(scanner.nextLine());
        salary = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfOpenTabs; i++) {
            nameOfSite = scanner.nextLine();
            switch (nameOfSite) {
                case "Facebook":
                    salary -= 150;
                    break;
                case "Instagram":
                    salary -= 100;
                    break;
                case "Reddit":
                    salary -= 50;
                    break;
            }
            if(salary <= 0){
                System.out.println("You have lost your salary.");
                break;
            }
        }

        if(salary > 0){
            System.out.println(salary);
        }
    }
}
