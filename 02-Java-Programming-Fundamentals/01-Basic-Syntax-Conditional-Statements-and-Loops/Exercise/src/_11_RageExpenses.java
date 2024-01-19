import java.util.Scanner;

public class _11_RageExpenses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int countTrashesHeadsets = 0,
                countTrashesMouse = 0,
                countTrashesKeyboards = 0,
                countTrashesDisplays = 0;

        for (int i = 1; i <= lostGames; i++) {

            if(i % 2 == 0){
                countTrashesHeadsets++;
            }
            if(i % 3 == 0){
                countTrashesMouse++;
            }
            if(i % 2 == 0 && i % 3 == 0) {
                countTrashesKeyboards++;
            }
        }

        countTrashesDisplays = countTrashesKeyboards / 2;

        double totalHeadsetPrice = countTrashesHeadsets * headsetPrice;
        double totalMousePrice = countTrashesMouse * mousePrice;
        double totalKeyboardPrice = countTrashesKeyboards * keyboardPrice;
        double totalDisplayPrice = countTrashesDisplays * displayPrice;

        double totalPrice = totalHeadsetPrice + totalMousePrice + totalKeyboardPrice + totalDisplayPrice;

        System.out.printf("Rage expenses: %.2f lv.", totalPrice);
    }
}
