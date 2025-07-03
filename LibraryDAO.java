import java.sql.*;
import java.util.List;
import java.util.ArrayList;
  // already in your file

public class LibraryDAO {

    /* --------------  put them RIGHT HERE, inside the class, outside all methods --------------- */
    private static final String URL  = "jdbc:mysql://localhost:3306/librarydb";
    private static final String USER = "root";
    private static final String PASS = "Qwerty@123";   // or "" if no password
    /* ------------------------------------------------------------------------------------------ */

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setAvailable(rs.getBoolean("available"));
                books.add(b);
            }

        } catch (SQLException e) { e.printStackTrace(); }
        return books;
    }
}
