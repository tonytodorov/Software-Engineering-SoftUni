import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_CarRace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int middle = input.size() / 2;

        int[] firstRacerTime = new int[input.size() / 2];
        int[] secondRacerTime = new int[input.size() / 2];

        for (int i = 0; i < firstRacerTime.length; i++) {
            firstRacerTime[i] = input.get(i);
        }

        for (int i = 0; i < secondRacerTime.length; i++) {
            secondRacerTime[i] = input.get(middle + i + 1);
        }


        double firstRacerSum = 0.00;
        int countZeros = 0;

        for (Integer currentTime : firstRacerTime) {

            if (currentTime == 0 && countZeros < 1) {
                countZeros += 1;
                firstRacerSum *= 0.8;
            }

            firstRacerSum += currentTime;
        }

        countZeros = 0;
        double secondRacerSum = 0.00;

        for (int i = secondRacerTime.length - 1; i >= 0; i--) {

            if (secondRacerTime[i] == 0 && countZeros < 1) {
                countZeros += 1;
                secondRacerSum *= 0.8;
            }

            secondRacerSum += secondRacerTime[i];
        }

        if (firstRacerSum < secondRacerSum) {
            System.out.printf("The winner is left with total time: %.1f", firstRacerSum);
        } else {
            System.out.printf("The winner is right with total time: %.1f", secondRacerSum);
        }
    }
}
