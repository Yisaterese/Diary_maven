package exception.ExistingDiaryException.InvalidPasswordException;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String invalidPasswordProvided) {
        super(invalidPasswordProvided);
    }
}
