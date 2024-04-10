package com.example.wechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText name = findViewById(R.id.signUpName);
        EditText email = findViewById(R.id.signInEmail);
        EditText password = findViewById(R.id.signInPassword);
        TextView signIn = findViewById(R.id.signUpLink);
        Button signUpButton = findViewById(R.id.signInButton);
        Button googleSignup = findViewById(R.id.googleSignIn);
        Button facebookSignup = findViewById(R.id.facebookSignIn);
        TextView phoneSignup = findViewById(R.id.phoneSignUp);

        auth = FirebaseAuth.getInstance();


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString();
                String emailStr = email.getText().toString();
                String passwordStr = password.getText().toString();

//                Toast.makeText(SignUpActivity.this, "Email " + emailStr + " and Name: " + nameStr, Toast.LENGTH_SHORT).show();

                auth.createUserWithEmailAndPassword(emailStr, passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "User has been created", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(SignUpActivity.this, "There was some error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUpActivity.this, "Exception " + e.toString(), Toast.LENGTH_SHORT).show();
                        Log.d("RKTAG", e.toString());
                    }
                });

            }
        });
        
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(SignUpActivity.this, "Page will be redirected to sign in email", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
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