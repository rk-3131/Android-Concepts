package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText name = findViewById(R.id.signUpName);
        EditText email = findViewById(R.id.signUpEmail);
        EditText password = findViewById(R.id.signUpPassword);
        TextView signIn = findViewById(R.id.signInLink);
        Button signUpButton = findViewById(R.id.signUpButton);
        Button googleSignup = findViewById(R.id.googleSignUp);
        Button facebookSignup = findViewById(R.id.facebookSignUp);
        TextView phoneSignup = findViewById(R.id.phoneSignUp);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString();
                String emailStr = email.getText().toString();
                String passwordStr = password.getText().toString();

                Toast.makeText(SignUpActivity.this, "Email " + emailStr + " and Name: " + nameStr, Toast.LENGTH_SHORT).show();
            }
        });
        
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this, "Page will be redirected to sign in email", Toast.LENGTH_SHORT).show();
            }
        });
        
        googleSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this, "Page will be redirected to sign in with google", Toast.LENGTH_SHORT).show();
            }
        });
        
        facebookSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this, "Now it will be redirected to the sign in with facebook", Toast.LENGTH_SHORT).show();
            }
        });
        
        phoneSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this, "Page will be redirected to sign in with phone number", Toast.LENGTH_SHORT).show();
            }
        });

    }
}