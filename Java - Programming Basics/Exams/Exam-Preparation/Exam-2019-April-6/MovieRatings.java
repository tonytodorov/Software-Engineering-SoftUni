import java.util.Scanner;

public class MovieRatings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfFilm, nameOfFilmWithHighestRate = "", nameOfFilmWithLowestRate = "";
        double filmRating, minValue = Double.MAX_VALUE, maxValue = Double.MIN_VALUE, sum = 0.00;
        int numberOfFilms;
        numberOfFilms = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfFilms; i++) {
            nameOfFilm = scanner.nextLine();
            filmRating = Double.parseDouble(scanner.nextLine());

            if(minValue > filmRating){
                minValue = filmRating;
                nameOfFilmWithLowestRate = nameOfFilm;
            }
            if(maxValue < filmRating){
                maxValue = filmRating;
                nameOfFilmWithHighestRate = nameOfFilm;
            }

            sum += filmRating;
        }

        System.out.printf("%s is with highest rating: %.1f%n", nameOfFilmWithHighestRate, maxValue);
        System.out.printf("%s is with lowest rating: %.1f%n", nameOfFilmWithLowestRate, minValue);
        System.out.printf("Average rating: %.1f", sum / numberOfFilms);

    }
}
