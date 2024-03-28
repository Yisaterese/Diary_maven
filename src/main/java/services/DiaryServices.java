package services;

import data.models.Entry;
import dto.request.EntryRequest;
import dto.request.LoginRequest;
import dto.request.LogoutRequest;
import dto.request.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiaryServices {
    void register(RegisterRequest registerRequest);

    void login(LoginRequest loginRequest);

    void logout(LogoutRequest logoutRequest);

    void createEntry(EntryRequest entryRequest);

    List<Entry> findAllEntries();
}
