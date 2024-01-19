import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_DrumSet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());

        List<Integer> qualityOfDrums = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> copyQuality = new ArrayList<>(qualityOfDrums);

        String command = scanner.nextLine();

        while (!command.equals("Hit it again, Gabsy!") && savings > 0) {
            int hitPower = Integer.parseInt(command);

            for (int i = 0; i < qualityOfDrums.size(); i++) {
                qualityOfDrums.set(i, qualityOfDrums.get(i) - hitPower);
            }

            for (int i = 0; i < qualityOfDrums.size(); i++) {
                if (qualityOfDrums.get(i) <= 0) {
                    int price = copyQuality.get(i) * 3;

                    if (price < savings || price == 0) {
                        qualityOfDrums.set(i, copyQuality.get(i));
                        savings -= price;
                    } else {
                        qualityOfDrums.remove(i);
                        copyQuality.remove(i);
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (Integer qualityOfDrum : qualityOfDrums) {
            System.out.printf("%d ", qualityOfDrum);
        }

        System.out.printf("%nGabsy has %.2flv.", savings);
    }
}
