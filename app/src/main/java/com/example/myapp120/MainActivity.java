package com.example.myapp120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void add_expense(View v) {
        Intent i = new Intent(MainActivity.this,expense.class);
        startActivity(i);
    };
    public void budget(View view) {
        Intent i = new Intent(MainActivity.this,budget.class);
        startActivity(i);
    };
    public void report(View view) {
        Intent i = new Intent(MainActivity.this,report.class);
        startActivity(i);
    };
}