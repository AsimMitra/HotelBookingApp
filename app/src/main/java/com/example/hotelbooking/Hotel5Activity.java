package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hotel5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel5);
    }
    public void Book(View view)
    {
        Intent intent = new Intent(Hotel5Activity.this, Booking.class);
        startActivity(intent);
        finish();
    }
    public void Back(View view)
    {
        Intent intent = new Intent(Hotel5Activity.this, Home.class);
        startActivity(intent);
        finish();
    }
}
