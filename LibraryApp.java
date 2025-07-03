
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();
        while (true) {
            System.out.println("\nLibrary Management");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    service.addNewBook(title, author);
                    break;
                case 2:
                    service.showAllBooks();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
