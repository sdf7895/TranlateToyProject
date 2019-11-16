package com.example.toyproject.view.Utils;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.example.toyproject.Model.Language;
import com.example.toyproject.Model.Model;
import com.example.toyproject.Model.NoteRepository.NoteLanguage;
import com.example.toyproject.Model.NoteRepository.NoteModel;
import com.example.toyproject.view.RecyclerViewAdapter.PapgoRecyclerViewAdpater;
import com.example.toyproject.view.RecyclerViewAdapter.RecyclerViewAdpater;

public class ObserveUtil {

    public static void translateObserve(String text, String change, Fragment fragment , PapgoRecyclerViewAdpater papagoRecyclerViewAdpater){
        Model model = ViewModelProviders.of(fragment).get(Model.class);
        model.getAllLanguage().observe(fragment, languages -> papagoRecyclerViewAdpater.setData(languages));

        if(text.trim().length() == 0) return;
        if(change.trim().length() == 0) return;

        Language language = new Language();
        language.setText(text);
        language.setTranslatedText(change);
        model.insert(language);
    }

    public static void translateObserve(Fragment fragment , RecyclerViewAdpater recyclerViewAdpater, Language language){
        NoteModel model = ViewModelProviders.of(fragment).get(NoteModel.class);
        model.getAllLanguage().observe(fragment, notelanguages -> recyclerViewAdpater.setData(notelanguages));

        String text = language.getText();
        String change = language.getTranslatedText();

        if(text.trim().length() == 0) return;
        if(change.trim().length() == 0) return;

        NoteLanguage noteLanguage = new NoteLanguage();
        noteLanguage.setText(text);
        noteLanguage.setTranslatedText(change);
        model.insert(noteLanguage);
    }
}
