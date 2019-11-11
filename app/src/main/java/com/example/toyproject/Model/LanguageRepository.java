package com.example.toyproject.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LanguageRepository {
    private static final String TAG = LanguageRepository.class.getCanonicalName();

    private final LanguageDao languageDao;
    private final LiveData<List<Language>> allLanguage;
    private ExecutorService executorService;

    LanguageRepository(Application application){
        LanguageDataBase db = LanguageDataBase.getDatabase(application);
        languageDao = db.languageDao();
        allLanguage = languageDao.getAllLanguage();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(Language language) {
        executorService.execute(() -> languageDao.insert(language));
    }

    public void update(Language language){
        executorService.execute(() -> languageDao.update(language));
    }

    public void deleteAll() {
        executorService.execute(() -> languageDao.deleteAll());
    }

    public void deleteLanguage(Language language){
        executorService.execute(() -> languageDao.deleteLanguage(language));
    }

    public LiveData<List<Language>> getAllLanguage(){
        return allLanguage;
    }

}
