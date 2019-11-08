package com.example.toyproject.Model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class Model extends AndroidViewModel {

    private final LanguageRepository repository;
    private final LiveData<List<Language>> allLanguage;

    public Model(@NonNull Application application) {
        super(application);
        repository = new LanguageRepository(application);
        allLanguage = repository.getAllLanguage();
    }

    public void insert(Language language) {
        repository.insert(language);
    }

    public void update(Language language) {
        repository.update(language);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteUser(int id) {
        repository.deleteLanguage(id);
    }

    public LiveData<List<Language>> getAllLanguage() {
        return allLanguage;
    }
}
