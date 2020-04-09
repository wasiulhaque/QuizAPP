package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CompletionOfQuiz extends AppCompatActivity {
    Button proceedToEvaluation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completion_of_quiz);
        proceedToEvaluation = (Button)findViewById(R.id.ProceedEvaluation);

        proceedToEvaluation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompletionOfQuiz.this, QuizResult.class);
                startActivity(intent);
            }
        });
    }
}
