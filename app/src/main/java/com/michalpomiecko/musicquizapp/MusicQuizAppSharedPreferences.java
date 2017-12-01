package com.michalpomiecko.musicquizapp;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**Shared preferences class storing and providing all necessary data for app
 * Created by michal on 20.11.17.
 */

public class MusicQuizAppSharedPreferences {

    public static final String QUESTIONS_PER_QUIZ = "questionsPerQuiz";
    public static final String SOUNDS_PER_QUESTION = "soundPerQuestion";

    private static final String MUSIC_APP_PREFS = "com.michal.musicquizapp.SHARED_PREFERENCES_FILE";
    private static final String SOUNDS = "sounds";
    private static final String RESULTS = "results";
    private Context context;

    public MusicQuizAppSharedPreferences(Context context) {
        this.context = context;
    }


    private SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(MUSIC_APP_PREFS, Context.MODE_PRIVATE);
    }

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
        getSharedPreferencesEditor().putStringSet(SOUNDS, set).commit();
    }

    public Set<String> getSoundsSet(){
        return getSharedPreferences().getStringSet(SOUNDS,getDefaultSet());
    }

    public String getResultsString() {
        return getSharedPreferences().getString(RESULTS, "");
    }

    public void saveResult(String result) {
        String resultString = result + getResultsString();
        getSharedPreferencesEditor().putString(RESULTS, resultString).commit();
    }

    /**
     * This set will be returned if options haven't been changed by user
     * @return
     */
    private Set<String> getDefaultSet() {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("D");
        set.add("C");
        return set;
    }

}
