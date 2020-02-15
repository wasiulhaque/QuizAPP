package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {
    Button Login_button;
    Button SignUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
       Login_button=findViewById(R.id.loginId);
       Login_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(LogInActivity.this,SelectClass.class);
               startActivity(intent);
           }
       });
       SignUpButton=findViewById(R.id.signUpId);
       SignUpButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent2 = new Intent(LogInActivity.this,SignUp.class);
               startActivity(intent2);
           }
       });

    }
}
