
package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hotel3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel3);
    }
    public void Book(View view)
    {
        Intent intent = new Intent(Hotel3Activity.this, Booking.class);
        startActivity(intent);

    }
    public void Back(View view)
    {
        Intent intent = new Intent(Hotel3Activity.this, Home.class);
        startActivity(intent);
    }
}