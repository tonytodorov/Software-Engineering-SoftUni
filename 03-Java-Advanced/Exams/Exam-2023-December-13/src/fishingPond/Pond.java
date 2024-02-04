package fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {

    private int capacity;
    private List<Fish> fishes = new ArrayList<>();

    public Pond(int capacity) {
        this.capacity = capacity;
    }

    public void addFish(Fish fish) {
        if (fishes.size() <= capacity) {
            fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        for (Fish fish: fishes) {
            if (fish.getSpecies().equals(species)) {
                fishes.remove(fish);
                return true;
            }
        }

        return false;
    }

    public String getOldestFish() {
        int oldestFish = Integer.MIN_VALUE;
        String fishName = "";

        for (Fish fish : fishes) {
            int currentFishAge = fish.getAge();

            if (currentFishAge > oldestFish) {
                oldestFish = currentFishAge;
                fishName = fish.getSpecies();
            }
        }

        return fishName;
    }

    public String getFish(String species) {
        for (Fish fish: fishes) {
            if (fish.getSpecies().equals(species)) {
                return fish.getSpecies() + " " + fish.getAge() + " " + fish.getMatingSeason();
            }
        }

        return "";
    }

    public int getCount() {
        return fishes.size();
    }

    public int getVacancies() {
        return capacity - fishes.size();
    }

    public void report() {
        System.out.println("Fishes in the pond:");

        for (Fish fish: fishes) {
            System.out.printf("This %s is %d years old and reproduces through %s.%n",
                    fish.getSpecies(), fish.getAge(), fish.getMatingSeason());
        }
    }
}
