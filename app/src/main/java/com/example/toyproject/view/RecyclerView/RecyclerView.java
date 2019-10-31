package com.example.toyproject.view.RecyclerView;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.R;
import com.example.toyproject.databinding.RecyclerViewBinding;

public class RecyclerView extends Fragment {
    RecyclerViewBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.recycler_view,container,false);



        return binding.getRoot();
    }
}
