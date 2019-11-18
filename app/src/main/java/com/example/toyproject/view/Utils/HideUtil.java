package com.example.toyproject.view.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.inputmethod.InputMethodManager;



public class HideUtil {
    public static void hide(FragmentManager fragmentManager, Fragment setfragment){
        fragmentManager.beginTransaction()
                       .remove(setfragment)
                       .commit();
        fragmentManager.popBackStack();
    }

    public static void hideKeyboard(Fragment fragment){
        InputMethodManager im = (InputMethodManager) fragment.getActivity().getSystemService(fragment.getActivity().INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(fragment.getActivity().getCurrentFocus().getWindowToken(), 0);
    }
}
