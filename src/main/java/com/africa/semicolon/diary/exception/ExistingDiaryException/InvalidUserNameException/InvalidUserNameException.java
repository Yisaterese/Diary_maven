package com.africa.semicolon.diary.exception.ExistingDiaryException.InvalidUserNameException;

public class InvalidUserNameException extends RuntimeException {
    public InvalidUserNameException (String providedUsernameNotFound) {
        super(providedUsernameNotFound);
    }
}
