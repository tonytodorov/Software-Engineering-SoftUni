import java.util.Scanner;

public class PersonalTitle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double age;
        String gender;

        age = Double.parseDouble(scanner.nextLine());
        gender = scanner.nextLine();

        if(age >= 16 && gender.equals("m")){
            System.out.println("Mr.");
        }else if(age < 16 && gender.equals("m")){
            System.out.println("Master");
        }else if(age >= 16 && gender.equals("f")){
            System.out.println("Ms.");
        }else{
            System.out.println("Miss");
        }
    }
}
