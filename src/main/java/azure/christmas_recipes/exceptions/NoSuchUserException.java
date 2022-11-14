package azure.christmas_recipes.exceptions;

public class NoSuchUserException extends RuntimeException{

    public NoSuchUserException() {
        super("No such user");
    }
}
