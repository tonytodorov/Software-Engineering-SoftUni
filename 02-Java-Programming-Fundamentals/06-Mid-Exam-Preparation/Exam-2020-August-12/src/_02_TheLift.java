import java.util.Arrays;
import java.util.Scanner;

public class _02_TheLift {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isNoMorePeopleLeft = false;

        for (int i = 0; i < wagons.length; i++) {
            while (wagons[i] < 4 && numberOfPeople > 0) {
                wagons[i] += 1;
                numberOfPeople--;
            }

            if (numberOfPeople <= 0) {
                isNoMorePeopleLeft = true;
                break;
            }
        }

        if (isNoMorePeopleLeft) {
            boolean isWagonsFull = isWagonsFull(wagons);
            if (!isWagonsFull) {
                System.out.println("The lift has empty spots!");
            }
        } else {
            System.out.printf("There isn't enough space! %d people in a queue!%n", numberOfPeople);
        }

        printArr(wagons);
    }

    public static void printArr(int[] array){

        for (int wagons : array) {
            System.out.printf("%d ", wagons);
        }
    }

    public static boolean isWagonsFull(int[] array) {
        for (int wagons : array) {
            if (wagons != 4) {
                return false;
            }
        }

        return true;
    }
}
