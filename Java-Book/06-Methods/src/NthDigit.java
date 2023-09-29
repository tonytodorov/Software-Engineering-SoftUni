import java.util.Scanner;

public class NthDigit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number, index;
        number = Integer.parseInt(scanner.nextLine());
        index = Integer.parseInt(scanner.nextLine());

        int result = findNthDigit(number, index);
        System.out.println(result);
    }


    public static int findNthDigit(int number, int index){

        int countIndex = 0;

        while (number > 0){
            countIndex++;
            int lastDigit = number % 10;

            if(countIndex == index){
                return lastDigit;
            }

            number /= 10;
        }

        return -1;
    }
}
