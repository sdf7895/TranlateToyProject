package com.example.toyproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.toyproject.view.PapagoFragment;
import com.example.toyproject.view.RecyclerView;

public class MainActivity extends AppCompatActivity implements MainInterface{
    PapagoFragment papagoFragment;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = RecyclerView.newInstance();
        papagoFragment = PapagoFragment.newInstance();

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

    @Override
    public void setData(String text,String change){
        recyclerView.postData(text,change);
    }

}
