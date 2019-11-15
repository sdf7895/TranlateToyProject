package com.example.toyproject.Model.NoteRepository;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import com.example.toyproject.Model.Language;
import com.example.toyproject.Model.LanguageRepository;

import java.util.List;

public class NoteModel extends AndroidViewModel {

    private final NoteLanguageRepository repository;
    private final LiveData<List<NoteLanguage>> allLanguage;

    public NoteModel(@NonNull Application application) {
        super(application);
        repository = new NoteLanguageRepository(application);
        allLanguage = repository.getAllLanguage();
    }

    public void insert(NoteLanguage noteLanguage) {repository.insert(noteLanguage);}

    public void update(NoteLanguage noteLanguage) {repository.update(noteLanguage);}

    public void deleteAll() {repository.deleteAll();}

    public void deleteUser(NoteLanguage noteLanguage) {repository.deleteLanguage(noteLanguage);}

    public LiveData<List<NoteLanguage>> getAllLanguage() {return allLanguage;}
}
