package services;

import data.models.Entry;
import dto.request.EntryRequest;

import java.util.List;

public interface EntryServices {
    void entryServicesRequestDetailsAndValidation(EntryRequest entryRequest);

    List<Entry> findAll();
}
