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
import com.google.firebase.auth.FirebaseUser;
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

        signInClient = GoogleSignIn.getClient(this, signInOptions);

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
                signIn();
            }
        });
        
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignInActivity.this, "Redirecting to facebook signIn", Toast.LENGTH_SHORT).show();
            }
        });

    }
    int RC_SIGN_IN = 65;
    private void signIn(){
        Intent intent = signInClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check condition 
        if (requestCode == RC_SIGN_IN) {
            // When request code is equal to 100 initialize task 
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            // check condition 
            try {
                GoogleSignInAccount account = signInAccountTask.getResult(ApiException.class);
                Toast.makeText(this, "Auht with "+ account.getId(), Toast.LENGTH_SHORT).show();
                firebaseAuthWithGoogle(account.getIdToken());
            }
            catch (ApiException e){
                Log.d("RKTAG", "The error is " + e.toString());
            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken){
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignInActivity.this, "Sign In with credential success", Toast.LENGTH_SHORT).show();
                    Log.d("RKTAG", auth.getCurrentUser().toString());
                    FirebaseUser user = auth.getCurrentUser();

                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                    Toast.makeText(SignInActivity.this, "Signed in successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SignInActivity.this, "There was some error while logging in with credential", Toast.LENGTH_SHORT).show();
                    Log.d("RKTAG", "Some error");
                }
            }
        });
    }
}