package fishingPond;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Pond {

    private int capacity;
    private List<Fish> fishes = new ArrayList<>();

    public Pond(int capacity) {
        this.capacity = capacity;
    }

    public void addFish(Fish fish) {
        if (this.fishes.size() < this.capacity) {
            fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        return this.fishes.removeIf(fish -> fish.getSpecies().equals(species));
    }

    public Fish getOldestFish() {
        return this.fishes.stream()
                .max(Comparator.comparing(Fish::getAge))
                .orElse(null);
    }

    public Fish getFish(String species) {
        return this.fishes.stream()
                .filter(fish -> fish.getSpecies().equals(species))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.fishes.size();
    }

    public int getVacancies() {
        return this.capacity - this.fishes.size();
    }

    public String report() {
        return String.format("Fishes in the pond: %n%s",
                this.fishes.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
