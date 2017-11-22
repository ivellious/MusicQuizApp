package com.michalpomiecko.musicquizapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by michal on 20.11.17.
 */

public class OptionsActivity extends AppCompatActivity {


    TextView soundsPerQuestionText;
    TextView questionsPerQuizText;
    SeekBar soundsPeqQuestionSeekBar;
    SeekBar questionsPerQuizSeekBar;
    MusicQuizAppSharedPreferences optionsPrefs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_options);

        optionsPrefs = new MusicQuizAppSharedPreferences(this);

        soundsPeqQuestionSeekBar = (SeekBar) findViewById(R.id.soundsCountBar);

        questionsPerQuizSeekBar = (SeekBar) findViewById(R.id.questionsCountBar);
        soundsPerQuestionText = (TextView) findViewById(R.id.soundsCountBarProgress);
        questionsPerQuizText = (TextView) findViewById(R.id.questionsCountBarProgress);

        setValues();

        setSeekBarListeners();


    }

    private void setSeekBarListeners() {
        soundsPeqQuestionSeekBar.setOnSeekBarChangeListener(new MusicSeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress==0) {
                    progress=1;
                }
                optionsPrefs.saveSoundsPerQuestion(progress);
                setSoundsCountValues();
            }
        });


        questionsPerQuizSeekBar.setOnSeekBarChangeListener(new MusicSeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress==0) {
                    progress=1;
                }
                optionsPrefs.saveQuestionsPerQuiz(progress);
                setQuestionsCountValues();
            }
        });
    }

    private void setValues() {
        setSoundsCountValues();
        setQuestionsCountValues();
    }

    private void setQuestionsCountValues() {
        questionsPerQuizSeekBar.setProgress(optionsPrefs.getQuestionsPerQuiz());
        questionsPerQuizText.setText("" + optionsPrefs.getQuestionsPerQuiz() + "/" + questionsPerQuizSeekBar.getMax());
    }

    private void setSoundsCountValues() {
        soundsPeqQuestionSeekBar.setProgress(optionsPrefs.getSoundsPerQuestion());
        soundsPerQuestionText.setText("" + optionsPrefs.getSoundsPerQuestion() + "/" + soundsPeqQuestionSeekBar.getMax());
    }




    abstract class MusicSeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            //nothing to do here
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            //noting to do here
        }
    }

}
