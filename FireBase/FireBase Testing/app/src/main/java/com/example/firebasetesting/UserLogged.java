package com.example.firebasetesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserLogged extends AppCompatActivity {
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_logged);

        message = findViewById(R.id.messageText);
        FirebaseAuth auth = FirebaseAuth.getInstance();

        Button logOut = findViewById(R.id.logoutButton);


        message.setText("You are here that means you are logged in");

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = auth.getCurrentUser();
                user = null;
                auth.signOut();
                Toast.makeText(UserLogged.this, "User has been logged out successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserLogged.this, MainActivity.class));
            }
        });
    }

}