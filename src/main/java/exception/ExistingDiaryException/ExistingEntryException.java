package exception.ExistingDiaryException;

public class ExistingEntryException extends  RuntimeException{
    public ExistingEntryException(String message){
        super(message);
    }
}
