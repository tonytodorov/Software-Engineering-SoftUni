import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02_SoftUniParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guest = scanner.nextLine();

        Set<String> regularGuest = new TreeSet<>();
        Set<String> vipGuest = new TreeSet<>();

        while (!guest.equals("PARTY")) {
            char firstSign = guest.charAt(0);

            if (Character.isDigit(firstSign)) {
                vipGuest.add(guest);
            } else {
                regularGuest.add(guest);
            }

            guest = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            if (regularGuest.contains(command)) {
                regularGuest.remove(command);
            } else {
                vipGuest.remove(command);
            }

            command = scanner.nextLine();
        }

        int numberOfRegularGuests = regularGuest.size();
        int numberOfVipGuests = vipGuest.size();
        int totalGuests = numberOfRegularGuests + numberOfVipGuests;

        System.out.println(totalGuests);
        printSet(vipGuest);
        printSet(regularGuest);
    }
    
    
    public static void printSet(Set<String> set) {

        for (String entry: set) {
            System.out.println(entry);
        }
    }
}
