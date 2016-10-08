package com.example.wanghao.imet.questions;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by wanghao on 10/3/16.
 */

public class SliderOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

    private TextView textView;
    private String title;
    private static String[] descriptions = {
            "AT THE LOWEST POINT", "EXTREMELY DOWN (life is not worth living)",
            "SEVERELY DOWN - almost all day", "SEVERELY DOWN- less than 50% of the day",
            "MODERATELY DOWN -almost all day", "MODERATELY DOWN - less than 50% of the day",
            "MILDLY DOWN -almost all day", "MILDLY DOWN - less than 50% of the day",
            "SLIGHTLY DOWN-almost all day", "SLIGHTLY DOWN- less than 50% of the day",
            "OK    ", "SLIGHTLY ELEVATED- less than 50% of the day", "SLIGHTLY ELEVATED-almost all day long",
            "MILDLY ELEVATED-less than 50% of the day", "MILDLY ELEVATED-almost all day",
            "MODERATELY ELEVATED- less than 50% of the day", "MODERATELY ELEVATED-almost all day",
            "SEVERELY ELEVATED- less than 50% of the day", "SEVERELY ELEVATED-almost all day",
            "EXTREMELY ELEVATED", "SUPER ELEVATED"
    };
    public SliderOnSeekBarChangeListener(TextView view) {
        this.textView = view;
        this.title = textView.getText().toString();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textView.setText(title + ":\n");
        textView.append(descriptions[progress]);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        ((QuestionActivity) seekBar.getContext()).setAtLeastOneSelectedToTrue();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
