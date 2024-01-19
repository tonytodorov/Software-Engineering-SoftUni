import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class _06_SortLines {

    public static void main(String[] args) throws IOException {

        Path paths = Paths.get("C:\\Users\\PC-TONY\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        List<String> lines = Files.readAllLines(paths).stream()
                .sorted()
                .collect(Collectors.toList());

        Path output = Paths.get("sort-lines");

        Files.write(output, lines);
    }
}
