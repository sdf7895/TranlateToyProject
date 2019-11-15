package com.example.toyproject.Model.NoteRepository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NoteLanguageDao {

    @Insert
    long insert(NoteLanguage notelanguage);

    @Update
    int update(NoteLanguage notelanguage);

    @Query("DELETE FROM Note_language_table")
    int deleteAll();

    @Delete
    void deleteLanguage(NoteLanguage notelanguage);

    @Query("SELECT * from Note_language_table ORDER BY id DESC")
    LiveData<List<NoteLanguage>> getAllLanguage();
}
