package com.example.toyproject.Present;

import com.example.toyproject.retrofit2.Translate;

public class MyPresent implements TotalPresent.GetData {
    TotalPresent.Toshow toShow;
    Translate translate;

    public MyPresent(TotalPresent.Toshow toShow) {
        this.toShow = toShow;
        translate = new Translate(this);
    }

    public void setData(String change, String text){
        translate.translatedata(change,text);
    }

    @Override
    public void getData(String data) {
        toShow.toShow(data);
    }
}
