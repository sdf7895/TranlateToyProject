package com.example.toyproject.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface LanguageDao {

    @Insert
    long insert(Language language);

    @Update
    int update(Language language);

    @Query("DELETE FROM language_table")
    int deleteAll();

    @Delete
    void deleteLanguage(Language language);

    @Query("SELECT * from language_table ORDER BY id DESC")
    LiveData<List<Language>> getAllLanguage();
}
