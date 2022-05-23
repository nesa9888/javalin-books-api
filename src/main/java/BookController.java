import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.plugin.json.JavalinJackson;

public class BookController {

    public static void create(Context ctx){
        NewBookRequest book = ctx.bodyAsClass(NewBookRequest.class);
        Book savedBook = BookService.save(book.title, book.author);
        ctx.status(201);
        ctx.result(new JavalinJackson().toJsonString(savedBook));

    }

    public static void getAll(Context ctx) {
        ctx.json(BookService.getAll());
    }

    public static void update(Context ctx, String id) {
        Book book = BookService.findById(Integer.parseInt(id));
        if(book == null){
            throw new NotFoundResponse("User Not Found");
        } else {
            NewBookRequest newBook = ctx.bodyAsClass(NewBookRequest.class);
            BookService.update(book.bookId, newBook.title, newBook.author);
            ctx.status(204);
        }
    }


}
