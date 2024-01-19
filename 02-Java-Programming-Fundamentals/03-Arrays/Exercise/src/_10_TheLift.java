import java.util.Arrays;
import java.util.Scanner;

public class _10_TheLift {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int countWagon = 0;
        boolean isSpaceEnough = false;

        while (countWagon < wagons.length){

          while (wagons[countWagon] < 4 && numberOfPeople > 0){
              wagons[countWagon] += 1;
              numberOfPeople--;
          }

          if (numberOfPeople == 0){
              isSpaceEnough = true;
              break;
          }

            countWagon++;
        }

        boolean isWagonsFull = true;

        for (int wagon : wagons) {
            if (wagon != 4) {
                isWagonsFull = false;
                break;
            }
        }

        if(isSpaceEnough && isWagonsFull){
            printArray(wagons);
            return;
        }else if(isSpaceEnough){
            System.out.println("The lift has empty spots!");
        }else{
            System.out.printf("There isn't enough space! %d people in a queue!%n", numberOfPeople);
        }

        printArray(wagons);

    }

    public static void printArray(int[] wagons){
        for (int wagon: wagons) {
            System.out.printf("%d ", wagon);
        }
    }
}
