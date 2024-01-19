import java.util.Scanner;

public class OldBooks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countBooks = 0;
        String book, currentBook;
        book = scanner.nextLine();
        currentBook = scanner.nextLine();
        boolean isFound = false;

        while (!currentBook.equals("No More Books")){
            if(currentBook.equals(book)){
                isFound = true;
                break;
            }
            countBooks++;
            currentBook = scanner.nextLine();
        }

        if(isFound) {
            System.out.printf("You checked %d books and found it.", countBooks);
        }else{
            System.out.printf("The book you search is not here!%nYou checked %d books.", countBooks);
        }

    }
}
