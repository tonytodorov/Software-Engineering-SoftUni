package traffic_lights;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int repeats = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < repeats; i++) {
            String[] result = new String[input.length];

            for (int j = 0; j < input.length; j++) {
                if (TrafficLights.getName(TrafficLights.RED).equals(input[j])) {
                    result[j] = TrafficLights.getName(TrafficLights.GREEN);
                } else if (TrafficLights.getName(TrafficLights.YELLOW).equals(input[j])) {
                    result[j] = TrafficLights.getName(TrafficLights.RED);
                } else  {
                    result[j] = TrafficLights.getName(TrafficLights.YELLOW);
                }
            }

            printArray(result);
            input = result;
        }
    }

    private static void printArray(String[] arr) {

        for (String currentElement : arr) {
            System.out.print(currentElement + " ");
        }

        System.out.println();
    }
}
