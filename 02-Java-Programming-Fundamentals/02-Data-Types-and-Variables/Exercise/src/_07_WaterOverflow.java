import java.util.Scanner;

public class _07_WaterOverflow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(scanner.nextLine());

            sum += liters;

            if(sum > capacity){
                System.out.println("Insufficient capacity!");
                sum -= liters;
            }
        }

        System.out.println(sum);
    }
}
