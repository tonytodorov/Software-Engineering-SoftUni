import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class _01_AdvertisementMessage {

    public static class Messages {
        String phrase;
        String event;
        String author;
        String city;

        public Messages(String phrase, String event, String author, String city) {
            this.phrase = phrase;
            this.event = event;
            this.author = author;
            this.city = city;
        }

        public String getPhrase() {
            return phrase;
        }

        public String getEvent() {
            return event;
        }

        public String getAuthor() {
            return author;
        }

        public String getCity() {
            return city;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> phrases = new ArrayList<>();
        phrases(phrases);

        List<String> events = new ArrayList<>();
        events(events);

        List<String> authors = new ArrayList<>();
        authors(authors);

        List<String> cities = new ArrayList<>();
        cities(cities);

        List<Messages> message = new ArrayList<>();

        for (int i = 0; i < n; i++) {


            int firstNum = generateRandomNumber(0, 5);
            int secondNum = generateRandomNumber(0, 7);
            int thirdNum = generateRandomNumber(0, 4);

            String phrase = phrases.get(firstNum);
            String event = events.get(firstNum);
            String author = authors.get(secondNum);
            String city = cities.get(thirdNum);

            Messages messages = new Messages(phrase, event, author, city);
            message.add(messages);
        }

        for (Messages messages: message) {
            System.out.printf("%s %s %s - %s%n",
                    messages.getPhrase(),
                    messages.getEvent(),
                    messages.getAuthor(),
                    messages.getCity());
        }

    }

    public static void phrases(List<String> phrases) {

        phrases.add("Excellent product.");
        phrases.add("Such a great product.");
        phrases.add("I always use that product.");
        phrases.add("Best product of its category.");
        phrases.add("Exceptional product.");
        phrases.add("I can’t live without this product.");
    }

    public static void events(List<String> events) {

        events.add("Now I feel good.");
        events.add("I have succeeded with this product.");
        events.add("Makes miracles. I am happy of the results!");
        events.add("I cannot believe but now I feel awesome.");
        events.add("Try it yourself, I am very satisfied.");
        events.add("I feel great!");

    }

    public static void authors(List<String> authors) {

        authors.add("Diana");
        authors.add("Petya");
        authors.add("Stella");
        authors.add("Elena");
        authors.add("Katya");
        authors.add("Iva");
        authors.add("Annie");
        authors.add("Eva");
    }

    public static void cities(List<String> authors) {

        authors.add("Burgas");
        authors.add("Sofia");
        authors.add("Plovdiv");
        authors.add("Varna");
        authors.add("Ruse");
    }

    public static int generateRandomNumber(int lowerBound, int upperBound) {

        Random random = new Random();
        return random.nextInt(upperBound - lowerBound) + lowerBound;
    }
}
