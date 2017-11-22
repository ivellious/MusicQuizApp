package com.michalpomiecko.musicquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.michalpomiecko.musicquizapp.Model.MusicQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by michal on 14.11.17.
 */

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{


        String[] notes = new String[] {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#" };


    Button ans1,ans2,ans3,ans4;
    TextView progressText;
    Button playButton;

    List<MusicQuestion> questionsArray;
    MusicQuestion currentMusicQuestion;
    int progressNumber = 0;
    int score = 0;
    int quizLength = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.quiz_activity);

        ans1 = (Button) findViewById(R.id.ans1Btn);
        ans2 = (Button) findViewById(R.id.ans2Btn);
        ans3 = (Button) findViewById(R.id.ans3Btn);
        ans4 = (Button) findViewById(R.id.ans4Btn);
        playButton = (Button) findViewById(R.id.playBtn);

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);
        playButton.setOnClickListener(this);

        progressText = (TextView) findViewById(R.id.progressText);

        generateQuestions();
        fillButtons();

    }

    private void fillButtons() {
        currentMusicQuestion = questionsArray.get(progressNumber);
        ans1.setText(currentMusicQuestion.getAnswerArray().get(0));
        ans2.setText(currentMusicQuestion.getAnswerArray().get(1));
        ans3.setText(currentMusicQuestion.getAnswerArray().get(2));
        ans4.setText(currentMusicQuestion.getAnswerArray().get(3));
        progressText.setText("Progress: " + (progressNumber+1) + "/" + quizLength);
    }

    private void generateQuestions() {
        questionsArray = new ArrayList<>();


        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 0; i < MusicQuestion.NOTES.length; ++i) {
            number.add(i);
        }
        Collections.shuffle(number);
        Random random = new Random();


        for (int i=0; i<quizLength;i++) {

            Collections.shuffle(number);
            MusicQuestion musicQuestion = new MusicQuestion();
            List<String> answers = new ArrayList<>();
            for (int j = 0; j <4; j++) {
                answers.add(MusicQuestion.NOTES[number.get(j)]);
            }
            musicQuestion.setAnswerArray(answers);
            musicQuestion.setCorrectAnswer(answers.get(random.nextInt(4)));
            Log.e(QuizActivity.class.toString(), "Questions: " + musicQuestion.getAnswerArray() + " correct: " + musicQuestion.getCorrectAnswer());
            questionsArray.add(musicQuestion);
        }

    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ans1Btn:
                checkAnswer(R.id.ans1Btn);
                break;
            case R.id.ans2Btn:
                checkAnswer(R.id.ans2Btn);
                break;
            case R.id.ans3Btn:
                checkAnswer(R.id.ans3Btn);
                break;
            case R.id.ans4Btn:
                checkAnswer(R.id.ans4Btn);
                break;
            case R.id.playBtn:

                playSound();
                break;
            default:
                break;
        }
    }

    private void checkAnswer(int id) {
        Button button = (Button) findViewById(id);

        if (button.getText().equals(currentMusicQuestion.getCorrectAnswer())) {
            score++;
        }

        progressInQuiz();
    }

    private void progressInQuiz() {
        progressNumber++;
        if (progressNumber < quizLength) {
            fillButtons();
        } else {
            displayResult();
        }

    }

    private void displayResult() {
        Toast.makeText(this, "Result: " + score+"/"+quizLength, Toast.LENGTH_SHORT).show();
    }

    private void playSound() {
        Toast.makeText(this, currentMusicQuestion.getCorrectAnswer(), Toast.LENGTH_SHORT).show();
    }
}
