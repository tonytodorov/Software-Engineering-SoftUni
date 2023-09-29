import java.util.Scanner;

public class GreaterOfTwoValues {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        menu();
        String choose = scanner.nextLine();

        if(choose.equals("int")){
            int n1, n2;
            n1 = Integer.parseInt(scanner.nextLine());
            n2 = Integer.parseInt(scanner.nextLine());

            int result = compareIntegers(n1, n2);
            System.out.println(result);
        }

        if(choose.equals("char")){
            String v1, v2;
            v1 = scanner.nextLine();
            v2 = scanner.nextLine();
            char r1 = v1.charAt(0);
            char r2 = v2.charAt(0);
            char result = compareChars(r1, r2);
            System.out.println(result);
        }

        if(choose.equals("string")){
            String firstText, secondText;
            firstText = scanner.nextLine();
            secondText = scanner.nextLine();

            String result = compareStrings(firstText, secondText);
            System.out.println(result);
        }
    }

    public static void menu(){
        System.out.println("Choose types for comparing:");
        System.out.println("1. int");
        System.out.println("2. char");
        System.out.println("3. string");
    }

    public static int compareIntegers(int n1, int n2){
        return Math.max(n1, n2);
    }

    public static char compareChars(char v1, char v2){

        if(v1 > v2){
            return v1;
        }

        return v2;
    }

    public static String compareStrings(String firstText, String secondText){

        char v1 = firstText.charAt(0);
        char v2 = secondText.charAt(0);

        if(v1 > v2){
            return firstText;
        }

        return secondText;
    }

}
