package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(elephant -> elephant.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return this.data.stream()
                .filter(elephant -> elephant.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }

    public Elephant getOldestElephant() {
        return this.data.stream()
                .max(Comparator.comparing(Elephant::getAge))
                .get();
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        return String.format("Saved elephants in the park: %n%s",
                this.data.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
