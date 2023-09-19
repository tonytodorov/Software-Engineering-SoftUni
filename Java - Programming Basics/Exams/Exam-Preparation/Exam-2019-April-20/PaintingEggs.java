import java.util.Scanner;

public class PaintingEggs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sizeOfEggs, paintOfEggs;
        int numberOfBatch;
        double price = 0.00;

        sizeOfEggs = scanner.nextLine();
        paintOfEggs = scanner.nextLine();
        numberOfBatch = Integer.parseInt(scanner.nextLine());

        if(paintOfEggs.equals("Red")){
            switch (sizeOfEggs) {
                case "Large":   price = numberOfBatch * 16; break;
                case "Medium":  price = numberOfBatch * 13; break;
                case "Small":   price = numberOfBatch * 9;  break;
            }
        }

        if(paintOfEggs.equals("Green")){
            switch (sizeOfEggs) {
                case "Large":   price = numberOfBatch * 12; break;
                case "Medium":  price = numberOfBatch * 9; break;
                case "Small":   price = numberOfBatch * 8;  break;
            }
        }

        if(paintOfEggs.equals("Yellow")){
            switch (sizeOfEggs) {
                case "Large":   price = numberOfBatch * 9; break;
                case "Medium":  price = numberOfBatch * 7; break;
                case "Small":   price = numberOfBatch * 5;  break;
            }
        }

        price = price - (price * 0.35);
        System.out.printf("%.2f leva.", price);
    }
}
