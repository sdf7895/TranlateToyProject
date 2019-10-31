package com.example.toyproject.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.R;
import com.example.toyproject.databinding.PapagoFragmentBinding;
import com.example.toyproject.retrofit2.Translate;
import com.example.toyproject.view.ViewInterface.ToShow;

import retrofit2.Retrofit;

public class PapagoFragment extends Fragment implements ToShow {
    PapagoFragmentBinding binding;
    Translate translate;

    public static PapagoFragment newInstance(){
        PapagoFragment papagoFragment = new PapagoFragment();

        return papagoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.papago_fragment,container,false);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });

        return binding.getRoot();
    }

    public void setData(){
        translate = new Translate(this);
        translate.translatedata(binding.editText2.getText().toString(),binding.editText.getText().toString());

    }

    public void toShow(String translatedata){
        binding.textView2.setText(translatedata);
    }

}
