package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CardActivity extends AppCompatActivity {
    EditText et10, et1, et2, et3;
Spinner sp1,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        et10 = findViewById(R.id.etAmount1);
        et1 = findViewById(R.id.editText3);
        et2 = findViewById(R.id.editText4);
        et3 = findViewById(R.id.editText5);
        sp1 = findViewById(R.id.spinner2);
        sp2=findViewById(R.id.spinner);
        Intent intent = getIntent();
        String a = intent.getStringExtra("BBB");
        et10.setText(a.toString());
    }

    public void pay1(View view) {
        if (!validate()) {
            Toast.makeText(getBaseContext(), "Payment failed.", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(getBaseContext(), "AMOUNT PAID.YOUR HOTEL BOOKING IS CONFIRMED.", Toast.LENGTH_LONG).show();
    }
    public void back(View view)
    {
        Intent intent = new Intent(CardActivity.this, Home.class);
        startActivity(intent);
    }

    public boolean validate() {
        boolean valid = true;

        String cardno = et1.getText().toString();
        String cardname = et2.getText().toString();
        String cvv = et3.getText().toString();

        if (cardno.isEmpty() || cardno.length() >16|| cardno.length()<16) {
            et1.setError("card number should be of 16 digits.");
            valid = false;
        } else {
            et1.setError(null);
        }

        if (cardname.isEmpty()) {
            et2.setError("enter a valid name");
            valid = false;
        } else {
            et2.setError(null);
        }

        if (cvv.isEmpty() || cvv.length() <3 || cvv.length() >3) {
            et3.setError("cvv should be of 3 digits.");
            valid = false;
        } else {
            et3.setError(null);
        }

        return valid;
    }
}



