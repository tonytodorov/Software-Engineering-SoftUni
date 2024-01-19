import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09_PokemonDoNotGo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sumOfRemoveElements = 0;

        while (numbers.size() > 0) {

            int index = Integer.parseInt(scanner.nextLine());

            if (index >= 0 && index <= numbers.size() - 1) {
                int removeElement = numbers.get(index);
                sumOfRemoveElements += removeElement;
                numbers.remove(index);

                modifyList(numbers, removeElement);
            } else if (index < 0) {
                int removedElement = numbers.get(0);
                sumOfRemoveElements += removedElement;
                numbers.remove(0);

                int lastElement = numbers.get(numbers.size() - 1);
                numbers.add(0, lastElement);

                modifyList(numbers, removedElement);
            } else if (index > numbers.size() - 1){
                int removedElement = numbers.get(numbers.size() - 1);
                sumOfRemoveElements += removedElement;
                numbers.remove(numbers.size() - 1);

                int firstElement = numbers.get(0);
                numbers.add(firstElement);

                modifyList(numbers, removedElement);
            }

        }

        System.out.println(sumOfRemoveElements);
    }

    public static void modifyList(List<Integer> numbers, int removedNumber) {

        for (int i = 0; i < numbers.size(); i++) {
            int currentNum = numbers.get(i);

            if (numbers.get(i) <= removedNumber) {
                currentNum += removedNumber;
            } else {
                currentNum -= removedNumber;
            }

            numbers.set(i, currentNum);
        }
    }

}
