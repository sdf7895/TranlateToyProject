package com.example.toyproject.Model.retrofit2;

import android.content.Context;
import android.widget.Toast;

import com.example.toyproject.MainActivity;
import com.example.toyproject.Model.retrofit2.retrofit2Interface.PapagoService;
import com.example.toyproject.Model.retrofit2.retrofit2Interface.TranslateService;
import com.example.toyproject.Present.TotalPresent;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Translate implements TranslateService {
    private Retrofit retrofit;
    private TotalPresent.GetData present;

    public Translate(TotalPresent.GetData present) {
        this.present = present;
    }

    @Override
    public void translatedata(String setLanguage,String change, String text){
        retrofit = new Retrofit.Builder()
                .baseUrl(PapagoService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PapagoService papagoService = retrofit.create(PapagoService.class);

        HashMap<String,Object> param = new HashMap<>();
        param.put("source",setLanguage);
        param.put("target",change);
        param.put("text",text);

        papagoService.getResult(param).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    Result result = response.body();
                    Message message = result.getMessage();
                    DetailData detailData = message.getDetailData();
                    present.getData(text,detailData.getTranslatedText());
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }
}
