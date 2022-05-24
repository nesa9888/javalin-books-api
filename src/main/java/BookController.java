import co.elastic.clients.elasticsearch.core.get_script_context.Context;
import io.javalin.http.NotFoundResponse;

public class BookController {

    public static void create(io.javalin.http.Context ctx){
        NewBookRequest book = ctx.bodyAsClass(NewBookRequest.class);
        Book savedBook = BookService.save(book.title, book.author);
        ctx.status(201);


    }

    public static void getAll(io.javalin.http.Context ctx) {
        ctx.json(BookService.getAll());
    }

    public static void update(io.javalin.http.Context ctx, String id) {
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
