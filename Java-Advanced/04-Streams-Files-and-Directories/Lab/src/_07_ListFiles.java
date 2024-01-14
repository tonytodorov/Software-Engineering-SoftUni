import java.io.File;

public class _07_ListFiles {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\PC-TONY\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();

                for (File currentFile: files) {
                    if (!currentFile.isDirectory()) {
                        System.out.printf("%s: [%s]%n", currentFile.getName(), currentFile.length());
                    }
                }
            }
        }
    }
}
