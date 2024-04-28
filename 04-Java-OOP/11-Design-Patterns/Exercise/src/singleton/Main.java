package singleton;

public class Main {

    public static void main(String[] args) {

        HashCode instance1 = HashCode.getInstance("Hello!");
        HashCode instance2 = HashCode.getInstance("Bye!");

        System.out.println(instance1.getPoint().hashCode());
        System.out.println(instance2.getPoint().hashCode());

    }
}
