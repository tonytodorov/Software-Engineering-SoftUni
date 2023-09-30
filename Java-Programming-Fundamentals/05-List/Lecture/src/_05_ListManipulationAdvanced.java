import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_ListManipulationAdvanced {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] text = command.split(" ");
            String operation = text[0];

            if (operation.equals("Contains")) {
                int number = Integer.parseInt(text[1]);
                boolean isElementContains = isElementContains(numbers, number);

                if (isElementContains) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (operation.equals("Print")) {
                String typeOfNumbers = text[1];

                if (typeOfNumbers.equals("even")) {
                    List<Integer> evenNumbers = evenNumbers(numbers);
                    printElements(evenNumbers);
                } else {
                    List<Integer> oddNumbers = oddNumbers(numbers);
                    printElements(oddNumbers);
                }
            } else if (operation.equals("Get")) {
                int sum = sumOfElements(numbers);
                System.out.println(sum);
            } else {
                String condition = text[1];
                int number = Integer.parseInt(text[2]);

                if (condition.equals("<")) {
                    List<Integer> smallerElements = smallerElements(numbers, number);
                    printElements(smallerElements);
                } else if (condition.equals(">")) {
                    List<Integer> greaterElements = greaterElements(numbers, number);
                    printElements(greaterElements);
                } else if (condition.equals(">=")) {
                    List<Integer> greaterOrEqualsElements = greaterOrEqualsElements(numbers, number);
                    printElements(greaterOrEqualsElements);
                } else {
                    List<Integer> smallestOrEqualsElements = smallestOrEqualsElements(numbers, number);
                    printElements(smallestOrEqualsElements);
                }
            }


            command = scanner.nextLine();
        }
    }

    public static boolean isElementContains(List<Integer> numbers, int containsNumber) {

        for (Integer number : numbers) {
            if (number.equals(containsNumber)) {
                return true;
            }
        }

        return false;
    }

    public static List<Integer> evenNumbers(List<Integer> numbers) {

        List<Integer> evenNumbers = new ArrayList<>(numbers.size());

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        return evenNumbers;
    }

    public static List<Integer> oddNumbers(List<Integer> numbers) {

        List<Integer> oddNumbers = new ArrayList<>(numbers.size());
        for (Integer number: numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }

        return oddNumbers;
    }

    public static int sumOfElements(List<Integer> numbers) {

        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }


    public static List<Integer> smallerElements(List<Integer> numbers, int number) {

        List<Integer> smallerElements = new ArrayList<>(numbers.size());

        for (Integer integer : numbers) {
            if (integer < number) {
                smallerElements.add(integer);
            }
        }

        return smallerElements;
    }


    public static List<Integer> greaterElements(List<Integer> numbers, int number) {

        List<Integer> greaterElements = new ArrayList<>(numbers.size());

        for (Integer integer : numbers) {
            if (integer > number) {
                greaterElements.add(integer);
            }
        }

        return greaterElements;
    }

    public static List<Integer> greaterOrEqualsElements(List<Integer> numbers, int number) {

        List<Integer> greaterOrEqualsElements = new ArrayList<>(numbers.size());

        for (Integer integer : numbers) {
            if (integer >= number) {
                greaterOrEqualsElements.add(integer);
            }
        }

        return greaterOrEqualsElements;
    }

    public static List<Integer> smallestOrEqualsElements(List<Integer> numbers, int number) {

        List<Integer> smallestOrEqualsElements = new ArrayList<>(numbers.size());

        for (Integer integer : numbers) {
            if (integer <= number) {
                smallestOrEqualsElements.add(integer);
            }
        }

        return smallestOrEqualsElements;
    }

    public static void printElements(List<Integer> numbers) {

        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }

        System.out.println();
    }
}
