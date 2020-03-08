package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {
    Button Login_button;
    Button SignUpButton;
    EditText username,password;
    TextView no_Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        username=findViewById(R.id.user_name);
        password=findViewById(R.id.pass_for_login);
        no_Id=findViewById(R.id.noIdView);
        Login_button=findViewById(R.id.loginId);
        SignUpButton=findViewById(R.id.signUpId);
        Login_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(LogInActivity.this,SelectClass.class);
               startActivity(intent);
           }
       });

       SignUpButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent2 = new Intent(LogInActivity.this,SignUp.class);
               startActivity(intent2);
           }
       });

    }
}
