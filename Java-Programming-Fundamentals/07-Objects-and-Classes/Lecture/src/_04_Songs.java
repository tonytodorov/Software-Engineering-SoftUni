import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _04_Songs {

    public static class Song {
        String typeList;
        String name;
        String time;


        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Song> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String data = scanner.nextLine();
            String[] tokens = data.split("_");

            String typeList = tokens[0];
            String name = tokens[1];
            String time = tokens[2];

            Song song = new Song(typeList, name, time);

            result.add(song);
        }

        String songType = scanner.nextLine();

        if (songType.equals("all")) {
            for (Song song : result) {
                System.out.printf("%s%n", song.name);
            }
        } else {
            for (Song song : result) {
                if (songType.equals(song.typeList)) {
                    System.out.printf("%s%n", song.name);
                }
            }
        }
    }
}
