package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class secondactivity extends AppCompatActivity {
    EditText un1,pw1;
    Button login1;
    String registerd_username,registered_passwd;
    String entered_username_sigin,entered_passwd_sigin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        un1=(EditText)findViewById(R.id.UN1);
        pw1=(EditText)findViewById(R.id.pwd2);
        login1=(Button)findViewById(R.id.signin);

        Bundle extras = getIntent().getExtras();
        registerd_username=extras.getString("un");
        registered_passwd = extras.getString("pwd");

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entered_username_sigin=un1.getText().toString();
                entered_passwd_sigin=pw1.getText().toString();
                if(entered_username_sigin.equals(registerd_username)&&(entered_passwd_sigin.equals(registered_passwd))) {
                    Toast.makeText(secondactivity.this, "valid", Toast.LENGTH_SHORT).show();
                    System.out.println("Valid User and Sucessful Sign In");

                }
                else {
                    Toast.makeText(secondactivity.this,"Enter Valid Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}