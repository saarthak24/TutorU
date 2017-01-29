package com.app.saarthak.tutoru;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    private ImageView mlogin_logo;
    private TextView mtext_signup;
    private LinearLayout meditText_layout;
    private EditText meditText_email;
    private EditText meditText_password;
    private Button mbutton_login;

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log_in);

            mlogin_logo = (ImageView) findViewById(R.id.login_logo);
            mtext_signup = (TextView) findViewById(R.id.text_signup);
            meditText_layout = (LinearLayout) findViewById(R.id.editText_layout);
            meditText_email = (EditText) findViewById(R.id.editText_email);
            meditText_password = (EditText) findViewById(R.id.editText_password);
            mbutton_login = (Button) findViewById(R.id.button_login);

            mtext_signup.setPaintFlags(mtext_signup.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            meditText_email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

            mbutton_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (meditText_email.getText() == null)
                        meditText_email.setError("Please enter your email");
                    if (meditText_password.getText() == null)
                        meditText_password.setError("Please enter your password");
                    else {
                        Intent i = new Intent(LogIn.this, MainActivity.class);
                        startActivity(i);
                    }
                }
            });

            mtext_signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(LogIn.this, SignUp.class);
                    startActivity(i);
                }
            });
        }
    }
}
