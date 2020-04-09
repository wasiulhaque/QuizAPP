package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.net.Inet4Address;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class Quiz_options extends AppCompatActivity {
    RadioButton option1,option2,option3,option4;
    CircularView circularViewWithTimer;
    TextView textView;
    Button submit,skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_options);
        option1=findViewById(R.id.opt1_ques1);
        submit=findViewById(R.id.submit_btn);
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

    }
}
