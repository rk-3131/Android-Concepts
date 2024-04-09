package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        EditText emailOrNumber = findViewById(R.id.signInEmail);
        EditText password = findViewById(R.id.signInPassword);
        TextView signUpButton = findViewById(R.id.signUpLink);
        Button signIn = findViewById(R.id.signInButton);
        Button google = findViewById(R.id.googleSignIn);
        Button facebook = findViewById(R.id.facebookSignIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneEmailStr = emailOrNumber.getText().toString();
                String passwordStr = password.getText().toString();

                Toast.makeText(SignInActivity.this, "Email / Phone " + phoneEmailStr, Toast.LENGTH_SHORT).show();
            }
        });
        
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignInActivity.this, "Redirecting to google signIn", Toast.LENGTH_SHORT).show();
            }
        });
        
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignInActivity.this, "Redirecting to facebook signIn", Toast.LENGTH_SHORT).show();
            }
        });

    }
}