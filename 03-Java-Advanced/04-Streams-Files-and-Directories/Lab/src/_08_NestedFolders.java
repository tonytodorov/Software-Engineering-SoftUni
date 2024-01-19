import java.io.File;
import java.util.ArrayDeque;

public class _08_NestedFolders {

    public static void main(String[] args) {

        String path = "C:\\Users\\PC-TONY\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(path);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(root);

        int count = 0;

        while (!queue.isEmpty()) {

            File current = queue.poll();
            File[] nested = current.listFiles();

            for (File file: nested) {
                if (file.isDirectory()) {
                    queue.offer(file);
                    System.out.println(file.getName());
                }

                count += 1;
            }
        }

        System.out.printf("%d folders", count);
    }
}
