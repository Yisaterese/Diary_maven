package services;

import data.models.Entry;
import data.repository.EntryRepository;
import dto.request.EntryRequest;
import exception.ExistingDiaryException.ExistingEntryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryServicesImpl implements EntryServices{
    @Autowired
    private EntryRepository entryRepositoryImplement;
    @Override
    public void entryServicesRequestDetailsAndValidation(EntryRequest entryRequest) {
        Entry entry = new Entry();
        entry.setTitle(entryRequest.getTitle());
        entry.setBody(entryRequest.getBody());
        entry.setAuthor(entryRequest.getAuthor());
        if(entry.getAuthor().equals(entryRequest.getAuthor()))throw new ExistingEntryException("Author already exist");
        if(entry.getBody().equals(entryRequest.getBody()))throw new ExistingEntryException("Entry already exist");
        if(entry.getTitle().equals(entryRequest.getTitle()))throw new ExistingEntryException("entry title already exist");
        entryRepositoryImplement.save(entry);
    }

}
