
import java.util.List;

public class LibraryService {
    private LibraryDAO dao = new LibraryDAO();

    public void addNewBook(String title, String author) {
        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        dao.addBook(b);
    }

    public void showAllBooks() {
        List<Book> books = dao.getAllBooks();
        for (Book b : books) {
            System.out.println(b.getId() + ". " + b.getTitle() + " - " + b.getAuthor() + " | Available: " + b.isAvailable());
        }
    }
}
