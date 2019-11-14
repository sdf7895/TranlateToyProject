package com.example.toyproject.Present;

import com.example.toyproject.Model.retrofit2.Translate;

public class MyPresent implements TotalPresent.GetData {
    private TotalPresent.Toshow toShow;
    Translate translate;

    public MyPresent(TotalPresent.Toshow toShow) {
        this.toShow = toShow;
        translate = new Translate(this);
    }

    public void setData(String setLanguage,String change, String text){
        translate.translatedata(setLanguage,change,text);
    }

    @Override
    public void getData(String text,String data) {
        toShow.toShow(text,data);
    }
}