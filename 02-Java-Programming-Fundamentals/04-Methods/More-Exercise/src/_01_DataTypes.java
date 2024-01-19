import java.util.Scanner;

public class _01_DataTypes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        if (dataType.equals("int")) {
            int num = Integer.parseInt(scanner.nextLine());
            int result = getData(num);
            System.out.println(result);
        } else if (dataType.equals("real")) {
            double num = Double.parseDouble(scanner.nextLine());
            double result = getData(num);
            System.out.printf("%.2f", result);
        } else {
            String text = scanner.nextLine();
            String result = getData(text);
            System.out.println(result);
        }

    }

    public static int getData(int num){
        return num * 2;
    }

    public static double getData(double num){
        return num * 1.5;
    }

    public static String getData(String text){
        return "$" + text + "$";
    }
}
