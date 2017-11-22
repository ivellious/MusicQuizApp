package com.michalpomiecko.musicquizapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by michal on 14.11.17.
 */

public class MainMenuFragment extends Fragment implements View.OnClickListener {

    private Button buttonOne, buttonTwo, buttonThree, resultsButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.main_menu_fragment, container, false);
        buttonOne = (Button) view.findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(this);

        buttonTwo = (Button) view.findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(this);

        buttonThree = (Button) view.findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(this);

        resultsButton = (Button) view.findViewById(R.id.resultsButton);
        resultsButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.buttonOne:
                moveToActivity(QuizActivity.class);
                break;
            case R.id.buttonTwo:
                moveToActivity(TrainingActivity.class);
                break;
            case R.id.buttonThree:
                moveToActivity(OptionsActivity.class);
                break;
            case R.id.resultsButton:
                moveToActivity(ResultsActivity.class);
                break;
            default:
                break;
        }
    }

    private void moveToActivity(Class<?> cls) {
        getActivity().startActivity(new Intent(getActivity(), cls));
    }
}
