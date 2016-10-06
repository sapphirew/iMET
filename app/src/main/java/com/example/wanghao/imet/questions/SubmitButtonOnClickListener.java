package com.example.wanghao.imet.questions;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.wanghao.imet.SummaryActivity;

/**
 * Created by wanghao on 10/5/16.
 */

public class SubmitButtonOnClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        if (((QuestionActivity)v.getContext()).isAtLeastOneSelected()) {
            Intent intent = new Intent(v.getContext(), SummaryActivity.class);
            v.getContext().startActivity(intent);
        } else {
            Toast.makeText(v.getContext(), "Please answer at least one question", Toast.LENGTH_SHORT).show();
        }
    }
}

