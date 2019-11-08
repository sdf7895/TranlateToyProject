package com.example.toyproject.Present;

import com.example.toyproject.Model.retrofit2.Translate;
import com.example.toyproject.view.RecyclerView;

public class MyPresent implements TotalPresent.GetData {
    private TotalPresent.Toshow toShow;
    private Translate translate;
    private RecyclerView recyclerView;

    public MyPresent(TotalPresent.Toshow toShow) {
        this.toShow = toShow;
        translate = new Translate(this);
        recyclerView = RecyclerView.newInstance();
    }

    public void setData(String change, String text){
        translate.translatedata(change,text);
    }

    @Override
    public void getData(String data) {
        toShow.toShow(data);
    }
}
