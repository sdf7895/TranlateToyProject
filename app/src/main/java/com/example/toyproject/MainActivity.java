package com.example.toyproject;

import android.databinding.DataBindingUtil;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.toyproject.databinding.ActivityMainBinding;
import com.example.toyproject.view.LanguageSelectView;
import com.example.toyproject.view.PapagoFragment;
import com.example.toyproject.view.RecyclerView;

public class MainActivity extends AppCompatActivity implements MainInterface, NavigationView.OnNavigationItemSelectedListener {
    PapagoFragment papagoFragment;
    RecyclerView recyclerView;
    LanguageSelectView languageSelectView;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView = RecyclerView.newInstance();
        papagoFragment = PapagoFragment.newInstance();
        languageSelectView = LanguageSelectView.languageSelectView();

        binding.toolbar.setTitle("번역");
        setSupportActionBar(binding.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        binding.navView.setNavigationItemSelectedListener(this);

        startFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {return true;}

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_1) {binding.toolbar.setTitle("번역");startFragment();}
        else if (id == R.id.nav_2) {binding.toolbar.setTitle("번역노트");setFragment();}

        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    public void startFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, papagoFragment)
                .commit();
    }

    public void setFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, recyclerView)
                .addToBackStack(null)
                .commit();
    }

    public void setSeletFragment(View view) {
        binding.toolbar.setTitle("모든언어");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, languageSelectView)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void setData(String text, String change) {recyclerView.postData(text, change);}

    @Override
    public void setData(String change) {papagoFragment.getData(change);}
}


