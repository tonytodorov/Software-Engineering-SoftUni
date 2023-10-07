import java.util.Scanner;

public class _05_KaminoFactory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sequenceLength = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        int bestLength = 0;
        String bestDna = "";

        int bestIndex = 0;
        int bestSum = 0;

        int countDna = 0;
        int bestCountDna = 0;

        while (!line.equals("Clone them!")) {

            countDna++;

            String sequence = line.replaceAll("!", "");
            String[] dnas = sequence.split("0");

            int maxLength = 0;
            int sum = 0;
            String bestLocalDna = "";

            for (int i = 0; i < dnas.length; i++) {
                if (dnas[i].length() > maxLength) {
                    maxLength = dnas[i].length();
                    bestLocalDna = dnas[i];
                }
                sum += dnas[i].length();
            }

            int beginIndex = sequence.indexOf(bestLocalDna);

            if (maxLength > bestLength) {
                bestLength = maxLength;
                bestDna = sequence;
                bestIndex = beginIndex;
                bestSum = sum;
                bestCountDna = countDna;
            } else if (maxLength == bestLength &&
                    (beginIndex < bestIndex || sum > bestSum)) {
                bestDna = sequence;
                bestIndex = beginIndex;
                bestSum = sum;
                bestCountDna = countDna;
            } else if (countDna == 1) {
                bestLength = maxLength;
                bestDna = sequence;
                bestIndex = beginIndex;
                bestSum = sum;
                bestCountDna = countDna;
            }

            line = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestCountDna, bestSum);

        for (int i = 0; i < bestDna.length(); i++) {
            System.out.print(bestDna.charAt(i) + " ");
        }
    }
}
