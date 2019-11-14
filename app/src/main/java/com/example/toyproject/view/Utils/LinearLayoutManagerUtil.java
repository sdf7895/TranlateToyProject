package com.example.toyproject.view.Utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.example.toyproject.databinding.LanguageSelectViewBinding;
import com.example.toyproject.databinding.PapagoFragmentBinding;
import com.example.toyproject.databinding.RecyclerViewBinding;
import com.example.toyproject.view.RecyclerViewAdapter.LanguageSelectAdapter;
import com.example.toyproject.view.RecyclerViewAdapter.RecyclerViewAdpater;

public class LinearLayoutManagerUtil {

    public static void RecyclerViewUtil(Context context, RecyclerViewBinding recyclerView, RecyclerViewAdpater recyclerViewAdpater){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.recyclerview.setLayoutManager(linearLayoutManager);
        recyclerView.recyclerview.setAdapter(recyclerViewAdpater);
    }

    public static void SetandChangeLanguageSelectViewUtil(Context context, LanguageSelectViewBinding languageSelectViewBinding, LanguageSelectAdapter languageSelectAdapter){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        languageSelectViewBinding.recyclerview.setLayoutManager(linearLayoutManager);
        languageSelectViewBinding.recyclerview.setAdapter(languageSelectAdapter);
    }

}
