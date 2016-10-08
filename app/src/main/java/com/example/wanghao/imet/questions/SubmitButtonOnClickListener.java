package com.example.wanghao.imet.questions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wanghao.imet.AnswerDAO;
import com.example.wanghao.imet.SummaryActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wanghao on 10/5/16.
 */

public class SubmitButtonOnClickListener implements View.OnClickListener {

    String currentTime;
    @Override
    public void onClick(View v) {
        currentTime = getCurrentTimeStamp();
        Context context = ((QuestionActivity)v.getContext());
        int userId = ((QuestionActivity)context).getUserId();
        ArrayList<SeekBar> seekBars = ((QuestionActivity)context).getSeekBars();
        ArrayList<TextView> textViews = ((QuestionActivity)context).getTextViews();
        ArrayList<Button> buttons = ((QuestionActivity)context).getButtons();
        if (((QuestionActivity)context).isAtLeastOneSelected()) {
            saveAnswers(context, userId, seekBars, textViews);
            saveTimes(context, userId, buttons);
            Intent intent = new Intent(v.getContext(), SummaryActivity.class);
            v.getContext().startActivity(intent);
        } else {
            Toast.makeText(v.getContext(), "Please answer at least one question", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveTimes(Context context, int userId, ArrayList<Button> buttons) {

        for (int i = 0; i < buttons.size(); i++) {
            String text = buttons.get(i).getText().toString();
            if (!text.equals("Select time"))
                AnswerDAO.saveTime(context, userId, i, text, currentTime);
        }
    }

    private void saveAnswers(Context context, int userId, ArrayList<SeekBar> seekBars, ArrayList<TextView> textViews) {
        for (int i = 0; i < seekBars.size(); i++) {
            //if user ever slide the bar, which means the text gets longer than 18
            if (textViews.get(i).getText().toString().length() > 18)
                AnswerDAO.saveAnswer(context, userId, i, seekBars.get(i).getProgress(), currentTime, 0);
        }
    }

    public static String getCurrentTimeStamp(){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentTimeStamp = dateFormat.format(new Date()); // Find todays date

            return currentTimeStamp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

