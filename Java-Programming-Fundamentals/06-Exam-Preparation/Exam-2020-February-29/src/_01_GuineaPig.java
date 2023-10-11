import java.util.Scanner;

public class _01_GuineaPig {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double food = Double.parseDouble(scanner.nextLine());
        double hay = Double.parseDouble(scanner.nextLine());
        double cover = Double.parseDouble(scanner.nextLine());
        double pigWeight = Double.parseDouble(scanner.nextLine());

        food *= 1000;
        hay *= 1000;
        cover *= 1000;
        pigWeight *= 1000;

        boolean isFoodFinish = false;

        for (int i = 1; i <= 30; i++) {

            food -= 300;

            if (food <= 0 || hay <= 0 || cover <= 0) {
                isFoodFinish = true;
                break;
            }

            if (i % 2 == 0) {
                double neededHay = food * 0.05;
                hay -= neededHay;
            }

            if (i % 3 == 0) {
                double neededCover = pigWeight / 3;
                cover -= neededCover;
            }
        }

        if (isFoodFinish) {
            System.out.println("Merry must go to the pet store!");
        } else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    food / 1000, hay / 1000, cover / 1000);
        }
    }
}
