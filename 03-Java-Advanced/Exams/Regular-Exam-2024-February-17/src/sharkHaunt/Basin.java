package sharkHaunt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basin {

    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (this.capacity > this.sharks.size()) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind) {
        return this.sharks.removeIf(shark -> shark.getKind().equals(kind));
    }

    public Shark getLargestShark() {
        return this.sharks.stream()
                .max(Comparator.comparing(Shark::getLength))
                .orElse(null);
    }

    public Shark getShark(String kind) {
        return this.sharks.stream()
                .filter(shark -> shark.getKind().equals(kind))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.sharks.size();
    }

    public int getAverageLength() {
        List<Integer> sharksLength = this.sharks.stream()
                .map(Shark::getLength)
                .collect(Collectors.toList());

        if (!sharksLength.isEmpty()) {
            Integer sum = sharksLength.stream().reduce(0, Integer::sum);
            return sum / sharksLength.size();
        }

        return 0;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Sharks in %s:", this.name));

        this.sharks.forEach(s -> {
            sb.append(System.lineSeparator());
            sb.append(s);
        });

        return sb.toString();
    }
}
