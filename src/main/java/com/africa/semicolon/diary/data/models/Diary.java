package com.africa.semicolon.diary.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Diary {
    @Id
    private String userName;
    private String password;
    private boolean isLocked;

}
