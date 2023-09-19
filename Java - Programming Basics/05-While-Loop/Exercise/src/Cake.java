import java.util.Scanner;

public class Cake {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        int width, length, numberOfCakes, takenCakes;
        width = Integer.parseInt(scanner.nextLine());
        length = Integer.parseInt(scanner.nextLine());
        boolean isCakeFinish = false;

        numberOfCakes = width * length;
        command = scanner.nextLine();

        while(!command.equals("STOP")){
            takenCakes = Integer.parseInt(command);
            numberOfCakes -= takenCakes;

            if(numberOfCakes <= 0){
                isCakeFinish = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (isCakeFinish){
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(numberOfCakes));
        }else{
            System.out.printf("%d pieces are left.", numberOfCakes);
        }

    }
}
