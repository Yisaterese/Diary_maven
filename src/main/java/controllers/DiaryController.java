package controllers;

import ExistingDiaryException.ExistingDiaryException;
import InvalidLoginDetailsException.InvalidLoginDetailsException;
import InvalidUserNameException.InvalidUserNameException;
import dto.request.LoginRequest;
import dto.request.LogoutRequest;
import dto.request.RegisterRequest;
import services.DiaryServices;
import services.DiaryServicesImpl;

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
}
