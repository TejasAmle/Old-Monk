package com.example.oldmonk;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();


        LogoLauncher logolauncher = new LogoLauncher();
        logolauncher.start();
    }

    private class LogoLauncher extends Thread{
        public void run(){
            try{
                sleep(3000);
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            Intent intent = new Intent(Activity_Splash.this , Login.class);
            startActivity(intent);
            Activity_Splash.this.finish();
        }
    }
}
