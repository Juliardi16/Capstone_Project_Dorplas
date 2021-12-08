package com.juliardi.dorplas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.juliardi.dorplas.R;

public class Splashscreen extends AppCompatActivity {
    Session session;

    int duration = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen_activity);

        session = new Session(Splashscreen.this);
        if(session.isLoggedIn()) {
           // moveMainActivity();
        }


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    finish();
                }

        },duration);
    }

    private void moveMainActivity() {
            Intent intent = new Intent(Splashscreen.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            finish();

    }
}
