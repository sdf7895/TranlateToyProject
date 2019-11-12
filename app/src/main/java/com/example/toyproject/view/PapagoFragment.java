package com.example.toyproject.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.MainActivity;
import com.example.toyproject.MainInterface;
import com.example.toyproject.Present.MyPresent;
import com.example.toyproject.Present.TotalPresent;
import com.example.toyproject.R;
import com.example.toyproject.databinding.PapagoFragmentBinding;


public class PapagoFragment extends Fragment implements TotalPresent.Toshow {
    private PapagoFragmentBinding binding;
    private MyPresent myPresent;
    private MainInterface callback;
    private String change = "en";

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

    public static PapagoFragment newInstance(){
        PapagoFragment papagoFragment = new PapagoFragment();

        return papagoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.papago_fragment,container,false);
        binding.setPapagoFragment(this);
        binding.setActivity((MainActivity)getActivity());

        changeText();

        return binding.getRoot();
    }

    public void setData(View view){
        myPresent = new MyPresent(this);
        myPresent.setData(change,binding.editText.getText().toString());
    }

    public void getData(String change){
        this.change = change;
    }

    @Override
    public void toShow(String text,String translatedata){
        binding.textView2.setText(translatedata);
        callback.setData(text,translatedata);
    }

    public void changeText(){
        switch(change){
            case "en":
                binding.textButton2.setText("영어");
                break;

            case "zh-CN":
                binding.textButton2.setText("중국어(간체)");
                break;

            case "zh-TW":
                binding.textButton2.setText("중국어(번체)");
                break;

            case "es":
                binding.textButton2.setText("스페인어");
                break;

            case "fr":
                binding.textButton2.setText("프랑스어");
                break;

            case "vi":
                binding.textButton2.setText("베트남어");
                break;

            case "th":
                binding.textButton2.setText("태국어");
                break;

            case "id":
                binding.textButton2.setText("인도네시아어");
                break;
        }
    }

}
