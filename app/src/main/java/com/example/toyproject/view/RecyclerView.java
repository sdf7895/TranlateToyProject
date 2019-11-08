package com.example.toyproject.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.Model.Language;
import com.example.toyproject.Model.Model;
import com.example.toyproject.Model.RecyclerView.RecyclerViewAdapter.RecyclerViewAdpater;

import com.example.toyproject.Model.retrofit2.Message;
import com.example.toyproject.Model.retrofit2.Result;
import com.example.toyproject.Model.retrofit2.retrofit2Interface.PapagoService;
import com.example.toyproject.R;
import com.example.toyproject.databinding.RecyclerViewBinding;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RecyclerView extends Fragment {
    private Model model;
    private RecyclerViewBinding binding;
    private RecyclerViewAdpater recyclerViewAdpater;

    public static RecyclerView newInstance() {
        RecyclerView recyclerView = new RecyclerView();

        return recyclerView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.recycler_view, container, false);

        recyclerViewAdpater = new RecyclerViewAdpater(getContext());

        model = ViewModelProviders.of(this).get(Model.class);
        model.getAllLanguage().observe(this, languages -> recyclerViewAdpater.setData(languages));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerview.setLayoutManager(linearLayoutManager);
        binding.recyclerview.setAdapter(recyclerViewAdpater);

        return binding.getRoot();
    }
}
