package com.example.toyproject.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.Model.NoteRepository.NoteModel;
import com.example.toyproject.view.RecyclerViewAdapter.RecyclerViewAdpater;

import com.example.toyproject.R;
import com.example.toyproject.databinding.RecyclerViewBinding;
import com.example.toyproject.view.Utils.LinearLayoutManagerUtil;


public class RecyclerView extends Fragment {
    private NoteModel model;
    private RecyclerViewBinding binding;
    private RecyclerViewAdpater recyclerViewAdpater;
    public static RecyclerView newInstance(){
        RecyclerView recyclerView = new RecyclerView();

        return recyclerView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.recycler_view, container, false);
        recyclerViewAdpater = new RecyclerViewAdpater(getContext());


        model = ViewModelProviders.of(this).get(NoteModel.class);
        model.getAllLanguage().observe(this, notelanguages -> recyclerViewAdpater.setData(notelanguages));


        LinearLayoutManagerUtil.RecyclerViewUtil(getContext(),binding,recyclerViewAdpater);

        return binding.getRoot();
    }

}
