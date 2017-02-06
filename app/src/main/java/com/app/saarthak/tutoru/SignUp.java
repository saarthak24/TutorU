package com.app.saarthak.tutoru;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.Arrays;

public class SignUp extends AppCompatActivity {

    private EditText meditText_full_name;
    private EditText meditText_username;
    private EditText meditText_email;
    private EditText meditText_subjects;
    private EditText meditText_password;
    private EditText meditText_confirm_password;
    private Button mbutton_sign_up;

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        meditText_full_name = (EditText) findViewById(R.id.editText_full_name);
        meditText_username = (EditText) findViewById(R.id.editText_username);
        meditText_email = (EditText) findViewById(R.id.editText_email);
        meditText_subjects = (EditText) findViewById(R.id.editText_subjects);
        meditText_password = (EditText) findViewById(R.id.editText_password);
        meditText_confirm_password = (EditText) findViewById(R.id.editText_confirm_password);
        mbutton_sign_up = (Button) findViewById(R.id.button_sign_up);

        meditText_full_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        meditText_username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        meditText_email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        meditText_subjects.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        meditText_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        meditText_confirm_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        mbutton_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!meditText_full_name.getText().toString().contains(" "))
                    meditText_full_name.setError("Not a full name");
                else if (meditText_full_name.getText().toString().isEmpty())
                    meditText_full_name.setError("Required.");
                else if (meditText_username.getText().toString().isEmpty())
                    meditText_username.setError("Required.");
                else if(!meditText_email.getText().toString().contains("@"))
                    meditText_email.setError("Not an email.");
                else if(!meditText_email.getText().toString().contains("."))
                    meditText_email.setError("Not an email.");
                else if (meditText_email.getText().toString().isEmpty())
                    meditText_email.setError("Required.");
                else if (meditText_password.getText().toString().isEmpty())
                    meditText_password.setError("Required.");
                else if (meditText_confirm_password.getText().toString().isEmpty())
                    meditText_confirm_password.setError("Please confirm your password");
                else if (!(meditText_password.getText().toString().equals(meditText_confirm_password.getText().toString()))) {
                    meditText_confirm_password.setText("");
                    meditText_confirm_password.setError("Passwords do not match");
                }
                else {
                    TelephonyManager telemamanger = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                    String getSimSerialNumber = telemamanger.getLine1Number();
                    ArrayList<String> subjectList = new ArrayList<String>(Arrays.asList(meditText_subjects.getText().toString().split("\\r?\\n")));
                    Firebase.setAndroidContext(SignUp.this);
                    Tutor tempTutor = new Tutor(meditText_full_name.getText().toString(), meditText_email.getText().toString(), meditText_username.getText().toString(), getSimSerialNumber, meditText_password.getText().toString(), subjectList);
                    Firebase ref = new Firebase(Config.FIREBASE_URL);
                    ref.child(tempTutor.getmfullName()).setValue(tempTutor);
                    Intent i = new Intent(SignUp.this, LogIn.class);
                    startActivity(i);
                }
            }
        });
    }
}
