package com.example.chemistry;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chemistry.views.AtomView;

import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends AppCompatActivity {
    private final int TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setActionBar();
        List<Integer> shells = new ArrayList<>();
        shells.add(2);
        shells.add(1);
        AtomView atomView = findViewById(R.id.splash_screen_atom_view);
        atomView.setShells(shells);

        setSplash();

    }

    private void setSplash() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }, TIME);
    }

    private void setActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}