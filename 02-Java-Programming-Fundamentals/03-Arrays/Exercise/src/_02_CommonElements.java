import java.util.Scanner;

public class _02_CommonElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        String[] result = new String[firstArray.length];
        int count = 0;

        for (int i = 0; i < secondArray.length; i++) {
            for (int j = 0; j < firstArray.length; j++) {
                if(secondArray[i].equals(firstArray[j])){
                    result[count] = secondArray[i];
                    count++;
                }
            }
        }

        for (String value: result) {
            if(value != null){
                System.out.printf("%s ", value);
            }
        }

    }
}
