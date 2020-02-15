package com.example.oldmonk;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class sms_activity extends AppCompatActivity{
    final  int SEND_SMS_PERMISSION_REQUEST_CODE = 1;
    EditText number;
    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        //number = findViewById(R.id.inputNumber);
        message = findViewById(R.id.inputMessage);
        send = findViewById(R.id.buttonSend);

        send.setEnabled (false);
        if(checkPermission(Manifest.permission.SEND_SMS)){
            send.setEnabled(true);
        }else{
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_REQUEST_CODE);
        }
    }


    public void onSend(View v){
        String phoneNumber = "8299219584";
        String smsMessage = message.getText().toString();

        if(checkPermission(Manifest.permission.SEND_SMS)){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber,null,smsMessage,null,null);
            Toast.makeText(this,    "Msg sent", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,    "Permission Denied", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this,permission);
        return (check== PackageManager.PERMISSION_GRANTED);
    }
}