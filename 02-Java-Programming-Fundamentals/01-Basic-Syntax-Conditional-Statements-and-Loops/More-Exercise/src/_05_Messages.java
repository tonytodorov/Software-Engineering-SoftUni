import java.util.Scanner;

public class _05_Messages {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String letter = "";

        for (int i = 0; i < n; i++) {
            int code = Integer.parseInt(scanner.nextLine());

            if (code == 2){
                letter += "a";
            }else if (code == 22){
                letter += "b";
            }else if (code == 222){
                letter += "c";
            }else if (code == 3){
                letter += "d";
            }else if (code == 33){
               letter += "e";
            }else if (code == 333){
                letter += "f";
            }else if (code == 4){
                letter += "g";
            }else if (code == 44){
                letter += "h";
            }else if (code == 444){
                letter += "i";
            }else if (code == 5){
                letter += "j";
            }else if (code == 55){
                letter += "k";
            }else if (code == 555){
                letter += "l";
            }else if (code == 6){
                letter += "m";
            }else if (code == 66){
                letter += "n";
            }else if (code == 666){
                letter += "o";
            }else if (code == 7){
                letter += "p";
            }else if (code == 77){
                letter += "q";
            }else if (code == 777){
                letter += "r";
            }else if (code == 7777){
                letter += "s";
            }else if (code == 8){
                letter += "t";
            }else if (code == 88){
                letter += "u";
            }else if (code == 888){
                letter += "v";
            }else if (code == 9){
                letter += "w";
            }else if (code == 99){
                letter += "x";
            }else if (code == 999){
                letter += "y";
            }else if (code == 9999){
                letter += "z";
            }else if (code == 0){
                letter += " ";
            }
        }

        System.out.println(letter);
    }
}
