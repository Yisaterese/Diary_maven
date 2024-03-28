package InvalidUserNameException;

public class InvalidUserNameException extends RuntimeException {
    public InvalidUserNameException (String providedUsernameNotFound) {
        super(providedUsernameNotFound);
    }
}
