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
    PapagoFragmentBinding binding;
    MyPresent myPresent;
    MainInterface callback;

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

        return binding.getRoot();
    }

    public void setData(View view){
        myPresent = new MyPresent(this);
        myPresent.setData(binding.editText2.getText().toString(),binding.editText.getText().toString());
        callback.setData(binding.editText2.getText().toString(),binding.editText.getText().toString());
    }

    @Override
    public void toShow(String translatedata){
        binding.textView2.setText(translatedata);
    }

}
