import java.util.Scanner;

public class EasterShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantityOfEggsInShop, numberOfEggs, countSoldEggs = 0;
        String command;
        boolean isEggsEnd = false;

        quantityOfEggsInShop = Integer.parseInt(scanner.nextLine());
        command = scanner.nextLine();

        while (!command.equals("Close")){
            numberOfEggs = Integer.parseInt(scanner.nextLine());

            if(command.equals("Fill")){
                quantityOfEggsInShop += numberOfEggs;
            }

            if(numberOfEggs > quantityOfEggsInShop){
                isEggsEnd = true;
                break;
            }

            if(command.equals("Buy")){
                countSoldEggs += numberOfEggs;
                quantityOfEggsInShop -= numberOfEggs;
            }

            command = scanner.nextLine();
        }

        if(isEggsEnd){
            System.out.printf("Not enough eggs in store!%nYou can buy only %d.", quantityOfEggsInShop);
        }else{
            System.out.printf("Store is closed!%n%d eggs sold.", countSoldEggs);
        }


    }
}
