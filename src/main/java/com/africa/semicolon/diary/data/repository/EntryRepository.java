package com.africa.semicolon.diary.data.repository;

import com.africa.semicolon.diary.data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends MongoRepository<Entry, String> {
}
