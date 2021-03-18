package com.example.basicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private TextView info;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkCredentials(View v)
    {
        name = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        info = (TextView)findViewById(R.id.tvInfo);
        login = (Button)findViewById(R.id.login);


        String userName = name.getText().toString();
        String password = pass.getText().toString();

        boolean validationFlag = false;
        //Verify if the username and password are not empty.
        if(!userName.isEmpty() && !password.isEmpty()) {
            if(userName.equals("Sumanth") && password.equals("Sumanth")) {
                validationFlag = true;

            }
        }
        if(!validationFlag)
        {
            info.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "You Entered wrong Credentials! Please try again",
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            //This code redirects the from login page to the home page.
            Intent redirect = new Intent(MainActivity.this, HomePage.class);
            startActivity(redirect);
        }

    }

    public void SignUp(View v)
    {
        Intent i = new Intent(MainActivity.this, SignUpPage.class);
        startActivity(i);
    }
}
