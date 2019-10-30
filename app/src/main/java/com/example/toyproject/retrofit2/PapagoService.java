package com.example.toyproject.retrofit2;

import com.example.toyproject.papagodata.Result;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PapagoService {
    String URL = "https://openapi.naver.com";


    @FormUrlEncoded
    @Headers({
            "Content-Type:application/x-www-form-urlencoded",
            "X-Naver-Client-Id:uFVEVaHRVG49BD1NHJly",
            "X-Naver-Client-Secret:2x15xAOAgn"
    })
    @POST("/v1/papago/n2mt")
    Call<Result> getResult(@FieldMap HashMap<String, Object> param);
}

