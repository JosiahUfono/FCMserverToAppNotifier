package com.myandroidtuturial.android.a2ndjavaclouddb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BodyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        TextView myMessageBody = findViewById(R.id.messageBody);
       // String MessageBody = myMessageBody.getText().toString();


        Intent intent = getIntent();
        String User12 = intent.getStringExtra("myBody");
        myMessageBody.setText(User12);

    }



}
