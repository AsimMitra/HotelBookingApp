package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CheckinActivity extends AppCompatActivity {
    DatePicker picker, picker2;
    Button displayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        picker = findViewById(R.id.datePicker);
        picker2 = findViewById(R.id.datePicker2);
        picker.setMinDate(System.currentTimeMillis() - 1000);
        picker2.setMinDate(System.currentTimeMillis() - 1000);
        displayDate =findViewById(R.id.button1);
        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CheckinActivity.this, Booking.class);
                intent.putExtra("AAA", getCurrentDate());
                intent.putExtra("CCC", getCurrentDate2());
                startActivity(intent);
            }

        });

    }
/*   public int getCountOfDays() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        Date createdConvertedDate = null, expireCovertedDate = null, todayWithZeroTime = null;
        try {
            createdConvertedDate = dateFormat.parse(getCurrentDate());
            expireCovertedDate = dateFormat.parse(getCurrentDate2());

            Date today = new Date();

            todayWithZeroTime = dateFormat.parse(dateFormat.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int cYear = 0, cMonth = 0, cDay = 0;

        if (createdConvertedDate.after(todayWithZeroTime))
        {
            Calendar cCal = Calendar.getInstance();
            cCal.setTime(createdConvertedDate);
            cYear = cCal.get(Calendar.YEAR);
            cMonth = cCal.get(Calendar.MONTH);
            cDay = cCal.get(Calendar.DAY_OF_MONTH);

        }
        else
            {
            Calendar cCal = Calendar.getInstance();
            cCal.setTime(todayWithZeroTime);
            cYear = cCal.get(Calendar.YEAR);
            cMonth = cCal.get(Calendar.MONTH);
            cDay = cCal.get(Calendar.DAY_OF_MONTH);
        }
        Calendar eCal = Calendar.getInstance();
        eCal.setTime(expireCovertedDate);

        int eYear = eCal.get(Calendar.YEAR);
        int eMonth = eCal.get(Calendar.MONTH);
        int eDay = eCal.get(Calendar.DAY_OF_MONTH);

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        date1.clear();
        date1.set(cYear, cMonth, cDay);
        date2.clear();
        date2.set(eYear, eMonth, eDay);

        long diff = date2.getTimeInMillis() - date1.getTimeInMillis();

        float dayCount = (float) diff / (24 * 60 * 60 * 1000);

        return ((int) dayCount);
    } */


        public String getCurrentDate() {
        StringBuilder builder = new StringBuilder();
        ;
        builder.append(picker.getDayOfMonth() + "/");
        builder.append((picker.getMonth() + 1) + "/");//month is 0 based
        builder.append(picker.getYear());
        return builder.toString();
    }

    public String getCurrentDate2() {
        StringBuilder builder = new StringBuilder();
        ;
        builder.append(picker2.getDayOfMonth() + "/");
        builder.append((picker2.getMonth() + 1) + "/");//month is 0 based
        builder.append(picker2.getYear());
        return builder.toString();
    }
}
