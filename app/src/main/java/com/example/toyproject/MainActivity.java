package com.example.toyproject;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.toyproject.view.RecyclerView;
import com.example.toyproject.view.PapagoFragment;

public class MainActivity extends AppCompatActivity{
    PapagoFragment papagoFragment;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        papagoFragment = PapagoFragment.newInstance();
        recyclerView = RecyclerView.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment,papagoFragment)
                .commit();

    }

    public void setFragment(View view){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment,recyclerView)
                .addToBackStack(null)
                .commit();
    }

}
