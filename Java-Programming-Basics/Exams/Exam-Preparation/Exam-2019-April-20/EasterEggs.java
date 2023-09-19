import java.util.Scanner;

public class EasterEggs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEggs, countRedEggs = 0, countOrangeEggs = 0,
                countBlueEggs = 0, countGreenEggs = 0, maxEggs = Integer.MIN_VALUE;
        String colorOfEgg, colorOfMaxEgg = "";
        numberOfEggs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfEggs; i++) {
            colorOfEgg = scanner.nextLine();

            switch (colorOfEgg) {
                case "red":    countRedEggs++;    break;
                case "orange": countOrangeEggs++; break;
                case "blue":   countBlueEggs++;   break;
                case "green":  countGreenEggs++;  break;
            }

            if(countRedEggs > maxEggs){
                maxEggs = countRedEggs;
                colorOfMaxEgg = "red";
            }else if(countOrangeEggs > maxEggs){
                maxEggs = countOrangeEggs;
                colorOfMaxEgg = "orange";
            }else if(countBlueEggs > maxEggs){
                maxEggs = countBlueEggs;
                colorOfMaxEgg = "blue";
            }else if(countGreenEggs > maxEggs){
                maxEggs = countGreenEggs;
                colorOfMaxEgg = "green";
            }
        }

        System.out.printf("Red eggs: %d%n" +
                "Orange eggs: %d%n" +
                "Blue eggs: %d%n" +
                "Green eggs: %d%n" +
                "Max eggs: %d -> %s", countRedEggs, countOrangeEggs,
                countBlueEggs, countGreenEggs ,maxEggs, colorOfMaxEgg);
    }
}
