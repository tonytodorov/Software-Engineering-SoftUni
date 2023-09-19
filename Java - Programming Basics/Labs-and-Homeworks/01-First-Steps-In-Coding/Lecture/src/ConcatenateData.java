import java.util.Scanner;

public class ConcatenateData {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstName, lastName, city;
        int age;

        firstName = scanner.nextLine();
        lastName  = scanner.nextLine();;
        age       = Integer.parseInt(scanner.nextLine());
        city      = scanner.nextLine();

        System.out.println("You are " + firstName + " " + lastName + ", " + "a " + age + "-years old person from " + city + ".");


    }
}
