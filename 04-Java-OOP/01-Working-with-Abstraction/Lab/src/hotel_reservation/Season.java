package hotel_reservation;

public enum Season {

    SPRING(2), SUMMER(4), AUTUMN(1), WINTER(3);

    private final int multiplyIndex;

    Season(int multiplyIndex) {
        this.multiplyIndex = multiplyIndex;
    }

    public int getMultiplyIndex() {
        return multiplyIndex;
    }

    public static Season validateSeason(String season) {
        if (season.equals("Spring")) {
            return SPRING;
        } else if (season.equals("Summer")) {
            return SUMMER;
        } else if (season.equals("AUTUMN")) {
            return AUTUMN;
        } else {
            return WINTER;
        }
    }
}

