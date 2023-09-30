import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MergingLists {

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

        int size = firstList.size() + secondList.size();
        List<Integer> result = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            result.add(0);
        }

        int smallestList = smallestList(firstList, secondList);

        for (int i = 0; i < smallestList; i++) {
            result.set(i + i, firstList.get(i));
            result.set(i + i + 1, secondList.get(i));
        }

        String text = biggestList(firstList, secondList);
        int count = 0;

        for (int i = (smallestList * 2); i < result.size(); i++) {

            if (text.equals("first")) {
                result.set(i, firstList.get(smallestList + count));
            } else {
                result.set(i, secondList.get(smallestList + count));
            }

            count++;
        }

        for (int num: result) {
            System.out.printf("%d ", num);
        }
    }


    public static int smallestList(List<Integer> firstList, List<Integer> secondList){
        return Math.min(firstList.size(), secondList.size());
    }

    public static String biggestList(List<Integer> firstList, List<Integer> secondList){

        if (firstList.size() > secondList.size()) {
            return "first";
        }

        return "second";
    }
}
