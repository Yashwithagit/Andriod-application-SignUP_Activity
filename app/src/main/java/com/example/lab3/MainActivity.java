package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText un,pwd;
    Button login;
    String entered_name,entered_pwd;
    Pattern pattern;
    Matcher matcher;
    private static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pattern = Pattern.compile(PASSWORD_REGEX);
       un=(EditText)findViewById(R.id.UN);
       pwd=(EditText)findViewById(R.id.PWD);
       login=(Button) findViewById(R.id.signup);
       entered_name=un.getText().toString();
       entered_pwd=pwd.getText().toString();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                entered_name=un.getText().toString();
                entered_pwd=pwd.getText().toString();
                matcher=pattern.matcher(entered_pwd);
                if(!matcher.matches()) {
                    Toast.makeText(MainActivity.this, "wrong password", Toast.LENGTH_SHORT).show();
                    System.out.println("wrong password");
                }
                else {
                    Intent intent = new Intent(MainActivity.this, secondactivity.class);
                    intent.putExtra("un", entered_name);
                    intent.putExtra("pwd", entered_pwd);
                    startActivity(intent);
                }

            }
            });



    }
}