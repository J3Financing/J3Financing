package com.example.financetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    CardView AddBalanceCard, AddExpenseCard, HistoryCard, SettingCard, BudgetingCard, StatsCard;
    TextView Balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AddBalanceCard = (CardView) findViewById(R.id.AddBalanceCard);
        AddExpenseCard = (CardView) findViewById(R.id.AddExpenseCard);
        HistoryCard = (CardView) findViewById(R.id.HistoryCard);
        SettingCard = (CardView) findViewById(R.id.SettingCard);
        BudgetingCard = (CardView) findViewById(R.id.BudgetingCard);
        StatsCard = (CardView) findViewById(R.id.StatsCard);
        Balance = (TextView) findViewById(R.id.Balance);
        
        AddBalanceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveToAddBalance();
            }
        });

        AddExpenseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveToAddExpense();
            }
        });
    }

    private void MoveToAddExpense() {
        Intent ToAddExpense = new Intent(this, AddExpense.class);
        startActivity(ToAddExpense);
    }

    private void MoveToAddBalance() {
        Intent ToAddBalance = new Intent(this, AddBalance.class);
        startActivity(ToAddBalance);
    }
}