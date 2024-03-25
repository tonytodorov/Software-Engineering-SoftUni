package aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.fishInPool.size() < this.capacity && !this.fishInPool.contains(fish)) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        return this.fishInPool.removeIf(fish -> fish.getName().equals(name));
    }

    public Fish findFish(String name) {
        return this.fishInPool.stream()
                .filter(fish -> fish.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String report() {
        return String.format("Aquarium: %s ^ Size: %d%n%s", this.name, this.size,
                this.fishInPool.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
