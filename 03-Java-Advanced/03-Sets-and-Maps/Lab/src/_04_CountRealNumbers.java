import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        for (Double currentNumber : input) {

            if (!numbers.containsKey(currentNumber)) {
                numbers.put(currentNumber, 0);
            }

            numbers.put(currentNumber, numbers.get(currentNumber) + 1);
        }

        for (Map.Entry<Double, Integer> num: numbers.entrySet()) {
            System.out.printf("%.1f -> %d%n", num.getKey(), num.getValue());
        }
    }
}
