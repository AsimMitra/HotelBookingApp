package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }
    public void run(View view) {
        Intent intent=new Intent(UserActivity.this, SigninActivity.class);
        startActivity(intent);

    }
    public void run1(View view) {
        Intent intent=new Intent(UserActivity.this,SignupActivity.class);
        startActivity(intent);

    }
}
