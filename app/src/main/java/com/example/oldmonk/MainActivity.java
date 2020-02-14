package com.example.oldmonk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    }
}
