package magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Magazine {

    private List<Cloth> data;
    private String type;
    private int capacity;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < this.capacity) {
            data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        return data.removeIf(cloth -> cloth.getColor().equals(color));
    }

    public Cloth getSmallestCloth() {
        return data.stream()
                .min(Comparator.comparingInt(Cloth::getSize))
                .orElse(null);
    }

    public Cloth getCloth(String color) {
        return data.stream()
                .filter(cloth -> cloth.getColor().equals(color))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        return String.format("%s magazine contains:%n%s",
                this.type,
                data.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(System.lineSeparator())));
    }
}
