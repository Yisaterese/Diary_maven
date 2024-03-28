package services;

import dto.request.LoginRequest;
import dto.request.LogoutRequest;
import dto.request.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface DiaryServices {
    void register(RegisterRequest registerRequest);

    void login(LoginRequest loginRequest);

    void logout(LogoutRequest logoutRequest);
}
