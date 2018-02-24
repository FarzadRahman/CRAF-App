package com.example.craf.craf;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
 static MainActivity main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.main=this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        ImageView iv=findViewById(R.id.logo);
        Animation anime= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        iv.startAnimation(anime);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Thread indexActivity = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
//                  Intent i=new Intent(getApplicationContext(),Index.class);
                    Intent i=new Intent(getApplicationContext(),Home.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                    e.getLocalizedMessage();
                }
            }
        });

        indexActivity.start();
    }
}
