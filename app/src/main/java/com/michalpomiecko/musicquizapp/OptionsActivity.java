package com.michalpomiecko.musicquizapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Options activity accessed through main menu of app. Allows user to change difficulty of game:
 * number of questions per quiz, number of sounds per question and sounds included in quiz.
 * Created by michal on 20.11.17.
 */

public class OptionsActivity extends AppCompatActivity {

    CheckBox checkA, checkAs, checkB, checkC, checkCs, checkD, checkDs, checkE, checkF, checkFs, checkG, checkGs;
    TextView soundsPerQuestionText;
    TextView questionsPerQuizText;
    SeekBar soundsPeqQuestionSeekBar;
    SeekBar questionsPerQuizSeekBar;
    MusicQuizAppSharedPreferences optionsPrefs;
    List<String> notesOptions;


    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * Save sounds when exiting the activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(OptionsActivity.class.getSimpleName(), "Saved");
        saveIncludedSounds();
    }

    /**
     * Check which sounds have ben chosen and save the set
     */
    private void saveIncludedSounds() {
        checkCheckbox(checkA, "A");
        checkCheckbox(checkAs, "A#");
        checkCheckbox(checkB, "B");
        checkCheckbox(checkC, "C");
        checkCheckbox(checkCs, "C#");
        checkCheckbox(checkD, "D");
        checkCheckbox(checkDs, "D#");
        checkCheckbox(checkE, "E");
        checkCheckbox(checkF, "F");
        checkCheckbox(checkFs, "F#");
        checkCheckbox(checkG, "G");
        checkCheckbox(checkGs, "G#");
        Set<String> set = new HashSet<>(notesOptions);
        if (set.size() < 4) {
            return;
        }
        optionsPrefs.saveSoundsSet(set);
        Log.e(OptionsActivity.class.getSimpleName(), "arraylist" + optionsPrefs.getSoundsSet());

    }

    private void checkCheckbox(CheckBox check, String sound) {
        if (check.isChecked()) {
            notesOptions.add(sound);
        }
    }

    /**
     * Initialize options. Initialize checkBoxes, seekBars, shared preferences. Populate views from
     * previous values form shared preferences.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_options);
        optionsPrefs = new MusicQuizAppSharedPreferences(this);
        notesOptions = new ArrayList<>();

        soundsPeqQuestionSeekBar = (SeekBar) findViewById(R.id.soundsCountBar);

        questionsPerQuizSeekBar = (SeekBar) findViewById(R.id.questionsCountBar);
        soundsPerQuestionText = (TextView) findViewById(R.id.soundsCountBarProgress);
        questionsPerQuizText = (TextView) findViewById(R.id.questionsCountBarProgress);
        initCheckBoxes();

        setValues();
        setSeekBarListeners();

        initSoundsOptions();

    }

    private void initSoundsOptions() {
        Set<String> set = optionsPrefs.getSoundsSet();
        for (String soundString : set) {
            initializeSoundOption(soundString);
        }
    }

    private void initializeSoundOption(String soundString) {

        switch (soundString) {
            case "A":
                checkA.setChecked(true);
                break;
            case "A#":
                checkAs.setChecked(true);
                break;
            case "B":
                checkB.setChecked(true);
                break;
            case "C":
                checkC.setChecked(true);
                break;
            case "C#":
                checkCs.setChecked(true);
                break;
            case "D":
                checkD.setChecked(true);
                break;
            case "D#":
                checkDs.setChecked(true);
                break;
            case "E":
                checkE.setChecked(true);
                break;
            case "F":
                checkF.setChecked(true);
                break;
            case "F#":
                checkFs.setChecked(true);
                break;
            case "G":
                checkG.setChecked(true);
                break;
            case "G#":
                checkA.setChecked(true);
                break;
            default:
                break;
        }
    }

    private void initCheckBoxes() {
        checkA = (CheckBox) findViewById(R.id.checkA);
        checkAs = (CheckBox) findViewById(R.id.checkAs);
        checkB = (CheckBox) findViewById(R.id.checkB);
        checkC = (CheckBox) findViewById(R.id.checkC);
        checkCs = (CheckBox) findViewById(R.id.checkCs);
        checkD = (CheckBox) findViewById(R.id.checkD);
        checkDs = (CheckBox) findViewById(R.id.checkDs);
        checkE = (CheckBox) findViewById(R.id.checkE);
        checkF = (CheckBox) findViewById(R.id.checkF);
        checkFs = (CheckBox) findViewById(R.id.checkFs);
        checkG = (CheckBox) findViewById(R.id.checkG);
        checkGs = (CheckBox) findViewById(R.id.checkGs);
    }

    /**
     * Initialize seekBar listeners - minimal value of option is 1;
     */
    private void setSeekBarListeners() {
        soundsPeqQuestionSeekBar.setOnSeekBarChangeListener(new MusicSeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    progress = 1;
                }
                optionsPrefs.saveSoundsPerQuestion(progress);
                setSoundsCountValues();
            }
        });


        questionsPerQuizSeekBar.setOnSeekBarChangeListener(new MusicSeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    progress = 1;
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

    /**
     * Abstract class implementing interface for SeekBar made for more readability, since we don't need
     * onStartTrackingTouch() and onStopTrackingTouch() methods
     */
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
