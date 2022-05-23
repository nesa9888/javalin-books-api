import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(3000);
        app.post("/books", BookController::create);
        app.get("/allbooks", BookController::getAll);
    }
}
