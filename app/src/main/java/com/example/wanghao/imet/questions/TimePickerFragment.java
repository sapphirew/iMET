package com.example.wanghao.imet.questions;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    private int buttonId = -1;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        buttonId = getArguments().getInt("buttonID");
        String name = String.valueOf(buttonId);
        //Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                true);
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        String timeString = hourOfDay + " : " + minute;
        if (buttonId != -1) {
            Button button = (Button) getActivity().findViewById(buttonId);
            button.setText(timeString);
        }


    }

}
