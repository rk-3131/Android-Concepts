package com.example.wechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wechat.Adapters.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    ViewPager myPager;
    TabLayout myTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() == null){
            startActivity(new Intent(MainActivity.this, SignInActivity.class));
        }

        myPager = findViewById(R.id.viewPager);
        myTabLayout = findViewById(R.id.tabLayout);

        myPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        myTabLayout.setupWithViewPager(myPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int ansId = item.getItemId();

        if (ansId == R.id.menuSetting){
            Toast.makeText(this, "Settings menu clicked", Toast.LENGTH_SHORT).show();
        }else if (ansId == R.id.menuLogout){
            auth.signOut();
            startActivity(new Intent(MainActivity.this, SignInActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}