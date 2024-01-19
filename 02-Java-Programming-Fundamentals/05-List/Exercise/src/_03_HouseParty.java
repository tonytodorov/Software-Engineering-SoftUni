import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_HouseParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> guests = new ArrayList<>();

        boolean isGuestOnTheList = false;
        boolean isNameOnTheList = false;

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");

            String name = command[0];
            String going = command[1] + " " + command[2];

            if (going.equals("is going!")) {
                for (String guest : guests) {
                    if (guest.equals(name)) {
                        isGuestOnTheList = true;
                        break;
                    }
                }

                if(isGuestOnTheList){
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guests.add(name);
                }

                isGuestOnTheList = false;
            } else {
                for (int j = 0; j < guests.size(); j++) {
                    if (guests.get(j).equals(name)) {
                        isNameOnTheList = true;
                        guests.remove(j);
                        break;
                    }
                }

                if(!isNameOnTheList) {
                    System.out.printf("%s is not in the list!%n", name);
                }

                isNameOnTheList = false;
            }
        }

        for (String guest: guests) {
            System.out.println(guest);
        }

    }
}
