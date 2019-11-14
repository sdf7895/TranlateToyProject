package com.example.toyproject.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.MainInterface;
import com.example.toyproject.R;
import com.example.toyproject.databinding.LanguageSelectViewBinding;
import com.example.toyproject.view.RecyclerViewAdapter.LanguageSelectAdapter;
import com.example.toyproject.view.Utils.ChangeUtil;
import com.example.toyproject.view.Utils.HideUtil;
import com.example.toyproject.view.Utils.SetLanguageList.ListLanguage;

import java.util.ArrayList;
import java.util.List;

public class ChangeLanguageSelectView extends Fragment {
    private LanguageSelectViewBinding languageSelectViewBinding;
    private LanguageSelectAdapter languageSelectAdapter;
    private FragmentManager fragmentManager;
    private List<String> list = ListLanguage.setList();

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

    public static ChangeLanguageSelectView ChangelanguageSelectView(){
        ChangeLanguageSelectView ChangelanguageSelectView = new ChangeLanguageSelectView();

        return ChangelanguageSelectView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        languageSelectViewBinding = DataBindingUtil.inflate(inflater, R.layout.language_select_view,container,false);
        languageSelectAdapter = new LanguageSelectAdapter(list,getContext());
        fragmentManager = getActivity().getSupportFragmentManager();

        setOnItem();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        languageSelectViewBinding.recyclerview.setLayoutManager(linearLayoutManager);
        languageSelectViewBinding.recyclerview.setAdapter(languageSelectAdapter);

        return languageSelectViewBinding.getRoot();
    }

    public void setOnItem(){
        languageSelectAdapter.setOnItemClickListener((viewHolder, view, position) ->
                {ChangeUtil.selectViewLanguage(callback,position);HideUtil.hide(fragmentManager,this);});
    }
}
