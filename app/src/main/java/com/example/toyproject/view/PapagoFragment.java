package com.example.toyproject.view;

import android.arch.lifecycle.ViewModel;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.Present.MyPresent;
import com.example.toyproject.Present.TotalPresent;
import com.example.toyproject.R;
import com.example.toyproject.databinding.PapagoFragmentBinding;
import com.example.toyproject.retrofit2.Translate;


public class PapagoFragment extends Fragment implements TotalPresent.Toshow {
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
        MyPresent myPresent = new MyPresent(this);
        myPresent.setData(binding.editText2.getText().toString(),binding.editText.getText().toString());
    }

    public void toShow(String translatedata){
        binding.textView2.setText(translatedata);
    }

}
