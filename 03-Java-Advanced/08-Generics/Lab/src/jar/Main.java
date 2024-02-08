package jar;

public class Main {

    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<>();

        jar.add(43);
        jar.add(97);
        jar.add(18);

        System.out.println(jar.remove());
    }
}
