package com.africa.semicolon.diary.services;

import com.africa.semicolon.diary.data.models.Entry;
import com.africa.semicolon.diary.dto.request.EntryRequest;
import com.africa.semicolon.diary.dto.request.LoginRequest;
import com.africa.semicolon.diary.dto.request.LogoutRequest;
import com.africa.semicolon.diary.dto.request.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiaryServices {
    void register(RegisterRequest registerRequest);

    void login(LoginRequest loginRequest);

    void logout(LogoutRequest logoutRequest);

    void createEntry(EntryRequest entryRequest);

    List<Entry> findAllEntries();
}
