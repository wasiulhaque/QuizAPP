package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizResult extends AppCompatActivity {
    Button Proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        Proceed = (Button)findViewById(R.id.proceedBtn);

        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResult.this, PreviousQuiz.class);
                startActivity(intent);
            }
        });
    }
}
