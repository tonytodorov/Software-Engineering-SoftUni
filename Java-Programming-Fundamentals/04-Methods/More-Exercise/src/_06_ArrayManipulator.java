import java.util.Arrays;
import java.util.Scanner;

public class _06_ArrayManipulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] text = command.split(" ");
            String operation = text[0];

            if (operation.equals("exchange")) {
                int index = Integer.parseInt(text[1]);
                numbers = exchangeArr(numbers, index);
            } else if (operation.equals("max")) {
                String evenOrOdd = text[1];
                int index = -1;

                if (evenOrOdd.equals("even")) {
                    index = maxEvenElement(numbers);
                } else if (evenOrOdd.equals("odd")){
                    index = maxOddElement(numbers);
                }

                if (index == -1) {
                    System.out.println("No matches");
                } else {
                    System.out.println(index);
                }

            } else if (operation.equals("min")) {
                String evenOrOdd = text[1];
                int index = -1;

                if (evenOrOdd.equals("even")) {
                    index = minEvenElement(numbers);
                } else if (evenOrOdd.equals("odd")) {
                    index = minOddElement(numbers);
                }

                if (index == -1) {
                    System.out.println("No matches");
                } else {
                    System.out.println(index);
                }

            } else if (operation.equals("first")) {
                int count = Integer.parseInt(text[1]);

                if (count > numbers.length) {
                    System.out.println("Invalid count");
                    command = scanner.nextLine();
                    continue;
                }

                String evenOrOdd = text[2];

                if (evenOrOdd.equals("even")) {
                    int[] firstNEvenElements = firstNEvenElements(numbers, count);
                    boolean isOnlyZeros = isOnlyNegativeElements(firstNEvenElements);

                    if (isOnlyZeros) {
                        int[] printEmptyArr = printEmptyArr(firstNEvenElements);
                        System.out.println(Arrays.toString(printEmptyArr));
                    } else {
                        firstNEvenElements = replaceElements(firstNEvenElements);
                        System.out.println(Arrays.toString(firstNEvenElements));
                    }
                } else if (evenOrOdd.equals("odd")) {
                    int[] firstNOddElements = firstNOddElements(numbers, count);
                    boolean isOnlyZeros = isOnlyNegativeElements(firstNOddElements);

                    if (isOnlyZeros) {
                        int[] printEmptyArr = printEmptyArr(firstNOddElements);
                        System.out.println(Arrays.toString(printEmptyArr));
                    } else {
                        firstNOddElements = replaceElements(firstNOddElements);
                        System.out.println(Arrays.toString(firstNOddElements));
                    }
                }
            } else if (operation.equals("last")) {
                int count = Integer.parseInt(text[1]);

                if (count > numbers.length) {
                    System.out.println("Invalid count");
                    command = scanner.nextLine();
                    continue;
                }

                String evenOrOdd = text[2];

                if (evenOrOdd.equals("even")) {
                    int[] lastNEvenElements = lastNEvenElements(numbers, count);
                    boolean isOnlyZeros = isOnlyNegativeElements(lastNEvenElements);

                    if (isOnlyZeros) {
                        int[] printEmptyArr = printEmptyArr(lastNEvenElements);
                        System.out.println(Arrays.toString(printEmptyArr));
                    } else {
                        lastNEvenElements = replaceElements(lastNEvenElements);
                        System.out.println(Arrays.toString(lastNEvenElements));

                    }

                } else if (evenOrOdd.equals("odd")) {
                    int[] lastNOddElements = lastNOddElements(numbers, count);
                    boolean isOnlyZeros = isOnlyNegativeElements(lastNOddElements);

                    if (isOnlyZeros) {
                        int[] printEmptyArr = printEmptyArr(lastNOddElements);
                        System.out.println(Arrays.toString(printEmptyArr));
                    } else {
                        lastNOddElements = replaceElements(lastNOddElements);
                        System.out.println(Arrays.toString(lastNOddElements));
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(numbers));
    }

    public static int[] exchangeArr(int[] numbers, int index) {

        if (index < 0 || index > numbers.length - 1) {
            System.out.println("Invalid index");
            return numbers;
        }

        int[] subArray = new int[numbers.length];

        int position = 0;

        for (int i = index + 1; i < numbers.length; i++) {
            subArray[position] = numbers[i];
            position++;
        }

        for (int i = 0; i <= index; i++) {
            subArray[position] = numbers[i];
            position++;
        }

        return subArray;
    }

    public static int maxEvenElement(int[] numbers) {

        int maxValue = Integer.MIN_VALUE;
        int maxEvenIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (numbers[i] >= maxValue) {
                    maxValue = numbers[i];
                    maxEvenIndex = i;
                }
            }
        }

        return maxEvenIndex;
    }

    public static int maxOddElement(int[] numbers) {

        int maxValue = Integer.MIN_VALUE;
        int maxOddIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                if (numbers[i] >= maxValue) {
                    maxValue = numbers[i];
                    maxOddIndex = i;
                }
            }
        }

        return maxOddIndex;
    }


    public static int minEvenElement(int[] numbers) {

        int minValue = Integer.MAX_VALUE;
        int minEvenIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (numbers[i] <= minValue) {
                    minValue = numbers[i];
                    minEvenIndex = i;
                }
            }
        }

        return minEvenIndex;
    }

    public static int minOddElement(int[] numbers) {

        int minValue = Integer.MAX_VALUE;
        int minOddIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                if (numbers[i] <= minValue) {
                    minValue = numbers[i];
                    minOddIndex = i;
                }
            }
        }

        return minOddIndex;
    }


    public static int[] firstNEvenElements(int[] numbers, int count) {

        int[] firstEvenElements = new int[count];
        Arrays.fill(firstEvenElements, -1);
        int countIndex = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                firstEvenElements[countIndex] = number;
                countIndex++;
            }

            if (countIndex > firstEvenElements.length - 1) {
                break;
            }
        }

        return firstEvenElements;
    }

    public static int[] firstNOddElements(int[] numbers, int count) {

        int[] firstOddElements = new int[count];
        Arrays.fill(firstOddElements, -1);
        int countIndex = 0;

        for (int number : numbers) {
            if (number % 2 != 0) {
                firstOddElements[countIndex] = number;
                countIndex++;
            }

            if (countIndex > firstOddElements.length - 1) {
                break;
            }
        }

        return firstOddElements;
    }


    public static int[] lastNEvenElements(int[] numbers, int count) {

        int[] lastEvenElements = new int[count];
        Arrays.fill(lastEvenElements, -1);
        int countIndex = 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] % 2 == 0) {
                lastEvenElements[countIndex] = numbers[i];
                countIndex++;
            }

            if (countIndex > lastEvenElements.length - 1) {
                break;
            }
        }

        return lastEvenElements;
    }


    public static int[] lastNOddElements(int[] numbers, int count) {

        int[] lastOddElements = new int[count];
        Arrays.fill(lastOddElements, -1);
        int countIndex = 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] % 2 != 0) {
                lastOddElements[countIndex] = numbers[i];
                countIndex++;
            }

            if (countIndex > lastOddElements.length - 1) {
                break;
            }
        }

        return lastOddElements;
    }

    public static boolean isOnlyNegativeElements(int[] array) {

        int count = 0;

        for (int number : array) {
            if (number == -1) {
                count++;
            }
        }

        return count == array.length;
    }

    public static int[] printEmptyArr(int[] array) {

        boolean isOnlyNegative = isOnlyNegativeElements(array);

        if (isOnlyNegative) {
            return new int[]{};
        }

        return array;
    }

    public static int[] replaceElements(int[] array) {

        int count = 0;

        for (int number : array) {
            if (number == -1) {
                count++;
            }
        }

        int[] result = new int[array.length - count];
        int index = 0;

        for (int i = 0; i < result.length; i++) {
            if (array[i] != 0) {
                result[index] = array[i];
                index++;
            }
        }

        return result;
    }
}
