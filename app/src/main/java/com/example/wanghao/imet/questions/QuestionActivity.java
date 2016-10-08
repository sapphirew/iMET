package com.example.wanghao.imet.questions;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.wanghao.imet.AnswerDAO;
import com.example.wanghao.imet.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuestionActivity extends ActionBarActivity {

    private boolean atLeastOneSelected = false;
    private int userId = -1;
    private ArrayList<SeekBar> seekBars;
    private ArrayList<TextView> textViews;
    private ArrayList<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        setSeekBarsListeners();

        addButtons();

        String todayDate = getCurrentTimeStamp().split("_")[0];
        System.out.println("todayDate: " + todayDate);
        for (int i = 0; i < buttons.size(); i++) {
            String savedTime = AnswerDAO.getTime(this, userId, i);
            String savedDate = savedTime.split("_")[0];
            System.out.println(i + " savedDate: " + savedDate);
            if (savedDate.equals(todayDate)) {
                ((LinearLayout)buttons.get(i).getParent()).setVisibility(View.GONE);
            }
        }

        Button submitButton = (Button) findViewById(R.id.submitQuestionButton);
        submitButton.setOnClickListener(new SubmitButtonOnClickListener());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            Intent intent = new Intent(this, QuestionActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setSeekBarsListeners() {

        addSeekBars();
        addTextViewsForSeekBars();

        for (int i = 0; i < textViews.size(); i++) {
            seekBars.get(i).setOnSeekBarChangeListener(new SliderOnSeekBarChangeListener(textViews.get(i)));
        }
    }

    private void addTextViewsForSeekBars() {
        textViews = new ArrayList<>();
        textViews.add((TextView) findViewById(R.id.textView7));
        textViews.add((TextView) findViewById(R.id.textView8));
        textViews.add((TextView) findViewById(R.id.textView9));
        textViews.add((TextView) findViewById(R.id.textView10));
    }

    private void addSeekBars() {
        seekBars = new ArrayList<>();
        seekBars.add((SeekBar) findViewById(R.id.seekBar));
        seekBars.add((SeekBar) findViewById(R.id.seekBar2));
        seekBars.add((SeekBar) findViewById(R.id.seekBar3));
        seekBars.add((SeekBar) findViewById(R.id.seekBar4));
    }

    private void addButtons() {
        buttons = new ArrayList<>();
        buttons.add((Button) findViewById(R.id.button1));
        buttons.add((Button) findViewById(R.id.button2));
        buttons.add((Button) findViewById(R.id.button3));
        buttons.add((Button) findViewById(R.id.button4));
        buttons.add((Button) findViewById(R.id.button5));
    }

    public void showTimePickerDialog(View v) {
        Bundle bundle = new Bundle();
        bundle.putInt("buttonID", v.getId());
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.setArguments(bundle);
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void setAtLeastOneSelectedToTrue() {
        this.atLeastOneSelected = true;
    }

    public boolean isAtLeastOneSelected() {
        return this.atLeastOneSelected;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public ArrayList<SeekBar> getSeekBars() {
        return seekBars;
    }

    public void setSeekBars(ArrayList<SeekBar> seekBars) {
        this.seekBars = seekBars;
    }

    public ArrayList<TextView> getTextViews() {
        return textViews;
    }

    public void setTextViews(ArrayList<TextView> textViews) {
        this.textViews = textViews;
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<Button> buttons) {
        this.buttons = buttons;
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
