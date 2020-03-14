package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizResult extends AppCompatActivity {
    Button proceed;
    Button feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        feedback = findViewById(R.id.feedback);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(QuizResult.this,QuizOrStudyMaterialSelector.class);
                startActivity(proceed);
                Toast toast = Toast.makeText(getApplicationContext(),"Quiz recorded",Toast.LENGTH_LONG);
                toast.show();
            }
        });
        }
}
