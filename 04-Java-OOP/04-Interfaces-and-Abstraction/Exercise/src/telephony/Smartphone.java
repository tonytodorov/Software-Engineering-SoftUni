package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {

        StringBuilder sb = new StringBuilder();

        for (String url : this.urls) {
            if (url.matches("^\\D+$")) {
                sb.append(String.format("Browsing: %s!", url));
            } else {
                sb.append("Invalid URL!");
            }

            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String number : this.numbers) {
            if (number.matches("^[0-9]+$")) {
                sb.append(String.format("Calling... %s", number));
            } else {
                sb.append("Invalid number!");
            }

            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
