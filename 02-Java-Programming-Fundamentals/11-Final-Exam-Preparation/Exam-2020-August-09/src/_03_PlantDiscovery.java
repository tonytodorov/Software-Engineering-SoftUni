import java.util.*;

public class _03_PlantDiscovery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> plants = new LinkedHashMap<>();
        Map<String, List<Double>> ratings = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String[] tokens = input.split("<->");
            String plant = tokens[0];
            String rarity = tokens[1];

            plants.put(plant, rarity);
        }

        copyMap(plants, ratings);

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {

            String[] tokens = command.split("[:\\s+]+[\\s+-]+");
            String operation = tokens[0];
            String plant = tokens[1];

            if (operation.equals("Rate")) {
                double rating = Double.parseDouble(tokens[2]);
                ratings.get(plant).add(rating);
            } else if (operation.equals("Update")) {
                String rarity = tokens[2];
                plants.put(plant, rarity);
            } else if (operation.equals("Reset")) {
                ratings.put(plant, new ArrayList<>());
            }

            command = scanner.nextLine();
        }

        List<Double> rateResult = calculateAverageRating(ratings);

        print(plants, rateResult);
    }

    public static void copyMap(Map<String, String> plants, Map<String, List<Double>> ratings) {

        for (Map.Entry<String, String> entry: plants.entrySet()) {
            ratings.put(entry.getKey(), new ArrayList<>());
        }
    }

    public static List<Double> calculateAverageRating(Map<String, List<Double>> ratings) {

        List<Double> rateResult = new ArrayList<>();

        for (Map.Entry<String, List<Double>> rate: ratings.entrySet()){

            double result = 0;
            int countNumbers = 0;

            for (Double rating: rate.getValue()) {
                result += rating;
                countNumbers += 1;
            }

            if (result != 0) {
                rateResult.add(result / countNumbers);
            } else {
                rateResult.add(0.00);
            }
        }

        return rateResult;
    }

    public static void print(Map<String, String> plants, List<Double> rateResult) {

        System.out.println("Plants for the exhibition:");

        int count = 0;

        for (Map.Entry<String, String> plant: plants.entrySet()) {
            System.out.printf("- %s; Rarity: %s; Rating: %.2f%n",
                    plant.getKey(),
                    plant.getValue(),
                    rateResult.get(count));
            count += 1;
        }
    }
}
