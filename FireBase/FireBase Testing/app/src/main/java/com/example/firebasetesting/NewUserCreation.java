package com.example.firebasetesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class NewUserCreation extends AppCompatActivity {
    Button submit;
    EditText email;
    EditText password;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_creation);
        submit = findViewById(R.id.signUpButton);
        email = findViewById(R.id.signUpEmail);
        password = findViewById(R.id.signUpPassword);
        mAuth = FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                
                mAuth.createUserWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(NewUserCreation.this, "User has been created with the email address " + emailText, Toast.LENGTH_SHORT).show();
                            mAuth.signInWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    startActivity(new Intent(NewUserCreation.this, UserLogged.class));
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(NewUserCreation.this, "There is error while signing in with the created email address log in again", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(NewUserCreation.this, MainActivity.class));
                                }
                            });
                        }else{
                            Toast.makeText(NewUserCreation.this, "There was error while creating new user", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NewUserCreation.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}