package kindergarten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.registry.size() < this.capacity) {
            return this.registry.add(child);
        }

        return false;
    }

    public boolean removeChild(String firstName) {
        return this.registry.removeIf(child -> child.getFirstName().equals(firstName));
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        return this.registry.stream()
                .filter(child -> child.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
    }

    public String registryReport() {

        registry.sort(Comparator
                .comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));

        return String.format("Registered children in %s:%n%s",
                this.name,
                this.registry.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
