import java.util.Scanner;

public class BonusScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        double bonusScore, addedBonusScore = 0;
        number = scanner.nextInt();

        if(number <= 100){
            bonusScore = 5;
        }else if(number < 1000){
            bonusScore = number * 0.2;
        }else {
            bonusScore = number * 0.1;
        }

        if(number % 2 == 0){
            addedBonusScore = 1;
        }else if (number % 5 == 0){
            addedBonusScore = 2;
        }

        System.out.println(bonusScore + addedBonusScore);
        System.out.println(number + bonusScore + addedBonusScore);

    }
}
