package com.africa.semicolon.diary.data.repository;

import com.africa.semicolon.diary.data.models.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends MongoRepository<Diary, String> {
    Diary findByUserName(String username);
}
