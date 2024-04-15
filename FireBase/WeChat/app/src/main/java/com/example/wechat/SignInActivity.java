package com.example.wechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignInActivity extends AppCompatActivity {
    FirebaseAuth auth;
    GoogleSignInClient signInClient;

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

        auth = FirebaseAuth.getInstance();

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("826632456220-3ev9bs610hmbgcu7cqf20p9q3v2vnstq.apps.googleusercontent.com")
                .requestEmail().build();

        signInClient = GoogleSignIn.getClient(SignInActivity.this, signInOptions);

        if (auth.getCurrentUser() != null){
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
            finish();
        }
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneEmailStr = emailOrNumber.getText().toString();
                String passwordStr = password.getText().toString();

                auth.signInWithEmailAndPassword(phoneEmailStr, passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignInActivity.this, "Sign in Successful!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignInActivity.this, MainActivity.class));
                        finish();
                    }
                });
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
                Intent intent = signInClient.getSignInIntent();
                startActivityForResult(intent, 100);
            }
        });
        
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignInActivity.this, "Redirecting to facebook signIn", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check condition 
        if (requestCode == 100) {
            // When request code is equal to 100 initialize task 
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            // check condition 
            if (signInAccountTask.isSuccessful()) {
                // When google sign in successful initialize string 
//                String s = "Google sign in successful";
                Toast.makeText(this, "Sign In successfull", Toast.LENGTH_SHORT).show();
                // Display Toast 
//                displayToast(s);
                // Initialize sign in account 
                try {
                    // Initialize sign in account 
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                    // Check condition 
                    if (googleSignInAccount != null) {
                        // When sign in account is not equal to null initialize auth credential 
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                        // Check credential 
                        auth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // Check condition 
                                if (task.isSuccessful()) {
                                    // When task is successful redirect to profile activity display Toast 
                                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
//                                    displayToast("Firebase authentication successful");
                                } else {
                                    // When task is unsuccessful display Toast 
//                                    displayToast("Authentication Failed :" + task.getException().getMessage());
                                    Toast.makeText(SignInActivity.this, "Some error occured", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}