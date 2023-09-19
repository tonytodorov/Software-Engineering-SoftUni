import java.util.Scanner;

public class SeriesCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfSerial;
        int numberOfSeasons, numberOfEpisodes, episodeDuration;
        double episodeWithoutAds, addedTimeForSpecialEpisodes, totalTimeForSerial;

        nameOfSerial = scanner.nextLine();
        numberOfSeasons = Integer.parseInt(scanner.nextLine());
        numberOfEpisodes = Integer.parseInt(scanner.nextLine());
        episodeDuration = Integer.parseInt(scanner.nextLine());

        episodeWithoutAds = (episodeDuration * 0.2) + episodeDuration;
        addedTimeForSpecialEpisodes = numberOfSeasons * 10;

        totalTimeForSerial = episodeWithoutAds * numberOfEpisodes * numberOfSeasons + addedTimeForSpecialEpisodes;

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", nameOfSerial, Math.floor(totalTimeForSerial));



    }
}
