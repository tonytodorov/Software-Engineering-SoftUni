import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_PhoneShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phones = Arrays.stream(scanner.nextLine()
                .split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] tokens = command.split(" - ");
            String operation = tokens[0];
            String phone = tokens[1];

            if (operation.equals("Add")) {

                boolean isPhoneExisting = isPhoneExisting(phones, phone);

                if (!isPhoneExisting) {
                    phones.add(phone);
                }
            } else if (operation.equals("Remove")) {
                boolean isPhoneExisting = isPhoneExisting(phones, phone);

                if (isPhoneExisting) {
                    phones.remove(phone);
                }
            } else if (operation.equals("Bonus phone")) {
                String[] splitOldAndNewPhone = phone.split(":");

                String oldPhone = splitOldAndNewPhone[0];
                String newPhone = splitOldAndNewPhone[1];

                boolean isOldPhoneExisting = isPhoneExisting(phones, oldPhone);

                if (isOldPhoneExisting) {
                    int index = getPhoneIndex(phones, oldPhone);
                    phones.add(index + 1, newPhone);
                }
            } else if (operation.equals("Last")) {
                boolean isPhoneExisting = isPhoneExisting(phones, phone);

                if (isPhoneExisting) {
                    int index = getPhoneIndex(phones, phone);
                    String temp = phones.get(index);

                    phones.remove(phone);
                    phones.add(temp);
                }
            }

            command = scanner.nextLine();
        }

        printList(phones);
    }


    public static boolean isPhoneExisting(List<String> phones, String phone) {

        for (String element : phones) {
            if (element.equals(phone)) {
                return true;
            }
        }

        return false;
    }

    public static int getPhoneIndex(List<String> phones, String phone) {

        int index = 0;

        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).equals(phone)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static void printList(List<String> phones) {

        for (int i = 0; i < phones.size(); i++) {
            System.out.printf("%s", phones.get(i));

            if (i < phones.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
