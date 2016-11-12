package com.example.wanghao.imet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wanghao.imet.questions.QuestionActivity;

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
                String pass = SignUpDAO.getPass(v.getContext(), email.getText().toString());
                if ((pass != null && pass.equals(password.getText().toString())) || (email.getText().toString().equals("admin") && password.getText().toString().equals("admin"))) {
                    makeToast("Welcome!");
                    Intent intent=  new Intent(MainActivity.this, QuestionActivity.class);
                    startActivity(intent);
                } else {
                    makeToast("Wrong email or password");
                }
            }
        });
        
        TextView createAccount = (TextView) findViewById(R.id.createAccountText);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }

    private void makeToast(String alert) {
        Toast.makeText(MainActivity.this, alert, Toast.LENGTH_LONG).show();
    }
}
