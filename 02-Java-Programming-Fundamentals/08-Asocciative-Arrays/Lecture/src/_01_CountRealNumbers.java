import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class _01_CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> number = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        TreeMap<Double, Integer> counts = new TreeMap<>();

        for (Double num: number) {
            if (!counts.containsKey(num)) {
                counts.put(num, 0);
            }

            counts.put(num, counts.get(num) + 1);
        }

        DecimalFormat df = new DecimalFormat("#.#####");

        for (Map.Entry<Double, Integer> entry: counts.entrySet()) {
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
