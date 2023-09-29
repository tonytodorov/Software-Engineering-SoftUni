import java.util.Random;
import java.util.Scanner;

public class ComplexTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        menu();
        int operation = Integer.parseInt(scanner.nextLine());

        if(operation == 1){
            System.out.println("Enter a number:");
            int number = Integer.parseInt(scanner.nextLine());
            System.out.printf("Reverse number is: %d", Integer.parseInt(reverseNumber(number)));
        }


        if(operation == 2){
            System.out.println("Enter array size:");
            int n = Integer.parseInt(scanner.nextLine());
            boolean isLengthValid = isLengthValid(n);

            if(isLengthValid){
                int[] array = new int[n];
                addElement(array);
                System.out.printf("Average of array: %.2f", averageValue(array));
            }else{
                System.out.println("Invalid length of array!");
            }
        }

        if(operation == 3){
            int a, b;
            System.out.println("Enter value for a:");
            a = Integer.parseInt(scanner.nextLine());

            if(isAPositive(a)){
                System.out.println("Enter value for b:");
                b = Integer.parseInt(scanner.nextLine());

                double result = linearEquation(a, b);
                System.out.printf("Result of x is: %.2f", result);

            }else{
                System.out.println("Invalid value for a!");
            }
        }
    }

    public static void menu(){
        System.out.println("Choose operation:");
        System.out.println("1. Reverse number");
        System.out.println("2. Average of numbers in array");
        System.out.println("3. Calculate a * x + b = 0");
    }

    public static String reverseNumber(int number){

        int lastDigit;
        String result = "";

        while (number > 0){
            lastDigit = number % 10;
            result += lastDigit;
            number /= 10;
        }

        return result;
    }

    public static boolean isLengthValid(int n){
        return n > 0;
    }

    public static void addElement(int[] array){

        Random random = new Random();
        int lowerBound = 1, upperBound = 31;

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(upperBound - lowerBound) + lowerBound;
        }
    }

    public static double averageValue(int[] array){

        int sum = 0;
        for (int num : array) {
            sum += num;
        }

        return 1.0 * sum / array.length;
    }

    public static boolean isAPositive(int a){
        return a > 0;
    }

    public static double linearEquation(int a, int b){

        double result;

        if(b > 0){
            result = 1.0 * - b / a;
        }else{
            result = 1.0 * b / a;
        }

        return result;
    }

}
