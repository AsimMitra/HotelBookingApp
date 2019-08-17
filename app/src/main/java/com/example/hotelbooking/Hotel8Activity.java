package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hotel8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel8);
    }
    public void Book(View view)
    {
        Intent intent = new Intent(Hotel8Activity.this, Booking.class);
        startActivity(intent);

    }
    public void Back(View view)
    {
        Intent intent = new Intent(Hotel8Activity.this, Home.class);
        startActivity(intent);

    }
}
