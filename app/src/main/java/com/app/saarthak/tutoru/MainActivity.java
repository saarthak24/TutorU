package com.app.saarthak.tutoru;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mtutorList;
    private ArrayList<Tutor> tutorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tutorList.add(new Tutor("John Doe", "johndoe@gmail.com", "john_doe", "1234567890", new String[]{"Biology"}));
        tutorList.add(new Tutor("Jane Doe", "janedoe@gmail.com", "jane_doe", "1234567891", new String[]{"Computer Science"}));
        tutorList.add(new Tutor("John Smith", "johnsmith@gmail.com", "john_smith", "1234567892", new String[]{"Chemistry"}));
        tutorList.add(new Tutor("Mary Wherry", "marywherry@gmail.com", "mary_wherry", "1234567893", new String[]{"Math"}));
        tutorList.add(new Tutor("Shawn Frank", "shawnfrank@gmail.com", "shawn_frank", "1234567893", new String[]{"Ethics","Leadership"}));

        TutorListAdapter adapter = new TutorListAdapter(MainActivity.this, R.layout.tutor_list_item, tutorList);
        mtutorList = (ListView)findViewById(R.id.tutorListView);
        mtutorList.setAdapter(adapter);

        mtutorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = new Intent(MainActivity.this, UserProfile.class);
                startActivity(i);

            }
        });
    }
}
