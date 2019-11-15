package com.example.toyproject.Model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.toyproject.Model.NoteRepository.NoteLanguage;
import com.example.toyproject.Model.NoteRepository.NoteLanguageDao;

@Database(entities = {Language.class, NoteLanguage.class}, version = 1)
public abstract class LanguageDataBase extends RoomDatabase {
    public abstract LanguageDao languageDao();
    public abstract NoteLanguageDao noteLanguageDao();

    private static volatile LanguageDataBase INSTANCE;

    public static LanguageDataBase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (LanguageDataBase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LanguageDataBase.class,"language_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
