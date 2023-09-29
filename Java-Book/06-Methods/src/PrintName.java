import java.util.Scanner;

public class PrintName {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.printf("Hello, %s!", printName(name));

    }

    public static String printName(String name){
        return name;
    }
}
