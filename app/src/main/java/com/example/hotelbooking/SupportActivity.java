package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
    }
    public void run(View view) {
        Intent intent=new Intent(SupportActivity.this, Home.class);
        startActivity(intent);
        finish();
    }
    public void issue(View view)
    {
        Toast.makeText(getBaseContext(), "We have recorded your issue. We'll look into the matter and try to solve your problem as soon as possible.", Toast.LENGTH_LONG).show();
    }
}
