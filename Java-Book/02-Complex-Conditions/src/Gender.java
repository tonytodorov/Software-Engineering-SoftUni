import java.util.Scanner;

public class Gender {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double age;
        String gender;

        age = Double.parseDouble(scanner.nextLine());
        gender = scanner.nextLine();

        if(gender.equals("m") && age >= 16){
            System.out.println("Mr.");
        }else if(gender.equals("m") && age < 16){
            System.out.println("Master");
        }else if(gender.equals("f") && age >= 16){
            System.out.println("Ms.");
        }else{
            System.out.println("Miss");
        }
    }
}
