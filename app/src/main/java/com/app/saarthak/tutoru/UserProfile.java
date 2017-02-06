package com.app.saarthak.tutoru;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class UserProfile extends AppCompatActivity {

    private TextView muser_profile_name;
    private TextView muser_profile_short_bio;
    private TextView muser_profile_subjects;
    private TextView muser_profile_username;
    private TextView muser_profile_email;
    private TextView muser_profile_phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        muser_profile_name = (TextView)findViewById(R.id.user_profile_name);
        muser_profile_short_bio = (TextView)findViewById(R.id.user_profile_short_bio);
        muser_profile_subjects = (TextView)findViewById(R.id.user_profile_subjects);
        muser_profile_username = (TextView)findViewById(R.id.user_profile_username);
        muser_profile_email = (TextView)findViewById(R.id.user_profile_email);
        muser_profile_phone_number = (TextView)findViewById(R.id.user_profile_phone_number);

        String full_name = getIntent().getStringExtra("full_name");
        String email = getIntent().getStringExtra("email");
        String username = getIntent().getStringExtra("username");
        String phone_number = getIntent().getStringExtra("phone_number");
        ArrayList<String> subjects = getIntent().getStringArrayListExtra("subjects");

        muser_profile_name.setText(full_name);
        muser_profile_email.append(email);
        muser_profile_username.append(username);
        if(phone_number != null)
        muser_profile_phone_number.append(phone_number);
        muser_profile_subjects.append(subjects.get(0));
        for(int i = 1; i < subjects.size(); i++)
        {
            muser_profile_subjects.append(", " + subjects.get(i));
        }


        muser_profile_phone_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
