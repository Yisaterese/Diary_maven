package services;

import InvalidPasswordException.InvalidPasswordException;
import InvalidUserNameException.InvalidUserNameException;

import dto.request.LoginRequest;
import dto.request.LogoutRequest;
import dto.request.RegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import data.models.Diary;
import data.repository.DiaryRepository;

@Service
public class DiaryServicesImpl implements DiaryServices {
    @Autowired
    private DiaryRepository diaryRepositoryImplement;

    private EntryServices entryServiceImplement = new EntryServicesImpl();
    private RegisterRequest registerRequest;

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
        Diary foundDiary = diaryRepositoryImplement.findByUsername(loginRequest.getUsername());
        if (!foundDiary.getUserName().equals(loginRequest.getUsername()))
            throw new InvalidUserNameException("provided username not found");
        if (!findPassword(loginRequest)) throw new InvalidPasswordException("invalid password provided");
        foundDiary.setLock(true);
        diaryRepositoryImplement.save(foundDiary);
    }

    public void logout(LogoutRequest logOutRequest) {
        Diary foundDiary = diaryRepositoryImplement.findByUsername(logOutRequest.getUsername());
        if (!foundDiary.getUserName().equals(logOutRequest.getUsername()))
            throw new InvalidUserNameException("invalid username provided");
        foundDiary.setLock(false);
    }

//    public void createEntryFor(EntryRequest entryRequest) {
//        entryServiceImplement.entryServicesRequestDetailsAndValidation(entryRequest);
//
//    }
//
    private boolean findPassword(LoginRequest loginRequest) {
        Diary foundDiary = diaryRepositoryImplement.findByUsername(loginRequest.getUsername());
        if (foundDiary.getPassword().equals(loginRequest.getPassword())) {
            return true;
        }

        return false;
    }

    private Diary findUserName(LoginRequest loginRequest) {
        Diary foundDiary = diaryRepositoryImplement.findByUsername(loginRequest.getUsername());
        if (foundDiary.getUserName().equals(loginRequest.getUsername())) {
            return foundDiary;
        }

        return null;
    }
//
//    public List<Entry> findAllEntries() {
//        return entryServiceImplement.findAll();
//
//    }
}