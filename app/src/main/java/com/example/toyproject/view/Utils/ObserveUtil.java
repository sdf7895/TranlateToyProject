package com.example.toyproject.view.Utils;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;

import com.example.toyproject.Model.Language;
import com.example.toyproject.Model.Model;
import com.example.toyproject.view.RecyclerViewAdapter.PapgoRecyclerViewAdpater;

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
}
