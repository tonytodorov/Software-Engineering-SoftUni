import java.util.Scanner;

public class _08_BeerKegs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double currentResult = Double.MIN_VALUE;
        String bestModel = "";

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double result = Math.PI * Math.pow(radius, 2) * height;

            if(result > currentResult){
                currentResult = result;
                bestModel = model;
            }
        }

        System.out.println(bestModel);
    }
}
