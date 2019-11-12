package com.example.toyproject.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.toyproject.MainInterface;
import com.example.toyproject.R;
import com.example.toyproject.databinding.LanguageSelectViewBinding;
import com.example.toyproject.view.RecyclerViewAdapter.LanguageSelectAdapter;

import java.util.ArrayList;
import java.util.List;

public class LanguageSelectView extends Fragment {
    private LanguageSelectViewBinding languageSelectViewBinding;
    private LanguageSelectAdapter languageSelectAdapter;
    private FragmentManager fragmentManager;
    private List<String> list = new ArrayList<>();

    private MainInterface callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MainInterface){
            callback = (MainInterface) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    public static LanguageSelectView languageSelectView(){
        LanguageSelectView languageSelectView = new LanguageSelectView();

        return languageSelectView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        languageSelectViewBinding = DataBindingUtil.inflate(inflater, R.layout.language_select_view,container,false);
        languageSelectAdapter = new LanguageSelectAdapter(list,getContext());

        list.clear();

        list.add("영어");
        list.add("중국어(간체)");
        list.add("중국어(번체)");
        list.add("스페인어");
        list.add("프랑스어");
        list.add("베트남어");
        list.add("태국어");
        list.add("인도네시아어");

        setOnItem();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        languageSelectViewBinding.recyclerview.setLayoutManager(linearLayoutManager);
        languageSelectViewBinding.recyclerview.setAdapter(languageSelectAdapter);

        return languageSelectViewBinding.getRoot();
    }

    public void setOnItem(){
        languageSelectAdapter.setOnItemClickListener((viewHolder, view, position) -> {
            switch (position){
                case 0:
                    callback.setData("en");
                    hide();
                    break;

                case 1:
                    callback.setData("zh-CN");
                    hide();
                    break;

                case 2:
                    callback.setData("zh-TW");
                    hide();
                    break;

                case 3:
                    callback.setData("es");
                    hide();
                    break;

                case 4:
                    callback.setData("fr");
                    hide();
                    break;

                case 5:
                    callback.setData("vi");
                    hide();
                    break;

                case 6:
                    callback.setData("th");
                    hide();
                    break;

                case 7:
                    callback.setData("id");
                    hide();
                    break;
            }
        });
    }

    public void hide(){
        fragmentManager = getActivity().getSupportFragmentManager();

        fragmentManager.beginTransaction()
                       .remove(LanguageSelectView.this)
                       .commit();
        fragmentManager.popBackStack();
    }
}
