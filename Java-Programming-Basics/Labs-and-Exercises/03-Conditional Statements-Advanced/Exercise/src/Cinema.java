import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfProject;
        int row, column, totalPeople;
        double price = 0;

        typeOfProject = scanner.nextLine();
        row = Integer.parseInt(scanner.nextLine());
        column = scanner.nextInt();

        totalPeople = row * column;

        if(typeOfProject.equals("Premiere")){
            price = totalPeople * 12;
        }else if(typeOfProject.equals("Normal")){
            price = totalPeople * 7.5;
        }else{
            price = totalPeople * 5;
        }

        System.out.printf("%.2f leva", price);
    }
}
