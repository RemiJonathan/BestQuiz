package com.example.bestquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView questionTV;
    private Button trueButton;
    private Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = findViewById(R.id.quizQuestion);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);

        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.trueButton:
                Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
                break;
            case R.id.falseButton:
                Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
