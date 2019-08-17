package com.example.hotelbooking;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Spinner sp;
//EditText et7;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);
        sp = findViewById(R.id.spCity);
        // et7=findViewById(R.id.etUser);
        // Bundle bundle = getIntent().getExtras();
        // String message = bundle.getString("message");
        //et7.setText(message);
        builder = new AlertDialog.Builder(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        switch (sp.getSelectedItem().toString()) {
            default:
                Toast.makeText(getBaseContext(), "Enter a city.", Toast.LENGTH_LONG).show();
                break;
        }
    }
      /*  imageView = (ImageView) this.findViewById(R.id.imageView1);
        Button photoButton = (Button) this.findViewById(R.id.button1);
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (requestCode == CAMERA_REQUEST) {
           Bitmap photo = (Bitmap) data.getExtras().get("data");
           imageView.setImageBitmap(photo);
       }
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu., menu);
        return true;
    }*/
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
         if (id == R.id.nav_booking) {
            Intent intent=new Intent(Home.this, Booking.class);
            startActivity(intent);
        } else if (id == R.id.nav_payment) {
            Intent intent=new Intent(Home.this, PayActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_support) {
            Intent intent=new Intent(Home.this, SupportActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_feedback)
        {
            Intent intent=new Intent(Home.this, RatingActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_logout){
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

            //Setting message manually and performing action on button click
            builder.setMessage("Are you sure you want to logout?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(),"logged out successfully.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Home.this, SigninActivity.class);
                            startActivity(intent);

                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            dialog.cancel();
                        }
                    });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("LOG OUT");
            alert.show();

        }else if (id == R.id.nav_faq)
        {
            Intent intent=new Intent(Home.this, FAQActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_aboutapp) {

            Intent intent=new Intent(Home.this, AboutActivity.class);
            startActivity(intent);

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void run1(View view) {
        if(sp.getSelectedItem().toString().equals("KOLKATA")) {
            Intent intent = new Intent(Home.this, Hotel1Activity.class);
            startActivity(intent);

        }
        if(sp.getSelectedItem().toString().equals("MUMBAI")) {
            Intent intent = new Intent(Home.this, Hotel2Activity.class);
            startActivity(intent);

        }
        if(sp.getSelectedItem().toString().equals("DELHI")) {
            Intent intent = new Intent(Home.this, Hotel3Activity.class);
            startActivity(intent);

        }
        if(sp.getSelectedItem().toString().equals("BANGALORE")) {
            Intent intent = new Intent(Home.this, Hotel4Activity.class);
            startActivity(intent);

        }
        if(sp.getSelectedItem().toString().equals("CHENNAI")) {
            Intent intent = new Intent(Home.this, Hotel5Activity.class);
            startActivity(intent);

        }
        if(sp.getSelectedItem().toString().equals("JAIPUR")) {
            Intent intent = new Intent(Home.this, Hotel6Activity.class);
            startActivity(intent);

        }
        if(sp.getSelectedItem().toString().equals("GOA")) {
            Intent intent = new Intent(Home.this, Hotel7Activity.class);
            startActivity(intent);

        }
        if(sp.getSelectedItem().toString().equals("BHUBANESHWAR")) {
            Intent intent = new Intent(Home.this, Hotel8Activity.class);
            startActivity(intent);

        }
    }
}
