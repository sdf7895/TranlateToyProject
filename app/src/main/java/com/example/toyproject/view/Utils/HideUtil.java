package com.example.toyproject.view.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


public class HideUtil {
    public static void hide(FragmentManager fragmentManager, Fragment setfragment){
        fragmentManager.beginTransaction()
                       .remove(setfragment)
                       .commit();
        fragmentManager.popBackStack();
    }
}
