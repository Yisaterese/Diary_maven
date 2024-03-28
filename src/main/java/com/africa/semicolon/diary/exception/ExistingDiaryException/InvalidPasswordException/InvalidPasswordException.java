package com.africa.semicolon.diary.exception.ExistingDiaryException.InvalidPasswordException;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String invalidPasswordProvided) {
        super(invalidPasswordProvided);
    }
}
