package com.example.quizapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SelectClass extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_class);
        Spinner classSpinner = findViewById(R.id.classSpinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Class 5");
        arrayList.add("Class 6");
        arrayList.add("Class 7");
        arrayList.add("Class 8");
        arrayList.add("Class 9");
        arrayList.add("Class 10");
        arrayList.add("Class 11");
        arrayList.add("Class 12");
        arrayList.add("Varsity Admission Candidate");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(arrayAdapter);

    }

}
