package com.michalpomiecko.musicquizapp.Model;

import java.util.List;

/**
 * Created by michal on 20.11.17.
 */

public class MusicQuestion {

    public static String[] NOTES = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#" };

    List<String> answerArray;
    String correctAnswer;

    public MusicQuestion() {

    }

    public MusicQuestion(List<String> musicQuestions, String correctAnswer) {
        this.answerArray = musicQuestions;
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(List<String> answerArray) {
        this.answerArray = answerArray;
    }
}
