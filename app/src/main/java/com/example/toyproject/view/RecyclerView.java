package com.example.toyproject.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.toyproject.Model.Language;
import com.example.toyproject.Model.Model;
import com.example.toyproject.view.RecyclerViewAdapter.RecyclerViewAdpater;

import com.example.toyproject.R;
import com.example.toyproject.databinding.RecyclerViewBinding;


public class RecyclerView extends Fragment {
    private Model model;
    private RecyclerViewBinding binding;
    private RecyclerViewAdpater recyclerViewAdpater;
    private Boolean languageState = false;
    private Language language;

    private String text;
    private String translate;

    public static RecyclerView newInstance(){
        RecyclerView recyclerView = new RecyclerView();

        return recyclerView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.recycler_view, container, false);
        recyclerViewAdpater = new RecyclerViewAdpater(getContext());
        language = new Language();

        model = ViewModelProviders.of(this).get(Model.class);
        model.getAllLanguage().observe(this, languages -> recyclerViewAdpater.setData(languages));

        if(languageState == true) {
            translate();
        }

        setOnItem();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerview.setLayoutManager(linearLayoutManager);
        binding.recyclerview.setAdapter(recyclerViewAdpater);

        languageState = false;
        return binding.getRoot();
    }

    public void postData(String text,String translate){
        this.text = text;
        this.translate = translate;
        languageState = true;
    }

    public void translate(){
        if(text.trim().length() == 0) return;
        if(translate.trim().length() == 0) return;

        language.setText(text);
        language.setTranslatedText(translate);
        model.insert(language);
    }

    public void setOnItem(){
        recyclerViewAdpater.setOnItemClickListener(new RecyclerViewAdpater.OnItemClickListener() {
            @Override
            public void onItemClick(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, View view, int position,Language language){
                model.deleteUser(language);
            }
        });
    }
}
