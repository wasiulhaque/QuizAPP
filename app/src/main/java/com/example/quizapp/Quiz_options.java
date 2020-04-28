package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class Quiz_options extends AppCompatActivity {
    RadioButton option1,option2,option3,option4;
    CircularView circularViewWithTimer;
    TextView textView;
    Button submit,skip;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_options);
        submit=findViewById(R.id.submit_btn);
        RadioButton r1 = findViewById(R.id.r1);
        r1.setTextColor(Color.WHITE);
        RadioButton r2 = findViewById(R.id.r2);
        r2.setTextColor(Color.WHITE);
        RadioButton r3 = findViewById(R.id.r3);
        r3.setTextColor(Color.WHITE);
        RadioButton r4 = findViewById(R.id.r4);
        r4.setTextColor(Color.WHITE);
        circularViewWithTimer=(CircularView)findViewById(R.id.circular_view);
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(10)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

                                // Will be called if times up of countdown timer
                                //Toast.makeText(MainActivity.this, "CircularCallback: Timer Finished ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onTimerCancelled() {

                                // Will be called if stopTimer is called
                                // Toast.makeText(MainActivity.this, "CircularCallback: Timer Cancelled ", Toast.LENGTH_SHORT).show();
                            }
                        });

        circularViewWithTimer.startTimer();

        circularViewWithTimer.setOptions(builderWithTimer);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Quiz_options.this,CompletionOfQuiz.class);
               startActivity(intent);

            }
        });


        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference=database.getReference("Question no: 1");
                databaseReference.setValue("A");
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference=database.getReference("Question no: 1");
                databaseReference.setValue("B");
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference=database.getReference("Question no: 1");
                databaseReference.setValue("C");
            }
        });
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference=database.getReference("Question no: 1");
                databaseReference.setValue("D");
            }
        });
    }
}
