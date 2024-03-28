package com.africa.semicolon.diary.services;

import com.africa.semicolon.diary.exception.ExistingDiaryException.ExistingEntryException;
import com.africa.semicolon.diary.data.models.Entry;
import com.africa.semicolon.diary.dto.request.EntryRequest;
import com.africa.semicolon.diary.data.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServicesImpl implements EntryServices{
    @Autowired
    private EntryRepository entryRepository;
    @Override
    public void entryServicesRequestDetailsAndValidation(EntryRequest entryRequest) {
        Entry entry = new Entry();
        entry.setTitle(entryRequest.getTitle());
        entry.setBody(entryRequest.getBody());
        entry.setAuthor(entryRequest.getAuthor());
        if(entry.getAuthor().equals(entryRequest.getAuthor()))throw new ExistingEntryException("Author already exist");
        if(entry.getBody().equals(entryRequest.getBody()))throw new ExistingEntryException("Entry already exist");
        if(entry.getTitle().equals(entryRequest.getTitle()))throw new ExistingEntryException("entry title already exist");
        entryRepository.save(entry);
    }

    @Override
    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

}
