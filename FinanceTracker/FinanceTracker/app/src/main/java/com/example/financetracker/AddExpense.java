package com.example.financetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AddExpense extends AppCompatActivity {

    Spinner exp_spinner;
    TextView exp_Display, exp_category, exp_Date;
    ImageView exp_return;
    EditText exp_description;
    CardView exp_OneCard, exp_TwoCard, exp_ThreeCard, exp_FourCard, exp_FiveCard, exp_SixCard;
    CardView exp_SevenCard, exp_EightCard, exp_NineCard, exp_ZeroCard, exp_DeleteCard, exp_PeriodCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        setCurrentDate();

        exp_spinner = (Spinner) findViewById(R.id.exp_spinner);

        exp_description = (EditText) findViewById(R.id.exp_Description);

        exp_return = (ImageView) findViewById(R.id.exp_return);

        exp_Display = (TextView) findViewById(R.id.exp_Display);
        exp_Date = (TextView) findViewById(R.id.exp_Date);
        exp_category = (TextView) findViewById(R.id.exp_category);

        exp_OneCard = (CardView) findViewById(R.id.exp_OneCard);
        exp_TwoCard = (CardView) findViewById(R.id.exp_TwoCard);
        exp_ThreeCard = (CardView) findViewById(R.id.exp_ThreeCard);
        exp_FourCard = (CardView) findViewById(R.id.exp_FourCard);
        exp_FiveCard = (CardView) findViewById(R.id.exp_FiveCard);
        exp_SixCard = (CardView) findViewById(R.id.exp_SixCard);
        exp_SevenCard = (CardView) findViewById(R.id.exp_SevenCard);
        exp_EightCard = (CardView) findViewById(R.id.exp_EightCard);
        exp_NineCard = (CardView) findViewById(R.id.exp_NineCard);
        exp_ZeroCard = (CardView) findViewById(R.id.exp_ZeroCard);
        exp_DeleteCard = (CardView) findViewById(R.id.exp_DeleteCard);
        exp_PeriodCard = (CardView) findViewById(R.id.exp_PeriodCard);

        List<Spinner_Item> itemList = new ArrayList<>();
        itemList.add(new Spinner_Item("Grocery", R.drawable.grocery));
        itemList.add(new Spinner_Item("Food/Drinks", R.drawable.foodndrinks));
        itemList.add(new Spinner_Item("Bills", R.drawable.bills));
        itemList.add(new Spinner_Item("Shopping", R.drawable.shopping));
        itemList.add(new Spinner_Item("Transportation", R.drawable.transportation));
        itemList.add(new Spinner_Item("Entertainment", R.drawable.entertainment));
        itemList.add(new Spinner_Item("Others", R.drawable.others));

        SpinnerAdapter adapter = new SpinnerAdapter(this, itemList);

        Spinner spinner = findViewById(R.id.exp_spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Spinner_Item selectedSpinnerItem = (Spinner_Item) parentView.getItemAtPosition(position);
                String selectedName = selectedSpinnerItem.getItemName();
                String currentDescription = selectedName;
                exp_category.setText(currentDescription);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        exp_OneCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(1);
            }
        });
        exp_TwoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(2);
            }
        });
        exp_ThreeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(3);
            }
        });
        exp_FourCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(4);
            }
        });
        exp_FiveCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(5);
            }
        });
        exp_SixCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(6);
            }
        });
        exp_SevenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(7);
            }
        });
        exp_EightCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(8);
            }
        });
        exp_NineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(9);
            }
        });
        exp_ZeroCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayUpdate(0);
            }
        });
        exp_PeriodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayAddPeriod(".");
            }
        });
        exp_DeleteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayDelete();
            }
        });

        exp_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp_ReturnToHome();
            }
        });
    }

    private void exp_ReturnToHome() {
        Intent ToHome = new Intent(this, Home.class);
        startActivity(ToHome);
    }

    public void AddingExpense(View view){
        String RecordHolder = String.valueOf('1');
        String Amount = exp_Display.getText().toString();
        String Date = exp_Date.getText().toString();
        String WhatItIs = "Expense";
        String Category = exp_category.getText().toString();
        String Description = exp_description.getText().toString();
        String type = "AddingBalance";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, RecordHolder, Amount, Date, WhatItIs, Category, Description);
    }

    private void DisplayAddPeriod(String period) {
        String currentText = exp_Display.getText().toString();
        exp_Display.setText(currentText + period);
    }

    private void DisplayDelete() {
        String currentText = exp_Display.getText().toString();
        if (currentText.length() > 0) {
            String newText = currentText.substring(0, currentText.length() - 1);
            exp_Display.setText(newText);
        }
    }

    private void DisplayUpdate(int num) {
        String currentText = exp_Display.getText().toString();
        exp_Display.setText(currentText + num);
    }

    public void Expense_Data_Picker(View v) {
        DialogFragment newFragment = new Exp_DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void updateDateTextView(String selectedDate) {
        TextView dateTextView = findViewById(R.id.exp_Date);
        dateTextView.setText(selectedDate);
    }

    private void setCurrentDate() {
        TextView dateTextView = findViewById(R.id.exp_Date);

        // Get the current date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String currentDate = dateFormat.format(calendar.getTime());

        // Set the current date to the TextView
        dateTextView.setText(currentDate);
    }
}