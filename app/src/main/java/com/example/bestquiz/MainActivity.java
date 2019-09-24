package com.example.bestquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView questionTV;
    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton backButton;
    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[]{
            new Question(R.string.Anime_Kanade, false),
            new Question(R.string.Anime_Megumin, false),
            new Question(R.string.Anime_Futabu, false),
            new Question(R.string.Anime_Elizabeth, true),
            new Question(R.string.Anime_Konosuba, true),
            new Question(R.string.Anime_Naruto, true),
            new Question(R.string.Anime_Miku, false),
            new Question(R.string.Anime_Alphonse, false),
            new Question(R.string.Anime_Ash, true),
            new Question(R.string.Anime_Bleach, true),
            new Question(R.string.Anime_DXD, true),
            new Question(R.string.Anime_Felix, true),
            new Question(R.string.Anime_Kenshin, true)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = findViewById(R.id.quizQuestion);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        nextButton = findViewById(R.id.next_button);
        backButton = findViewById(R.id.back_button);

//        Question question = new Question(R.string.Anime_Kenshin,true);


        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        backButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.trueButton:
                //Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
                checkAnswer(true);
                break;
            case R.id.falseButton:
                //Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
                checkAnswer(false);
                break;
            case R.id.next_button:
                //Toast.makeText(MainActivity.this, "Next", Toast.LENGTH_SHORT).show();
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                updateQuestion();
                break;
            case R.id.back_button:
                //Toast.makeText(MainActivity.this, "Next", Toast.LENGTH_SHORT).show();
                currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                updateQuestion();
                break;
        }
    }

    private void checkAnswer(boolean userChoseCorrect) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswer();

        int toastMessageId = 0;
        if (userChoseCorrect == answerIsTrue) {
            toastMessageId = R.string.right_answer;
        } else {
            toastMessageId = R.string.wrong_answer;
        }
        Toast.makeText(MainActivity.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }

    public void updateQuestion() {
        questionTV.setText(questionBank[currentQuestionIndex].getQuestionResId());

    }
}
