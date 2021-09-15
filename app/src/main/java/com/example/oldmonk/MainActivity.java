package com.example.oldmonk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private ImageButton yoga;
    private ImageButton food;
    private ImageButton calender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Button button1 = (Button) findViewById(R.id.button1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                opensms_activity();
//            }
//        });


        ImageView yoga = (ImageView)findViewById(R.id.yoga);
        yoga.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://isha.sadhguru.org/yoga/yoga_articles_yoga/how-to-do-yoga/"));
                startActivity(intent);
            }
        });



        ImageView food = (ImageView)findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, sms_activity.class);
//                startActivity(intent);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://grofers.com/"));
                startActivity(intent);
            }
        });

        ImageView calender = (ImageView)findViewById(R.id.calender);
        calender.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.drikpanchang.com/calendars/hindu/hinducalendar.html"));
                startActivity(intent);
            }
        });

        ImageView newspaper = (ImageView)findViewById(R.id.newspaper);
        newspaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.jagran.com/"));
                startActivity(intent);
            }
        });

        ImageView button1 = (ImageView)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensms_activity();
            }
        });

        ImageView broadcast = (ImageView)findViewById(R.id.broadcast);
        broadcast.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://peercalls.com/"));
                startActivity(intent);
            }
        });

        ImageView schedule = (ImageView)findViewById(R.id.schedule);
        schedule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://calendly.com/"));
                startActivity(intent);
            }
        });
    }

    private void opensms_activity() {
        Intent intent = new Intent(MainActivity.this, sms_activity.class);
        startActivity(intent);
    }


}
