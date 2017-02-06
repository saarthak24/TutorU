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
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

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
                    if (meditText_email.getText().toString().equals(""))
                        meditText_email.setError("Please enter your email");
                    if (meditText_password.getText().toString().equals(""))
                        meditText_password.setError("Please enter your password");
                    else {
                        Tutor junk = new Tutor("JUNK", "junk@junk.com", "JunkUsername", "JunkPhoneNumber", "JunkPassword", new ArrayList<String>(Arrays.asList("Junksubjects")));
                        Firebase.setAndroidContext(LogIn.this);
                        Firebase ref = new Firebase(Config.FIREBASE_URL);
                        ref.child(junk.getmfullName()).setValue(junk);

                        ref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot topSnapshot) {
                                for (DataSnapshot snapshot : topSnapshot.getChildren()) {
                                    //Getting the data from snapshot
                                    Tutor t = snapshot.getValue(Tutor.class);
                                    if(!t.getmfullName().equals("JUNK"))
                                    {
                                        if((meditText_email.getText().toString().equals(t.getmEmail())) && (meditText_password.getText().toString().equals(t.getmPassword())))
                                        {
                                            Intent i = new Intent(LogIn.this, MainActivity.class);
                                            startActivity(i);
                                            break;
                                        }
                                        else
                                        {
                                            Toast.makeText(LogIn.this, "Invalid Credentials",
                                                    Toast.LENGTH_SHORT).show();
                                            meditText_email.setText("");
                                            meditText_password.setText("");
                                        }
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(FirebaseError firebaseError) {
                            }
                        });
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
