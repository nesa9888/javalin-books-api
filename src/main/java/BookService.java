import org.elasticsearch.client.security.user.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BookService {

    private static Map<Integer, Book> books = new HashMap<>();

    private static AtomicInteger lastId = new AtomicInteger(0);

    static {
        books.put(0, new Book(1, "Moby Dick", "Herman Melville"));
        books.put(1, new Book(2, "20000 Leagues Under The Sea", "Jules Verne"));
        books.put(2, new Book(3, "The Hitchhikers Guide to the Galaxy", "Douglas Adams"));
    }

    public static Book save(String title, String author) {
        int id = lastId.incrementAndGet();
        Book book = new Book(id, title, author);
        books.put(id, book);
        return book;
    }

    public static Collection<Book> getAll() {
        return books.values();
    }

    public static void update(int bookId, String title, String author) {
        books.put(bookId, new Book(bookId, title, author));
    }

    public static Book findById(int bookId) {
        return books.get(bookId);
    }

    public static void delete(int bookId) {
        books.remove(bookId);
    }



}
