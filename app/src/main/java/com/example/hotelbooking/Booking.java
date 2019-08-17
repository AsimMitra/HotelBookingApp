package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Booking extends AppCompatActivity {
EditText et6,et7,et8,et9;
Spinner sp1,sp2,sp3,sp4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        et6=findViewById(R.id.etCin);
        et7=findViewById(R.id.etCout);
        et8=findViewById(R.id.etAmount1);
        sp1=findViewById(R.id.spCity);
        sp2=findViewById(R.id.spDay);
        sp3=findViewById(R.id.spRooms);
        sp4=findViewById(R.id.spAdults);
        String cin,cout,cno;
       Intent intent=getIntent();
       if(( cin=intent.getStringExtra("AAA"))!=null)
        {
            et6.setText(cin.toString());
        }


        if((cout=intent.getStringExtra("CCC"))!=null) {
            et7.setText(cout.toString());
        }
        if((cno=intent.getStringExtra("DDD"))!=null) {
            et9.setText(cno.toString());
        }
    }
    public void onCalculate(View view)
    {
        int a,b,amount=0;
        a= Integer.parseInt((String) sp2.getSelectedItem());
        b= Integer.parseInt((String) sp3.getSelectedItem());


        switch(sp1.getSelectedItem().toString())
        {
            case "KOLKATA":
                amount = 4396*a*b;
                break;
            case "MUMBAI":
                amount = 7056*a*b;
                break;
            case "DELHI":
                amount = 7119*a*b;
                break;
            case "BANGALORE":
                amount = 10232*a*b;
                break;
            case "CHENNAI":
                amount = 7986*a*b;
                break;
            case "JAIPUR":
                amount = 7491*a*b ;
                break;
            case "GOA":
                amount = 8395*a*b;
                break;
            case "BHUBANESHWAR":
                amount = 7495*a*b;
            default:
                Toast.makeText(getApplicationContext(), "Enter the city.", Toast.LENGTH_LONG).show();
                sp1.requestFocus();
                return;

        }

        et8.setText(String.valueOf(amount));
    }
    public void onBook(View view)
    {
        if (sp2.getSelectedItem().toString().trim().equals("==SELECT=="))
        {
            Toast.makeText(getApplicationContext(), "Enter number of days.", Toast.LENGTH_LONG).show();
            sp2.requestFocus();
        }
        if (sp3.getSelectedItem().toString().trim().equals("==SELECT=="))
        {
            Toast.makeText(getApplicationContext(), "Enter number of rooms.", Toast.LENGTH_LONG).show();
            sp3.requestFocus();
        }
        if (sp4.getSelectedItem().toString().trim().equals("==SELECT=="))
        {
            Toast.makeText(getApplicationContext(), "Enter number of adults.", Toast.LENGTH_LONG).show();
            sp4.requestFocus();
        }
        if(et8.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Enter all the details above.", Toast.LENGTH_LONG).show();
            sp2.requestFocus();
            return;
        }
        Intent intent = new Intent(Booking.this, PayActivity.class);
        intent.putExtra("AAB",et8.getText().toString());
        startActivity(intent);

    }
    public void onin(View view)
    {
        Intent intent = new Intent(Booking.this, CheckinActivity.class);
        startActivity(intent);

    }
}
