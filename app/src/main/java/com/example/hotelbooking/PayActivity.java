package com.example.hotelbooking;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {
    EditText et1;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        et1=findViewById(R.id.etAmount1);
        sp=findViewById(R.id.spinner3);
        Intent intent=getIntent();
        String a;
        if((a=intent.getStringExtra("AAB"))!=null)
        {
            et1.setText(a.toString());
        }
    }
    public void onPay(View view)
    {
            Intent intent = new Intent(PayActivity.this, CardActivity.class);
            intent.putExtra("BBB",et1.getText().toString());
            startActivity(intent);

        }
    public void pay1(View view)
    {

        Toast.makeText(getBaseContext(), "AMOUNT PAID.YOUR HOTEL BOOKING IS CONFIRMED.", Toast.LENGTH_LONG).show();
    }
    public void pay2(View view)
    {
        Toast.makeText(getBaseContext(), "YOUR HOTEL BOOKING IS CONFIRMED.AMOUNT WILL BE COLLECTED DURING CHECK-OUT.", Toast.LENGTH_LONG).show();
    }
    public void run1(View view)
    {
        Intent intent = new Intent(PayActivity.this, Home.class);
        startActivity(intent);

    }
}
