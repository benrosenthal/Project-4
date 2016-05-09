package com.nychareport.backlog.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nychareport.backlog.R;

public class MainActivity extends AppCompatActivity {

    private Button postProblemButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    private void initializeViews() {
        postProblemButton = (Button) findViewById(R.id.btn_make_post);
        postProblemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostProblemActivity.class);
                startActivity(intent);
            }
        });
    }

}
