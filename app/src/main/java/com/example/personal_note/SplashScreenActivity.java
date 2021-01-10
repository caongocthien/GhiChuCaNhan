package com.example.personal_note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView myimg;
    TextView mytv;
    Intent homeAct;
    Animation myanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        myimg = (ImageView) findViewById(R.id.noteImg);
        mytv = (TextView) findViewById(R.id.txtSplash);
        myanim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        myimg.startAnimation(myanim);
        mytv.startAnimation(myanim);
        homeAct = new Intent(this, SignUpActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(homeAct);
                finish();
            }
        }, 3000);
    }
}