import java.util.Scanner;

public class Everest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        int meters, startingMeters = 5364, neededMeters = 8848, countDays = 1;
        boolean isReached = false;

        command = scanner.nextLine();

        while (!command.equals("END")){
            meters = Integer.parseInt(scanner.nextLine());

            if(command.equals("Yes")){
                countDays++;
            }

            if(countDays > 5){
                break;
            }


            startingMeters += meters;

            if(startingMeters >= neededMeters){
                isReached = true;
                break;
            }

            command = scanner.nextLine();
        }

        if(isReached){
            System.out.printf("Goal reached for %d days!", countDays);
        }else{
            System.out.printf("Failed!%n%d", startingMeters);
        }

    }
}
