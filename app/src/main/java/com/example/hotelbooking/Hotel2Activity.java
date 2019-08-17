package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hotel2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel2);
    }
    public void Book(View view)
    {
        Intent intent = new Intent(Hotel2Activity.this, Booking.class);
        startActivity(intent);
        finish();
    }
    public void Back(View view)
    {
        Intent intent = new Intent(Hotel2Activity.this, Home.class);
        startActivity(intent);
        finish();
    }
}
