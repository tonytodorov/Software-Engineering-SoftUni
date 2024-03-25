package fishingPond;

public class Main {

    public static void main(String[] args) {

        Pond pond = new Pond(5);

        Fish trout = new Fish("Trout", 5, "winter");
        Fish perch = new Fish("Perch", 2, "summer");
        Fish pike = new Fish("Pike", 4, "spring");
        Fish catfish = new Fish("Catfish", 8, "summer");

        // Add fish
        pond.addFish(trout);
        pond.addFish(perch);
        pond.addFish(pike);
        pond.addFish(catfish);

        // Remove fish
        System.out.println(pond.removeFish("Trout"));
        System.out.println(pond.removeFish("Carp"));

        // Get property
        System.out.println(pike.getMatingSeason());

        // Get the oldest fish
        System.out.println(pond.getOldestFish());

        // Return fish
        System.out.println(pond.getFish("Catfish"));

        // Get count
        System.out.println(pond.getCount());

        // Pond vacancies
        System.out.println(pond.getVacancies());

        // Report
        System.out.println(pond.report());
    }
}
