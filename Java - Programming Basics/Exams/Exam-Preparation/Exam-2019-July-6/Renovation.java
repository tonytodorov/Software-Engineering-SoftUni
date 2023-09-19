import java.util.Scanner;

public class Renovation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        int height, width, percentForNoPainting, totalSpace, number;
        double wallForPainting;
        boolean isPainting = false;
        boolean isPaintEnough = false;
        height = Integer.parseInt(scanner.nextLine());
        width = Integer.parseInt(scanner.nextLine());
        percentForNoPainting = Integer.parseInt(scanner.nextLine());

        totalSpace = height * width * 4;
        wallForPainting = Math.ceil(totalSpace - (1.0 * totalSpace * percentForNoPainting / 100));

        command = scanner.nextLine();

        while (!command.equals("Tired!")){
            number = Integer.parseInt(command);
            wallForPainting -= number;

            if(wallForPainting < 0){
                isPainting = true;
                break;
            }

            if(wallForPainting == 0){
                isPaintEnough = true;
                break;
            }


            command = scanner.nextLine();
        }

        if(isPainting){
            System.out.printf("All walls are painted and you have %.0f l paint left!", Math.abs(wallForPainting));
        }else if(isPaintEnough){
            System.out.println("All walls are painted! Great job, Pesho!");
        } else{
            System.out.printf("%.0f quadratic m left.", wallForPainting);
        }

    }
}
