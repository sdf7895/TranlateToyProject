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
import com.example.toyproject.view.Utils.AnimationUtil;
import com.example.toyproject.view.Utils.ChangeUtil;

public class PapagoFragment extends Fragment implements TotalPresent.Toshow {
    private PapagoFragmentBinding binding;
    private MyPresent myPresent;
    private MainInterface callback;
    private String changeLanguage = "en";
    private String setLanguage ="ko";

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

        ChangeUtil.changeText(setLanguage,binding);
        ChangeUtil.changeText2(changeLanguage,binding);

        return binding.getRoot();
    }

    public void setData(View view){
        myPresent = new MyPresent(this);
        myPresent.setData(setLanguage,changeLanguage,binding.editText.getText().toString());
    }

    public void getData(String changeLanguage){this.changeLanguage = changeLanguage;}
    public void getData2(String setLanguage){this.setLanguage = setLanguage;}

    @Override
    public void toShow(String text,String translatedata){
        binding.textView2.setText(translatedata);
        callback.setData(text,translatedata); //메인액티비티에게 데이터를 전달하는 역할 잠깐 keep

        binding.languagewindow.startAnimation(AnimationUtil.AlpahAnimationutil());
        binding.languagewindow.setVisibility(View.VISIBLE);
    }

}
