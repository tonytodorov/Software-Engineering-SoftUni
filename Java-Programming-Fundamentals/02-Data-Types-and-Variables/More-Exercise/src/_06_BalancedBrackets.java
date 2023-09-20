import java.util.Scanner;

public class _06_BalancedBrackets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int countBrackets = 0;
        String currentBracket = "";

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            if(currentBracket.equals(text)){
                System.out.println("UNBALANCED");
                return;
            }

            if(text.equals("(") || text.equals(")")){
                countBrackets++;
                currentBracket = text;
            }

        }

        if(countBrackets % 2 == 0){
            System.out.println("BALANCED");
        }else{
            System.out.println("UNBALANCED");
        }
    }
}
