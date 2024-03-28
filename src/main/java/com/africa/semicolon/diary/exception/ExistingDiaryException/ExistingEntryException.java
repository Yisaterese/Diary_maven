package com.africa.semicolon.diary.exception.ExistingDiaryException;

public class ExistingEntryException extends  RuntimeException{
    public ExistingEntryException(String message){
        super(message);
    }
}
