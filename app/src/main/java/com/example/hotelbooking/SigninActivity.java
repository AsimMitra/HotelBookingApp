package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    private static final String TAG ="SigninActivity" ;
    private static final int REQUEST_SIGNUP = 0;
    EditText et1,et2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        et1 = findViewById(R.id.etName1);
        et2 = findViewById(R.id.etPassword1);
        b1=findViewById(R.id.bLogin);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {
        et1.requestFocus();
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        b1.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SigninActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = et1.getText().toString();
        String password = et2.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        b1.setEnabled(true);
        Intent intent=new Intent(SigninActivity.this,Home.class);
        startActivity(intent);
        finish();
        Toast.makeText(getBaseContext(), "Logged in", Toast.LENGTH_LONG).show();
        et1.setText(null);
        et2.setText(null);
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        b1.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = et1.getText().toString();
        String password = et2.getText().toString();

        if (email.isEmpty()) {
            et1.setError("Enter a user name.");
            valid = false;
        } else {
            et1.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            et2.setError("between 5 and 10 alphanumeric characters");
            valid = false;
        } else {
            et2.setError(null);
        }
        return valid;
    }
    public void run2(View view) {
        Intent intent=new Intent(SigninActivity.this,SignupActivity.class);
        startActivity(intent);

    }
}
