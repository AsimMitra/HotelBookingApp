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

public class SignupActivity extends AppCompatActivity {
    private static final String TAG ="SignupActivity" ;
    EditText et1,et3,et4,et5,et7,et8;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et1 = findViewById(R.id.etName);
        et3 = findViewById(R.id.etUsername);
        et4 = findViewById(R.id.etAge);
        et5 = findViewById(R.id.etMail);
        et7 = findViewById(R.id.etPassword);
        et8 = findViewById(R.id.etConfirmPassword);
        b1 = findViewById(R.id.bUp);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        b1.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = et3.getText().toString();
        String email = et5.getText().toString();
        String password = et7.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }
    public void onSignupSuccess() {
        b1.setEnabled(true);
        setResult(RESULT_OK, null);
        Intent intent=new Intent(SignupActivity.this,UserActivity.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(), "Account created successfully", Toast.LENGTH_LONG).show();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Account creation failed", Toast.LENGTH_LONG).show();

        b1.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = et3.getText().toString();
        String email = et5.getText().toString();
        String password = et7.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            et3.setError("at least 3 characters");
            valid = false;
        } else {
            et3.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et5.setError("enter a valid email address");
            valid = false;
        } else {
            et5.setError(null);
        }

        if (password.isEmpty() || password.length() < 5 || password.length() > 10) {
            et7.setError("between 5 and 10 alphanumeric characters");
            valid = false;
        } else {
            et7.setError(null);
        }

        return valid;
    }
    public void run(View view) {
        Intent intent=new Intent(SignupActivity.this, UserActivity.class);
        startActivity(intent);

    }
}
