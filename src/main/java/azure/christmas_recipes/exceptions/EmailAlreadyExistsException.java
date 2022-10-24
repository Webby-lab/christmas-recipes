package azure.christmas_recipes.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException() {
        super("Email already exists");
    }
}
