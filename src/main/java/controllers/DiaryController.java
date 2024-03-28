package controllers;

import data.models.Entry;
import exception.ExistingDiaryException.ExistingDiaryException;
import exception.ExistingDiaryException.ExistingEntryException;
import exception.ExistingDiaryException.InvalidLoginDetailsException.InvalidLoginDetailsException;
import exception.ExistingDiaryException.InvalidUserNameException.InvalidUserNameException;
import dto.request.EntryRequest;
import dto.request.LoginRequest;
import dto.request.LogoutRequest;
import dto.request.RegisterRequest;
import services.DiaryServices;
import services.DiaryServicesImpl;

import java.util.Collection;
import java.util.List;

public class DiaryController {
    private DiaryServices diaryServicesImpl = new DiaryServicesImpl();

    public String register(RegisterRequest registerRequest) {
        try{
            diaryServicesImpl.register(registerRequest);
            return "Diary created successfully";
        }catch (ExistingDiaryException e){
            return e.getMessage();
        }
    }

    public String loginTo(LoginRequest loginRequest) {
        try{
            diaryServicesImpl.login(loginRequest);
            return "loged in successfully";
        }catch (InvalidLoginDetailsException e){
            return e.getMessage();
        }
    }

    public String logoutOf(LogoutRequest logoutRequest) {
        try{
            diaryServicesImpl.logout(logoutRequest);
            return "loged out successful";
        }catch (InvalidUserNameException e){
            return e.getMessage();
        }
    }

    public String createEntryFor(EntryRequest entryRequest) {
        try {
            diaryServicesImpl.createEntry(entryRequest);
            return "entry created successfully";
        }catch (ExistingEntryException e){
            return e.getMessage();
        }
    }

    public List<Entry> findAll() {
        return diaryServicesImpl.findAllEntries();
    }
}
