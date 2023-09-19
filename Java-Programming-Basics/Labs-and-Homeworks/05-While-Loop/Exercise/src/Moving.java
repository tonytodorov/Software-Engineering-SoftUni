import java.util.Scanner;

public class Moving {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        int width, length, height, numberOfBoxes, sum = 0;
        width = Integer.parseInt(scanner.nextLine());
        length = Integer.parseInt(scanner.nextLine());
        height = Integer.parseInt(scanner.nextLine());
        boolean isFreeSpaceFinish = false;

        int totalFreeSpace = width * length * height;

        command = scanner.nextLine();

        while (!command.equals("Done")){
            numberOfBoxes = Integer.parseInt(command);
            sum += numberOfBoxes;

            if (sum > totalFreeSpace){
                isFreeSpaceFinish = true;
                break;
            }

            command = scanner.nextLine();
        }

        if(isFreeSpaceFinish){
            System.out.printf("No more free space! You need %d Cubic meters more.", sum - totalFreeSpace);
        }else{
            System.out.printf("%d Cubic meters left.", totalFreeSpace - sum);
        }

    }
}
