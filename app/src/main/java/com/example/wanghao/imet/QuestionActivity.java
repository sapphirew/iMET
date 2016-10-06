package com.example.wanghao.imet;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        setSeekBarsListeners();

        Button submitButton = (Button) findViewById(R.id.submitQuestionButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(QuestionActivity.this, SummaryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setSeekBarsListeners() {
        ArrayList<SeekBar> seekBars = new ArrayList<>();
        seekBars.add((SeekBar) findViewById(R.id.seekBar));
        seekBars.add((SeekBar) findViewById(R.id.seekBar2));
        seekBars.add((SeekBar) findViewById(R.id.seekBar3));
        seekBars.add((SeekBar) findViewById(R.id.seekBar4));

        ArrayList<TextView> textViews = new ArrayList<>();
        textViews.add((TextView) findViewById(R.id.textView7));
        textViews.add((TextView) findViewById(R.id.textView8));
        textViews.add((TextView) findViewById(R.id.textView9));
        textViews.add((TextView) findViewById(R.id.textView10));

        for (int i = 0; i < textViews.size(); i++) {
            seekBars.get(i).setOnSeekBarChangeListener(new SliderOnSeekBarChangeListener(textViews.get(i)));
        }
    }

    public void showTimePickerDialog(View v) {
        Bundle bundle = new Bundle();
        bundle.putInt("buttonID", v.getId());
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.setArguments(bundle);
        newFragment.show(getFragmentManager(), "timePicker");
    }


}
