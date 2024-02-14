package com.cscorner.appointment_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.cscorner.appointment_app.home.HomePage;
import com.cscorner.appointment_app.home.SignIn;
import com.cscorner.appointment_app.home.login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences(login.PREFS_NAME, 0);
                boolean hassLoggedIn = sharedPreferences.getBoolean("hasLoggedIn", false);

                if (hassLoggedIn){
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent i = new Intent(MainActivity.this, SignIn.class);
                    startActivity(i);
                }
            }
        },1500);
    }
}