package com.example.toyproject.Model.RecyclerView;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.Model.Language;
import com.example.toyproject.Model.Model;
import com.example.toyproject.R;
import com.example.toyproject.databinding.RecyclerViewBinding;
import com.example.toyproject.view.PapagoFragment;

import java.util.List;

public class RecyclerView extends Fragment {
    private Model model;
    RecyclerViewBinding binding;
    RecyclerViewAdpater recyclerViewAdpater;

    public static RecyclerView newInstance(){
        RecyclerView recyclerView = new RecyclerView();

        return recyclerView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.recycler_view,container,false);

        model = ViewModelProviders.of(this).get(Model.class);
        model.getAllLanguage().observe(this, new Observer<List<Language>>() {
            @Override
            public void onChanged(@Nullable List<Language> languages) {
                recyclerViewAdpater = new RecyclerViewAdpater(getContext());
                recyclerViewAdpater.setData(languages);
            }
        });

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerview.setAdapter(recyclerViewAdpater);

        return binding.getRoot();
    }

    public void setLanguage(String text,String text2){
        if(text.trim().length() == 0)
            return;

        if(text2.trim().length() == 0)
            return;

        try{
            Language language = new Language();
            language.setLanguage(text);
            language.setLanguage2(text2);

            model.insert(language);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
