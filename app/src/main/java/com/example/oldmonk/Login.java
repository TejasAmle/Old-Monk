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
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter = 3;
    private TextView userRegistartion;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Name = (EditText) findViewById(R.id.etname);
        Password = (EditText) findViewById(R.id.etpassword);
        Log.d("1", "before registration " + Name);
        Log.d("1", "before registration " + Password);
        Info = (TextView) findViewById(R.id.tvinfo);
        Login = (Button) findViewById(R.id.btnlogin);
        userRegistartion = (TextView) findViewById(R.id.tvNewUser);
        mAuth = FirebaseAuth.getInstance();
        Info.setText("No. of attempts remaining : 3");


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        userRegistartion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registration.class));
            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        } else {
            counter--;

            mAuth.signInWithEmailAndPassword(userName, userPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("1", "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("1", "signInWithEmail:failure", task.getException());
                                Toast.makeText(Login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });


            Info.setText("No. of attempts remaining : " + String.valueOf(counter));


            if (counter == 0) {
                Login.setEnabled(false);
            }
        }
    }
}
