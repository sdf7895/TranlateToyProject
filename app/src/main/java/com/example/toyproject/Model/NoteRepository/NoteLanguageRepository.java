package com.example.toyproject.Model.NoteRepository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.toyproject.Model.Language;
import com.example.toyproject.Model.LanguageDataBase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteLanguageRepository {
    private static final String TAG = NoteLanguageRepository.class.getCanonicalName();

    private final NoteLanguageDao noteLanguageDao;
    private final LiveData<List<NoteLanguage>> allLanguage;
    private ExecutorService executorService;

    NoteLanguageRepository(Application application){
        LanguageDataBase db = LanguageDataBase.getDatabase(application);
        noteLanguageDao = db.noteLanguageDao();
        allLanguage = noteLanguageDao.getAllLanguage();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(NoteLanguage noteLanguage) {
        executorService.execute(() -> noteLanguageDao.insert(noteLanguage));
    }

    public void update(NoteLanguage noteLanguage){
        executorService.execute(() -> noteLanguageDao.update(noteLanguage));
    }

    public void deleteAll() {
        executorService.execute(() -> noteLanguageDao.deleteAll());
    }

    public void deleteLanguage(NoteLanguage noteLanguage){
        executorService.execute(() -> noteLanguageDao.deleteLanguage(noteLanguage));
    }

    public LiveData<List<NoteLanguage>> getAllLanguage(){
        return allLanguage;
    }

}
