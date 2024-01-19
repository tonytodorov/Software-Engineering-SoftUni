import java.io.File;

public class _08_GetFolderSize {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\User\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        int folderSize = 0;

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();

                for (File currentFile: files) {
                    folderSize += currentFile.length();
                }
            }
        }

        System.out.printf("Folder size: %d", folderSize);
    }
}
