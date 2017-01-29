package com.app.saarthak.tutoru;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Saarthak on 01/28/17.
 */

public class TutorListAdapter extends ArrayAdapter<Tutor> {
    ArrayList<Tutor> tutorList = new ArrayList<>();

    public TutorListAdapter(Context context, int textViewResourceId, ArrayList<Tutor> tutors) {
        super(context, textViewResourceId, tutors);
        tutorList = tutors;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.tutor_list_item, null);
        ImageView picture = (ImageView) v.findViewById(R.id.tutor_item_picture);
        TextView name = (TextView) v.findViewById(R.id.tutor_item_name);
        TextView subjects = (TextView) v.findViewById(R.id.tutor_item_subjects);
        picture.setImageResource(R.drawable.template_avatar);
        name.setText(tutorList.get(position).getmfullName());

        String allSubjects = "";
        String[] subjectsList = tutorList.get(position).getmSubjects();
        allSubjects += subjectsList[0];
        for(int i = 1; i < subjectsList.length; i++)
        {
            allSubjects += ", " + subjectsList[i];
        }
        subjects.setText(allSubjects);
        return v;

    }
}
