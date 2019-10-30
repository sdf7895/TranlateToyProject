package com.example.toyproject;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.databinding.PapagoFragmentBinding;
import com.example.toyproject.papagodata.DetailData;
import com.example.toyproject.papagodata.Message;
import com.example.toyproject.papagodata.Result;
import com.example.toyproject.retrofit2.PapagoService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PapagoFragment extends Fragment {
    Retrofit retrofit;
    PapagoFragmentBinding binding;

    public static PapagoFragment newInstance(){
        PapagoFragment papagoFragment = new PapagoFragment();

        return papagoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.papago_fragment,container,false);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Translate();
            }
        });

        return binding.getRoot();
    }

    private void Translate(){
        retrofit = new Retrofit.Builder()
                .baseUrl(PapagoService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PapagoService papagoService = retrofit.create(PapagoService.class);

        HashMap<String,Object> param = new HashMap<>();
        param.put("source","ko");
        param.put("target",binding.editview2.getText().toString());
        param.put("text",binding.editview.getText().toString());

        papagoService.getResult(param).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    Result result = response.body();
                    Message message = result.getMessage();
                    DetailData detailData = message.getDetailData();
                    binding.textView2.setText(detailData.getTranslatedText());
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                    binding.textView2.setText("Erorr");
            }
        });

    }

}
