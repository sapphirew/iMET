package com.example.wanghao.imet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = (Button) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = (EditText) findViewById(R.id.emailEditText);
                EditText password = (EditText) findViewById(R.id.passwordEditText);
                if (email.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    makeToast("Welcome admin!");
                    Intent intent=  new Intent(MainActivity.this, QuestionActivity.class);
                    startActivity(intent);
                } else {
                    makeToast("Wrong email or password");
                }
            }
        });


    }

    private void makeToast(String alert) {
        Toast.makeText(MainActivity.this, alert, Toast.LENGTH_LONG).show();
    }
}
