package com.example.wanghao.imet;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends ActionBarActivity {
    private EditText mEmail;
    private EditText mPassword;
    private EditText mName;
    private EditText mAddress;
    private EditText mDOB;
    private EditText mGender;
    private EditText mPhone;
    private EditText mEmergencyContact;
    private EditText mDoctor;
    private EditText mDoctorPhone;
    private EditText mGuardian;
    private EditText mGuardianPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mEmail = (EditText) findViewById(R.id.signUpEmail);
        mPassword = (EditText) findViewById(R.id.signUpPassword);
        mName = (EditText) findViewById(R.id.signUpName);
        mAddress = (EditText) findViewById(R.id.signUpAddress);
        mDOB = (EditText) findViewById(R.id.signUpDOB);
        mGender = (EditText) findViewById(R.id.signUpGender);
        mPhone = (EditText) findViewById(R.id.signUpNumber);
        mEmergencyContact = (EditText) findViewById(R.id.signUpEmergency);
        mDoctor = (EditText) findViewById(R.id.signUpDoctor);
        mDoctorPhone = (EditText) findViewById(R.id.signUpDoctorPhone);
        mGuardian = (EditText) findViewById(R.id.signUpParent);
        mGuardianPhone = (EditText) findViewById(R.id.signUpGuardianPhone);

        Button submitButton = (Button) findViewById(R.id.signUpSubmitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpDAO.saveUserDetail(v.getContext(), mEmail.getText().toString(), mPassword.getText().toString(),
                        mName.getText().toString(), mAddress.getText().toString(), mDOB.getText().toString(), mGender.getText().toString(),
                        mPhone.getText().toString(), mEmergencyContact.getText().toString(), mDoctor.getText().toString(), mDoctorPhone.getText().toString(),
                        mGuardian.getText().toString(), mGuardianPhone.getText().toString());
                Toast.makeText(v.getContext(), "User created", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}
