package com.africa.semicolon.diary.services;

import com.africa.semicolon.diary.exception.ExistingDiaryException.InvalidPasswordException.InvalidPasswordException;
import com.africa.semicolon.diary.exception.ExistingDiaryException.InvalidUserNameException.InvalidUserNameException;
import com.africa.semicolon.diary.data.models.Diary;
import com.africa.semicolon.diary.data.models.Entry;
import com.africa.semicolon.diary.dto.request.EntryRequest;
import com.africa.semicolon.diary.dto.request.LoginRequest;
import com.africa.semicolon.diary.dto.request.LogoutRequest;
import com.africa.semicolon.diary.dto.request.RegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.africa.semicolon.diary.data.repository.DiaryRepository;

import java.util.List;

@Service
public class DiaryServicesImpl implements DiaryServices {
    @Autowired
    private DiaryRepository diaryRepositoryImplement;
    @Autowired
    private EntryServices entryServiceImplement;


//    @Override
//    public long numberOfDiaries() {
//        return diaryRepositoryImplement.count();
//    }

    @Override
    public void register(RegisterRequest registerRequest) {
        Diary diary = new Diary();
        diary.setUserName(registerRequest.getUsername());
        diary.setPassword(registerRequest.getPassword());
        diaryRepositoryImplement.save(diary);
    }

    @Override
    public void login(LoginRequest loginRequest) {
        Diary foundDiary = diaryRepositoryImplement.findByUserName(loginRequest.getUsername());
        if (!foundDiary.getUserName().equals(loginRequest.getUsername()))
            throw new InvalidUserNameException("provided username not found");
        if (!findPasswordFor(loginRequest)) throw new InvalidPasswordException("invalid password provided");
        foundDiary.setLocked(true);
        diaryRepositoryImplement.save(foundDiary);
    }

    public void logout(LogoutRequest logOutRequest) {
        Diary foundDiary = diaryRepositoryImplement.findByUserName(logOutRequest.getUsername());
        if (!foundDiary.getUserName().equals(logOutRequest.getUsername()))
            throw new InvalidUserNameException("invalid username provided");
        foundDiary.setLocked(false);
    }

    public void createEntry(EntryRequest entryRequest) {
        entryServiceImplement.entryServicesRequestDetailsAndValidation(entryRequest);

    }

    private boolean findPasswordFor(LoginRequest loginRequest) {
        Diary foundDiary = diaryRepositoryImplement.findByUserName(loginRequest.getUsername());
        if (foundDiary.getPassword().equals(loginRequest.getPassword())) {
            return true;
        }

        return false;
    }

    private Diary findUserName(LoginRequest loginRequest) {
        Diary foundDiary = diaryRepositoryImplement.findByUserName(loginRequest.getUsername());
        if (foundDiary.getUserName().equals(loginRequest.getUsername())) {
            return foundDiary;
        }

        return null;
    }

    public List<Entry> findAllEntries() {
        return entryServiceImplement.findAll();

    }
}