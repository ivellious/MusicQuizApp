package com.michalpomiecko.musicquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Main activity holding menu fragment*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        MainMenuFragment mainMenuFragment = new MainMenuFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.mainFragmentContainer, mainMenuFragment).commit();


    }
}
