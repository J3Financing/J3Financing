package com.example.financetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    CardView login, gotoregister;
    EditText username, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (CardView) findViewById(R.id.login);
        gotoregister = (CardView) findViewById(R.id.gotoregister);
        username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.Password);

        gotoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    go_to_register();
            }
        });
    }
    private void go_to_register() {
        Intent ToRegister = new Intent(this, Registering.class);
        startActivity(ToRegister);
    }

    public void OnLogin(View view){
        String UserName = username.getText().toString();
        String pass = Password.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, UserName, pass);
        go_to_home();
    }

    private void go_to_home() {
        Intent ToHome = new Intent(this, Home.class);
        startActivity(ToHome);
    }
}