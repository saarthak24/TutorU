package com.app.saarthak.tutoru;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView mtutorList;
    private ArrayList<Tutor> tutorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tutor junk = new Tutor("JUNK", "junk@junk.com", "JunkUsername", "JunkPhoneNumber", "JunkPassword", new ArrayList<String>(Arrays.asList("Junksubjects")));
        Firebase.setAndroidContext(MainActivity.this);
        Firebase ref = new Firebase(Config.FIREBASE_URL);
        ref.child(junk.getmfullName()).setValue(junk);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot topSnapshot) {
                for (DataSnapshot snapshot : topSnapshot.getChildren()) {
                    //Getting the data from snapshot
                    Tutor t = snapshot.getValue(Tutor.class);
                    if(!t.getmfullName().equals("JUNK"))
                    tutorList.add(t);
                    }
                }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        /*tutorList.add(new Tutor("John Doe", "johndoe@gmail.com", "john_doe", "1234567890", new String[]{"Biology"}));
        tutorList.add(new Tutor("Jane Doe", "janedoe@gmail.com", "jane_doe", "1234567891", new String[]{"Computer Science"}));
        tutorList.add(new Tutor("John Smith", "johnsmith@gmail.com", "john_smith", "1234567892", new String[]{"Chemistry"}));
        tutorList.add(new Tutor("Mary Wherry", "marywherry@gmail.com", "mary_wherry", "1234567893", new String[]{"Math"}));
        tutorList.add(new Tutor("Yash Bolisetty", "yashbolisetty@gmail.com", "yash_bolisetty", "1234567894", new String[]{"Physics"}));*/

        TutorListAdapter adapter = new TutorListAdapter(MainActivity.this, R.layout.tutor_list_item, tutorList);
        mtutorList = (ListView)findViewById(R.id.tutorListView);
        mtutorList.setAdapter(adapter);

        mtutorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = new Intent(MainActivity.this, UserProfile.class);
                i.putExtra("full_name", tutorList.get(position).getmfullName());
                i.putExtra("email", tutorList.get(position).getmEmail());
                i.putExtra("username", tutorList.get(position).getmUsername());
                i.putExtra("phone_number", tutorList.get(position).getmPhonenumber());
                i.putStringArrayListExtra("subjects", tutorList.get(position).getmSubjects());
                startActivity(i);
            }
        });
    }
}
