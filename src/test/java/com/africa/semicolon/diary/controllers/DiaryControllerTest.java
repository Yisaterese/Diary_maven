package com.africa.semicolon.diary.controllers;

import com.africa.semicolon.diary.controllers.DiaryController;
import com.africa.semicolon.diary.dto.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DiaryControllerTest {
    @Autowired
    private DiaryController diaryController;
    @Test
    public void registerTest(){
        RegisterRequest registerRequest = new RegisterRequest();

        registerRequest.setUsername("username");
        registerRequest.setPassword("password");

        assertEquals("a", diaryController.register(registerRequest));
    }
    @Test
    public void logInToDiaryTest(){
        RegisterRequest registerRequest = new RegisterRequest();

        registerRequest.setUsername("username");
        registerRequest.setPassword("password");


    }
//    @Test
//    public void logoutOfDiaryTest(){
//        RegisterRequest registerRequest = new RegisterRequest();
//        DiaryController diaryController = new DiaryController();
//        LogoutRequest logoutRequest = new LogoutRequest();
//        LoginRequest loginRequest = new LoginRequest();
//        Diary diary = new Diary();
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diary.setUserName(registerRequest.getUsername());
//        diary.setPassword(registerRequest.getPassword());
//        diaryController.register(registerRequest);
//
//        loginRequest.setUsername(registerRequest.getUsername());
//        loginRequest.setPassword(registerRequest.getPassword());
//        diary.setUserName(loginRequest.getUsername());
//        diary.setPassword(loginRequest.getPassword());
//        diaryController.loginTo(loginRequest);
//
//        assertTrue(diary.isUnlocked());
//
//        logoutRequest.setUsername(registerRequest.getUsername());
//        logoutRequest.setPassword(registerRequest.getPassword());
//        diary.setUserName(logoutRequest.getUsername());
//        diary.setPassword(logoutRequest.getPassword());
//        diaryController.logoutOf(logoutRequest);
//
//        assertTrue(diary.isLocked());
//
//    }
//    public void registerDiary_createEntryTest(){
//        RegisterRequest registerRequest = new RegisterRequest();
//        LoginRequest loginRequest = new LoginRequest();
//        DiaryController diaryController = new DiaryController();
//        EntryRequest entryRequest = new EntryRequest();
//        Entry entry = new Entry();
//        Diary diary = new Diary();
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diary.setUserName(registerRequest.getUsername());
//        diary.setPassword(registerRequest.getPassword());
//        diaryController.register(registerRequest);
//
//        loginRequest.setUsername(registerRequest.getUsername());
//        loginRequest.setPassword(registerRequest.getPassword());
//        diary.setUserName(loginRequest.getUsername());
//        diary.setPassword(loginRequest.getPassword());
//        diaryController.loginTo(loginRequest);
//
//        assertTrue(diary.isUnlocked());
//
//        entryRequest.setAuthor("Ayo");
//        entryRequest.setTitle("My love life");
//        entryRequest.setBody("When i ever see you my heart do jigijigi panpan ");
//        diaryController.createEntryFor(entryRequest);
//
//        assertEquals(1, diaryController.findAll().size());
//
//    }

}