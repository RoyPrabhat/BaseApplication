package com.example.sqrrlandriodtask.view.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sqrrlandriodtask.R;
import com.example.sqrrlandriodtask.view.breedlist.BreedListActivity;

public class SplashActivity extends AppCompatActivity {

    public static int SLEEP_TIME = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, BreedListActivity.class);
                startActivity(i);
                finish();
            }

        }, SLEEP_TIME);
    }
}
