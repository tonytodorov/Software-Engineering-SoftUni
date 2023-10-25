package advertisement;

public class Messages {
    private String phrase;
    private String event;
    private String author;
    private String city;

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
