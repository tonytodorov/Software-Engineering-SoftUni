package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.capacity > this.data.size()) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(parrot -> parrot.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (null != parrot) {
            parrot.setAvailable(false);
        }

        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrotsBySpecies = this.data.stream()
                .filter(parrot -> parrot.getSpecies().equals(species))
                .collect(Collectors.toList());

        parrotsBySpecies.forEach(parrot -> parrot.setAvailable(false));

        return parrotsBySpecies;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        List<Parrot> notSoldParrots = this.data.stream()
                .filter(Parrot::isAvailable)
                .collect(Collectors.toList());

        return String.format("Parrots available at %s: %n%s", this.name,
                notSoldParrots.stream().
                        map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
