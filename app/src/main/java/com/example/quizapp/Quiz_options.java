package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class Quiz_options extends AppCompatActivity {
    RadioButton optionA, optionB, optionC, optionD;
    CircularView circularViewWithTimer;
    TextView textView;
    Button submit, skip;
    ArrayList<Question> questions = new ArrayList<>();
    FirebaseFirestore firebaseFirestore;
    CollectionReference reference = FirebaseFirestore.getInstance().collection("Questions");


    /*FirebaseDatabase database=FirebaseDatabase.getInstance();*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_options);

        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);


        submit = findViewById(R.id.submit_btn);
        circularViewWithTimer = (CircularView) findViewById(R.id.circular_view);

        TimerSettings();

        addQuestions();
    /*    questions.add(new Question(1,"A","B","c","D","A"));
        reference.document(set).set()*/

    optionB.setOnClickListener(this::onClick);
    optionA.setOnClickListener(this::onClick);
    optionC.setOnClickListener(this::onClick);
    optionD.setOnClickListener(this::onClick);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_options.this, CompletionOfQuiz.class);
                startActivity(intent);

            }
        });







       /* r1.setOnClickListener(new View.OnClickListener() {
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
        });*/
    }

    private void onClick(View view) {
        String userAnswer="";

        if(optionA.isChecked())userAnswer="A";
        else if(optionB.isChecked())userAnswer="B";
        else if(optionC.isChecked())userAnswer="C";
        else if(optionD.isChecked())userAnswer="D";


        reference.document(questions.get(0).getQuestionId()+"").update("userAnswer",userAnswer);



    }

    private void addQuestions() {
        questions.add(new Question(1, "A", "A", "B", "C", "D"));
        questions.add(new Question(2, "A", "A", "B", "C", "D"));
        questions.add(new Question(3, "A", "A", "B", "C", "D"));

        for (Question question : questions) {
            reference.document(question.getQuestionId() + "").set(question);
        }

    }

    private void TimerSettings() {
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

    }
}
