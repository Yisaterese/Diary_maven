package controllers;

import data.models.Diary;
import data.models.Entry;
import dto.request.EntryRequest;
import dto.request.LoginRequest;
import dto.request.LogoutRequest;
import dto.request.RegisterRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryControllerTest {
    @Test
    public void logInToDiaryTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        DiaryController diaryController = new DiaryController();
        Diary diary = new Diary();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diary.setUserName(registerRequest.getUsername());
        diary.setPassword(registerRequest.getPassword());
        diaryController.register(registerRequest);

        loginRequest.setUsername(registerRequest.getUsername());
        loginRequest.setPassword(registerRequest.getPassword());
        diary.setUserName(loginRequest.getUsername());
        diary.setPassword(loginRequest.getPassword());
        diaryController.loginTo(loginRequest);

        assertTrue(diary.isUnlocked());

    }
    @Test
    public void logoutOfDiaryTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        DiaryController diaryController = new DiaryController();
        LogoutRequest logoutRequest = new LogoutRequest();
        LoginRequest loginRequest = new LoginRequest();
        Diary diary = new Diary();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diary.setUserName(registerRequest.getUsername());
        diary.setPassword(registerRequest.getPassword());
        diaryController.register(registerRequest);

        loginRequest.setUsername(registerRequest.getUsername());
        loginRequest.setPassword(registerRequest.getPassword());
        diary.setUserName(loginRequest.getUsername());
        diary.setPassword(loginRequest.getPassword());
        diaryController.loginTo(loginRequest);

        assertTrue(diary.isUnlocked());

        logoutRequest.setUsername(registerRequest.getUsername());
        logoutRequest.setPassword(registerRequest.getPassword());
        diary.setUserName(logoutRequest.getUsername());
        diary.setPassword(logoutRequest.getPassword());
        diaryController.logoutOf(logoutRequest);

        assertTrue(diary.isLocked());

    }
    public void registerDiary_createEntryTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        DiaryController diaryController = new DiaryController();
        EntryRequest entryRequest = new EntryRequest();
        Entry entry = new Entry();
        Diary diary = new Diary();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diary.setUserName(registerRequest.getUsername());
        diary.setPassword(registerRequest.getPassword());
        diaryController.register(registerRequest);

        loginRequest.setUsername(registerRequest.getUsername());
        loginRequest.setPassword(registerRequest.getPassword());
        diary.setUserName(loginRequest.getUsername());
        diary.setPassword(loginRequest.getPassword());
        diaryController.loginTo(loginRequest);

        assertTrue(diary.isUnlocked());

        entryRequest.setAuthor("Ayo");
        entryRequest.setTitle("My love life");
        entryRequest.setBody("When i ever see you my heart do jigijigi panpan ");
        diaryController.createEntryFor(entryRequest);
//        entry.setAuthor(entryRequest.getAuthor());
//        entry.setTitle(entryRequest.getTitle());
//        entry.setBody(entryRequest.getBody());
//

            assertEquals(1, diaryController.findAll().size());



    }

}