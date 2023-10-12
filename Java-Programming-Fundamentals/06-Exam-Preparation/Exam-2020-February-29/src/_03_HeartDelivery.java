import java.util.Scanner;

public class _03_HeartDelivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String[] result = command.split("@");
        int[] numbers = new int[result.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(result[i]);
        }

        String operation = scanner.nextLine();
        int index = 0;

        while (!operation.equals("Love!")) {

            String[] token = operation.split(" ");
            int jump = Integer.parseInt(token[1]);

            index += jump;

            if (index > numbers.length - 1) {
                index = 0;

                if (numbers[index] == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", index);
                } else {
                  decreaseHearts(numbers, index);
                }
            } else {
                decreaseHearts(numbers, index);
            }

            operation = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", index);

        boolean isValentineDay = isValentineDay(numbers);

        if (isValentineDay) {
            System.out.println("Mission was successful.");
        } else {
            int houses = positiveHearts(numbers);
            System.out.printf("Cupid has failed %d places.", houses);
        }
    }

    public static void decreaseHearts(int[] numbers, int index) {

        numbers[index] -= 2;

        if (numbers[index] == 0) {
            System.out.printf("Place %d has Valentine's day.%n", index);
        }

    }

    public static boolean isValentineDay(int[] numbers) {

        for (int number : numbers) {
            if (number != 0) {
                return false;
            }
        }

        return true;
    }


    public static int positiveHearts(int[] numbers) {

        int count = 0;

        for (int number : numbers) {
            if (number != 0) {
                count++;
            }
        }

        return count;
    }

}
