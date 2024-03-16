package solidLab.p05_DependencyInversion.p02_Worker;

public class Manager implements Worker {

    private String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println("I am work!");
    }
}
