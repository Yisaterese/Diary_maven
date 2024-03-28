package com.africa.semicolon.diary.services;

import com.africa.semicolon.diary.data.models.Entry;
import com.africa.semicolon.diary.dto.request.EntryRequest;

import java.util.List;

public interface EntryServices {
    void entryServicesRequestDetailsAndValidation(EntryRequest entryRequest);

    List<Entry> findAll();
}
