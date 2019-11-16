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
import com.example.toyproject.view.ChangeLanguageSelectView;
import com.example.toyproject.view.PapagoFragment;
import com.example.toyproject.view.RecyclerView;
import com.example.toyproject.view.SetLanguageSelectView;
import com.example.toyproject.view.Utils.ObserveUtil;

public class MainActivity extends AppCompatActivity implements MainInterface, NavigationView.OnNavigationItemSelectedListener {
    private PapagoFragment papagoFragment;
    private RecyclerView recyclerView;
    private ChangeLanguageSelectView changeLanguageSelectView;
    private SetLanguageSelectView setLanguageSelectView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView = RecyclerView.newInstance();
        papagoFragment = PapagoFragment.newInstance();
        changeLanguageSelectView = ChangeLanguageSelectView.ChangelanguageSelectView();
        setLanguageSelectView = SetLanguageSelectView.setLanguageSelectView();

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("번역");
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

    private void startFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, papagoFragment)
                .commit();
    }

    private void setFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, recyclerView)
                .addToBackStack(null)
                .commit();
    }

    public void setSeletFragment(View view) {
        binding.toolbar.setTitle("도착언어");
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.translate_down,R.anim.translate_up,R.anim.translate_down,R.anim.translate_up)
                .replace(R.id.fragment, changeLanguageSelectView)
                .addToBackStack(null)
                .commit();
    }

    public void setSeletFragment2(View view) {
        binding.toolbar.setTitle("출발언어");
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.translate_down,R.anim.translate_up,R.anim.translate_down,R.anim.translate_up)
                .replace(R.id.fragment, setLanguageSelectView)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void setData(String change) {papagoFragment.getData(change);}

    @Override
    public void setData2(String setLanguage) {papagoFragment.getData2(setLanguage);}

}


