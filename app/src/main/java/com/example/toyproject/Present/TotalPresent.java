package com.example.toyproject.Present;

import android.support.v4.app.Fragment;

public interface TotalPresent {

    interface Toshow {
        void toShow(String translatedata);
    }

    interface GetData{
        void getData(String data);
    }



}
