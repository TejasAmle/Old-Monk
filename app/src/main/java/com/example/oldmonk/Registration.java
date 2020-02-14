package com.example.oldmonk;

import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    public EditText UserName, UserPassword, UserEmail;
    private Button Signin;
    private TextView UserLogin;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIView();
        Signin = (Button)findViewById(R.id.btnSignin);
        UserName=(EditText)findViewById(R.id.etUserName) ;
        UserEmail = (EditText)findViewById(R.id.etUserEmail) ;
        UserPassword=(EditText)findViewById(R.id.etUserPassword) ;
        firebaseAuth = FirebaseAuth.getInstance();


        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result;
                String name = UserName.getText().toString().trim();
                String password = UserPassword.getText().toString().trim();
                String email = UserEmail.getText().toString().trim();
                Log.d("1", "before registration "+ name);
                Log.d("1", "before registration "+ password);
                Log.d("1", "before registration "+ email);

                if (name.isEmpty() || password.isEmpty() || email.isEmpty()){

                    result =false;
                }
                else{

                    result = true;
                }
                if(result){

                    String user_email = UserEmail.getText().toString();
                    String user_password = UserPassword.getText().toString();
                    Log.d("1", "before registration ");
                    firebaseAuth.createUserWithEmailAndPassword(user_email, UserPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Log.d("1", "after registration 1 ");
                                Toast.makeText(Registration.this,"Registration Successful ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Registration.this, Login.class));

                            }
                            else{
                                Log.d("1", "af registration ");
                                Toast.makeText(Registration.this,task.getException()+" ", Toast.LENGTH_SHORT).show();
                                Toast.makeText(Registration.this,"Registration Failed ", Toast.LENGTH_SHORT).show();


                            }

                        }
                    });
                }
                else{
                    Toast.makeText(Registration.this," Failed ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        UserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });
    }




    private void setupUIView (){
        UserName = (EditText) findViewById (R.id.etUserName);
        UserPassword = (EditText) findViewById (R.id.etpassword);
        UserEmail = (EditText) findViewById(R.id.etUserEmail);
        Signin = (Button) findViewById(R.id.btnSignin);
        UserLogin = (TextView) findViewById((R.id.tvUserLogin));

    }

    private Boolean validate(){
        Boolean result;
        String name = UserName.getText().toString().trim();
        String password = UserPassword.getText().toString().trim();
        String email = UserEmail.getText().toString().trim();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Please enter all details!! ", Toast.LENGTH_SHORT ).show();
            result =false;
        }
        else{
            Toast.makeText(this, "Success!! ", Toast.LENGTH_SHORT ).show();
            result = true;
        }
        return result;


    }

}
