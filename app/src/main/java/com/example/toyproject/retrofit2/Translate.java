package com.example.toyproject.retrofit2;

import com.example.toyproject.Present.TotalPresent;
import com.example.toyproject.retrofit2.retrofit2Interface.PapagoService;
import com.example.toyproject.retrofit2.retrofit2Interface.TranslateService;


import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Translate implements TranslateService {
    Retrofit retrofit;
    TotalPresent.GetData present;

    public Translate(TotalPresent.GetData present) {
        this.present = present;
    }

    public void translatedata(String change, String text){
        retrofit = new Retrofit.Builder()
                .baseUrl(PapagoService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PapagoService papagoService = retrofit.create(PapagoService.class);

        HashMap<String,Object> param = new HashMap<>();
        param.put("source","ko");
        param.put("target",change);
        param.put("text",text);

        papagoService.getResult(param).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    Result result = response.body();
                    Message message = result.getMessage();
                    DetailData detailData = message.getDetailData();
                    present.getData(detailData.getTranslatedText());
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

    }
}
