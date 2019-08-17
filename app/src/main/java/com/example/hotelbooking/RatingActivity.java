package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {
    RatingBar r1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        r1=(RatingBar)findViewById(R.id.rbRating);
        b1=(Button)findViewById(R.id.bSubmit);
        //Performing action on Button Click
        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                //Getting the rating and displaying it on the toast
                String rating=String.valueOf(r1.getRating());
                Toast.makeText(getApplicationContext(), "You rated us "+rating+". THANK YOU for submitting your review.", Toast.LENGTH_LONG).show();
            }

        });
    }
    public void run(View view) {
        Intent intent=new Intent(RatingActivity.this, Home.class);
        startActivity(intent);
        finish();
    }
}
