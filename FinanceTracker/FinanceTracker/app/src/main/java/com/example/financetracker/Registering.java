package com.example.financetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Registering extends AppCompatActivity {

    EditText Register_Username, Register_Name, Register_Pass, Register_Repass;
    CardView Registered, gotologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        gotologin = (CardView) findViewById(R.id.gotologin);
        Registered = (CardView) findViewById(R.id.Registered);

        Register_Username = (EditText) findViewById(R.id.Register_UserName);
        Register_Name = (EditText) findViewById(R.id.Register_Name);
        Register_Pass= (EditText) findViewById(R.id.Register_Pass);
        Register_Repass= (EditText) findViewById(R.id.Register_RePass);

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_to_login();
            }
        });

    }

    private void go_to_login() {
        Intent ToLogin = new Intent(this, MainActivity.class);
        startActivity(ToLogin);
    }

    public void OnRegister(View view){
        String UserName = Register_Username.getText().toString();
        String Name = Register_Name.getText().toString();
        String pass = Register_Pass.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, UserName, Name, pass);
    }
}