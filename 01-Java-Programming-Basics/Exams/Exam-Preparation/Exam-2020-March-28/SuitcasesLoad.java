import java.util.Scanner;

public class SuitcasesLoad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = 0;
        double trunkCapacity, volumeOfCase;
        trunkCapacity = Double.parseDouble(scanner.nextLine());
        boolean isSpaceEnough = false;

        String command;
        command = scanner.nextLine();

        while (!command.equals("End")){
            volumeOfCase = Double.parseDouble(command);
            if (numberOfCases == 3){
                volumeOfCase = (volumeOfCase * 0.1) + volumeOfCase;
            }

            trunkCapacity -= volumeOfCase;

            if(trunkCapacity < 0){
                isSpaceEnough = true;
                break;
            }
            numberOfCases++;
            command = scanner.nextLine();
        }

        if(isSpaceEnough){
            System.out.printf("No more space!%nStatistic: %d suitcases loaded.", numberOfCases);
        }else{
            System.out.printf("Congratulations! All suitcases are loaded!%nStatistic: %d suitcases loaded.", numberOfCases);
        }
    }
}
