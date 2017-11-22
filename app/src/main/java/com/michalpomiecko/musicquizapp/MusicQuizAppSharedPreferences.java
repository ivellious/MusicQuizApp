package com.michalpomiecko.musicquizapp;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by michal on 20.11.17.
 */

public class MusicQuizAppSharedPreferences {

    public static final String QUESTIONS_PER_QUIZ = "questionsPerQuiz";
    public static final String SOUNDS_PER_QUESTION = "soundPerQuestion";

    private static final String MUSIC_APP_PREFS = "com.michal.musicquizapp.SHARED_PREFERENCES_FILE";

    private Context context;

    public MusicQuizAppSharedPreferences(Context context) {
        this.context = context;
    }


    private SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(MUSIC_APP_PREFS, Context.MODE_PRIVATE);
    }

    //public for now
    public SharedPreferences.Editor getSharedPreferencesEditor() {
        return getSharedPreferences().edit();
    }


    public void saveQuestionsPerQuiz(int count) {
        getSharedPreferencesEditor().putInt(QUESTIONS_PER_QUIZ, count).commit();
    }

    public int getQuestionsPerQuiz() {
        return getSharedPreferences().getInt(QUESTIONS_PER_QUIZ, 5);
    }

    public void saveSoundsPerQuestion(int count) {
        getSharedPreferencesEditor().putInt(SOUNDS_PER_QUESTION, count).commit();
    }

    public int getSoundsPerQuestion() {
        return getSharedPreferences().getInt(SOUNDS_PER_QUESTION, 1);
    }

    public void saveSoundsSet(Set<String> set) {
        getSharedPreferencesEditor().putStringSet("sounds", set).commit();
    }

    public Set<String> getSoundsSet(){
        return getSharedPreferences().getStringSet("sounds",getDefaultSet());
    }

    public String getResultsString() {
        return getSharedPreferences().getString("results", "");
    }

    public void saveResult(String result) {
        String resultString = result + getResultsString();
        getSharedPreferencesEditor().putString("results", resultString).commit();
    }


    private Set<String> getDefaultSet() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("B");
        set.add("D");
        set.add("C");
        return set;
    }



    //// TODO: 18.10.17 GET TOKEN FROM SERVER AND PUT IT AS SHARED PREFERENCE

}
