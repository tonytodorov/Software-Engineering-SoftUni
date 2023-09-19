import java.util.Scanner;

public class RadiansToDegrees {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radians, totalDegrees;
        radians = Double.parseDouble(scanner.nextLine());
        totalDegrees = radians * (180 / Math.PI);

        System.out.println(totalDegrees);


    }
}
