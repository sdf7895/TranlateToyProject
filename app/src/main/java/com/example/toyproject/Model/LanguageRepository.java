package com.example.toyproject.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class LanguageRepository {

    private final LanguageDao languageDao;
    private final LiveData<List<Language>> allLanguage;

    LanguageRepository(Application application){
        LanguageDataBase db = LanguageDataBase.getDatabase(application);
        languageDao = db.languageDao();
        allLanguage = languageDao.getAllLanguage();
    }

    public void insert(Language language) {
        new AsyncTask<Language, Void, Long>(){
            @Override
            protected void onPostExecute(Long aLong) {
                super.onPostExecute(aLong);
            }

            @Override
            protected Long doInBackground(Language... languages) {
                if(languageDao == null)
                    return -1L;
                return languageDao.insert(languages[0]);
            }
        }.execute(language);
    }

    public void update(Language language){
        new AsyncTask<Language, Void, Integer>(){
            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
            }

            @Override
            protected Integer doInBackground(Language... languages) {
                if(languageDao == null)
                    return -1;
                return languageDao.update(languages[0]);
            }
        }.execute(language);
    }

    public void deleteAll() {
        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
            }

            @Override
            protected Integer doInBackground(Void... voids) {
                if(languageDao == null)
                    return -1;
                return languageDao.deleteAll();
            }
        }.execute();
    }

    public void deleteLanguage(int id){
        new AsyncTask<Integer, Void, Integer>(){
            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
            }

            @Override
            protected Integer doInBackground(Integer... integers) {
                if(languageDao == null)
                    return -1;
                return languageDao.deleteLanguage(integers[0]);
            }
        }.execute(id);
    }

    public LiveData<List<Language>> getAllLanguage(){
        return allLanguage;
    }

}
