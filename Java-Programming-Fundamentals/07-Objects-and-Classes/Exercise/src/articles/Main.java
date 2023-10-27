package articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articles = scanner.nextLine().split(", ");

        String title = articles[0];
        String content = articles[1];
        String author = articles[2];

        List<Article> articleList = new ArrayList<>();
        Article article = new Article(title, content, author);

        articleList.add(article);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split(": ");
            String operation = tokens[0];

            if (operation.equals("Edit")) {
                String newContent = tokens[1];
                article.setContent(newContent);
            } else if (operation.equals("ChangeAuthor")) {
                String newAuthor = tokens[1];
                article.setAuthor(newAuthor);
            } else if (operation.equals("Rename")) {
                String newTitle = tokens[1];
                article.setTitle(newTitle);
            }
            
        }

        System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());
    }
}
