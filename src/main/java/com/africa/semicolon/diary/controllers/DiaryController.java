package com.africa.semicolon.diary.controllers;

import com.africa.semicolon.diary.exception.ExistingDiaryException.ExistingDiaryException;
import com.africa.semicolon.diary.exception.ExistingDiaryException.ExistingEntryException;
import com.africa.semicolon.diary.exception.ExistingDiaryException.InvalidLoginDetailsException.InvalidLoginDetailsException;
import com.africa.semicolon.diary.exception.ExistingDiaryException.InvalidUserNameException.InvalidUserNameException;
import com.africa.semicolon.diary.data.models.Entry;
import com.africa.semicolon.diary.dto.request.EntryRequest;
import com.africa.semicolon.diary.dto.request.LoginRequest;
import com.africa.semicolon.diary.dto.request.LogoutRequest;
import com.africa.semicolon.diary.dto.request.RegisterRequest;
import com.africa.semicolon.diary.services.DiaryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DiaryController {
    @Autowired
    private DiaryServices diaryServices;

    @RequestMapping

    public String register(RegisterRequest registerRequest) {
        try{
            diaryServices.register(registerRequest);
            return "Diary created successfully";
        }catch (ExistingDiaryException e){
            return e.getMessage();
        }
    }

    public String loginTo(LoginRequest loginRequest) {
        try{
            diaryServices.login(loginRequest);
            return "loged in successfully";
        }catch (InvalidLoginDetailsException e){
            return e.getMessage();
        }
    }

    public String logoutOf(LogoutRequest logoutRequest) {
        try{
            diaryServices.logout(logoutRequest);
            return "loged out successful";
        }catch (InvalidUserNameException e){
            return e.getMessage();
        }
    }

    public String createEntryFor(EntryRequest entryRequest) {
        try {
            diaryServices.createEntry(entryRequest);
            return "entry created successfully";
        }catch (ExistingEntryException e){
            return e.getMessage();
        }
    }

    public List<Entry> findAll() {
        return diaryServices.findAllEntries();
    }
}
