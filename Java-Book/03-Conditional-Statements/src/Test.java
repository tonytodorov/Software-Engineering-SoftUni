import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day;
        day = scanner.nextInt();

        if(day >= 1 && day <= 31){
            day += 5;
            if(day < 10){
                System.out.printf("Next day is: %02d", day);
            }else{
                System.out.printf("Next day is: %d", day);
            }
        }else{
            System.out.println("Error");
        }
    }
}
