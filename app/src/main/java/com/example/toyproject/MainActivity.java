package com.example.toyproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.toyproject.databinding.PapagoFragmentBinding;

public class MainActivity extends AppCompatActivity {
    PapagoFragment papagoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        papagoFragment = PapagoFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment,papagoFragment)
                .commit();

    }
}
