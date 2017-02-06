package com.app.saarthak.tutoru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class SignUpChoice extends AppCompatActivity {

    private ImageButton student_choice;
    private ImageButton tutor_choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_choice);
    }
}
