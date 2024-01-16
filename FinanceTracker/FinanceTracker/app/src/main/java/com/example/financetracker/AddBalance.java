package com.example.financetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AddBalance extends AppCompatActivity {

    Spinner bal_spinner;
    TextView bal_Display, bal_category, bal_Date;
    ImageView bal_return;
    EditText bal_description;
    CardView bal_OneCard, bal_TwoCard, bal_ThreeCard, bal_FourCard, bal_FiveCard, bal_SixCard;
    CardView bal_SevenCard, bal_EightCard, bal_NineCard, bal_ZeroCard, bal_DeleteCard, bal_PeriodCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);

        setCurrentDate();

        bal_spinner = (Spinner) findViewById(R.id.bal_spinner);

        bal_description = (EditText) findViewById(R.id.bal_Description);

        bal_return = (ImageView) findViewById(R.id.bal_return);

        bal_Display = (TextView) findViewById(R.id.bal_Display);
        bal_Date = (TextView) findViewById(R.id.bal_Date);
        bal_category = (TextView) findViewById(R.id.bal_category);

        bal_OneCard = (CardView) findViewById(R.id.bal_OneCard);
        bal_TwoCard = (CardView) findViewById(R.id.bal_TwoCard);
        bal_ThreeCard = (CardView) findViewById(R.id.bal_ThreeCard);
        bal_FourCard = (CardView) findViewById(R.id.bal_FourCard);
        bal_FiveCard = (CardView) findViewById(R.id.bal_FiveCard);
        bal_SixCard = (CardView) findViewById(R.id.bal_SixCard);
        bal_SevenCard = (CardView) findViewById(R.id.bal_SevenCard);
        bal_EightCard = (CardView) findViewById(R.id.bal_EightCard);
        bal_NineCard = (CardView) findViewById(R.id.bal_NineCard);
        bal_ZeroCard = (CardView) findViewById(R.id.bal_ZeroCard);
        bal_DeleteCard = (CardView) findViewById(R.id.bal_DeleteCard);
        bal_PeriodCard = (CardView) findViewById(R.id.bal_PeriodCard);

        List<Spinner_Item> itemList = new ArrayList<>();
        itemList.add(new Spinner_Item("Wage", R.drawable.wage));
        itemList.add(new Spinner_Item("Check", R.drawable.check));
        itemList.add(new Spinner_Item("Sale", R.drawable.sale));
        itemList.add(new Spinner_Item("Gift", R.drawable.gift));
        itemList.add(new Spinner_Item("Refund", R.drawable.refund));
        itemList.add(new Spinner_Item("Loan", R.drawable.loan));

        SpinnerAdapter adapter = new SpinnerAdapter(this, itemList);

        Spinner spinner = findViewById(R.id.bal_spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Spinner_Item selectedSpinnerItem = (Spinner_Item) parentView.getItemAtPosition(position);
                String selectedName = selectedSpinnerItem.getItemName();
                String currentDescription = selectedName;
                bal_category.setText(currentDescription);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        bal_OneCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(1);
            }
        });
        bal_TwoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(2);
            }
        });
        bal_ThreeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(3);
            }
        });
        bal_FourCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(4);
            }
        });
        bal_FiveCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(5);
            }
        });
        bal_SixCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(6);
            }
        });
        bal_SevenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(7);
            }
        });
        bal_EightCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(8);
            }
        });
        bal_NineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(9);
            }
        });
        bal_ZeroCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(0);
            }
        });
        bal_PeriodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayAddPeriod(".");
            }
        });
        bal_DeleteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayDelete();
            }
        });

        bal_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bal_ReturnToHome();
            }
        });
    }

    private void bal_ReturnToHome() {
        Intent ToHome = new Intent(this, Home.class);
        startActivity(ToHome);
    }

    public void AddingBalance(View view){
        String RecordHolder = String.valueOf('1');
        String Amount = bal_Display.getText().toString();
        String Date = bal_Date.getText().toString();
        String WhatItIs = "Income";
        String Category = bal_category.getText().toString();
        String Description = bal_description.getText().toString();
        String type = "AddingBalance";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, RecordHolder, Amount, Date, WhatItIs, Category, Description);
    }

    private void DisplayAddPeriod(String period) {
        String currentText = bal_Display.getText().toString();
        bal_Display.setText(currentText + period);
    }

    private void DisplayDelete() {
        String currentText = bal_Display.getText().toString();
        if (currentText.length() > 0) {
            String newText = currentText.substring(0, currentText.length() - 1);
            bal_Display.setText(newText);
        }
    }

    private void DisplayUpdate(int num) {
        String currentText = bal_Display.getText().toString();
        bal_Display.setText(currentText + num);
    }

    public void Balance_Data_Picker(View v) {
        DialogFragment newFragment = new Bal_DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void updateDateTextView(String selectedDate) {
        TextView dateTextView = findViewById(R.id.bal_Date);
        dateTextView.setText(selectedDate);
    }

    private void setCurrentDate() {
        TextView dateTextView = findViewById(R.id.bal_Date);

        // Get the current date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String currentDate = dateFormat.format(calendar.getTime());

        // Set the current date to the TextView
        dateTextView.setText(currentDate);
    }
}