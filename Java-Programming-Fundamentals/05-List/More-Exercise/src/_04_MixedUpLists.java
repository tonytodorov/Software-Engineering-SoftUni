import java.util.*;
import java.util.stream.Collectors;

public class _04_MixedUpLists {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String biggestList = biggestList(firstList, secondList);

        List<Integer> mixedList = mixedLists(firstList, secondList);
        List<Integer> constraints = new ArrayList<>(firstList);

        if (biggestList.equals("first")) {
            constraints.addAll(firstList);
        } else {
            constraints.addAll(secondList);
        }

        int lowerBound, upperBound;

        if (constraints.get(0) > constraints.get(1)) {
            lowerBound = constraints.get(1);
            upperBound = constraints.get(0);
        } else {
            lowerBound = constraints.get(0);
            upperBound = constraints.get(1);
        }

        List<Integer> result = elementsInRange(mixedList, lowerBound, upperBound);
        Collections.sort(result);

        printElements(result);
    }


    public static String biggestList(List<Integer> firstList, List<Integer> secondList) {

        String result = "";

        if (firstList.size() - 1 > secondList.size() - 1) {
            result = "first";
        } else {
            result = "second";
        }

        return result;
    }


    public static List<Integer> mixedLists(List<Integer> firstList, List<Integer> secondList) {

        List<Integer> mixedLists = new ArrayList<>();

        String biggestList = biggestList(firstList, secondList);

        if (biggestList.equals("first")) {
            while (secondList.size() > 0) {
                mixedLists.add(firstList.get(0));
                mixedLists.add(secondList.get(secondList.size() - 1));

                firstList.remove(0);
                secondList.remove(secondList.size() - 1);
            }
        } else {
            while (firstList.size() > 0) {
                mixedLists.add(firstList.get(0));
                mixedLists.add(secondList.get(secondList.size() - 1));

                firstList.remove(0);
                secondList.remove(secondList.size() - 1);
            }
        }

        return mixedLists;
    }

    public static List<Integer> elementsInRange(List<Integer> mixedLists, int lowerBound, int upperBound) {

        List<Integer> result = new ArrayList<>();

        for (Integer element : mixedLists) {
            if (element > lowerBound && element < upperBound) {
                result.add(element);
            }
        }

        return result;
    }

    public static void printElements(List<Integer> result) {

        for (Integer element : result) {
            System.out.printf("%d ", element);
        }
    }


}
