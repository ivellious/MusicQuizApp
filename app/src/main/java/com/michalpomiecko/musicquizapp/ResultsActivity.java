package com.michalpomiecko.musicquizapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/** Activity displaying results
 * Created by michal on 22.11.17.
 */

public class ResultsActivity extends AppCompatActivity{
    LinearLayout resultsLayout;

    /**
     * Initialise views and display results based on String from shared preferences
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        resultsLayout = (LinearLayout) findViewById(R.id.resultsLinearLayout);


        MusicQuizAppSharedPreferences resultsSharedPreferences = new MusicQuizAppSharedPreferences(this);

        String resultsString = resultsSharedPreferences.getResultsString();

        String[] resultsStringArray = resultsString.split("-");

        for (int i = 0; i<resultsStringArray.length;i++) {
            resultsLayout.addView(generateTextView(resultsStringArray[i]));
            if (i==20) {
                break;
            }
        }

    }

    /**
     * Generate text view with given text, so it can be added to linear layout.
     * @param text
     * @return
     */
    private TextView generateTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}
