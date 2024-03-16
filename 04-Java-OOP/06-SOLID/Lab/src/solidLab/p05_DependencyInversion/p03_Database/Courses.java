package solidLab.p05_DependencyInversion.p03_Database;

public class Courses {

    private Data database;

    public void printAll() {
        database.courseNames().forEach(System.out::println);
    }

    public void printIds() {
        database.courseIds().forEach(System.out::println);
    }

    public void printById(int id) {
        System.out.println(database.getCourseById(id));
    }

    public void search(String substring) {
        database.search(substring).forEach(System.out::println);
    }
}
