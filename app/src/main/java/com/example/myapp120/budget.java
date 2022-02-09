package com.example.myapp120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class budget extends AppCompatActivity {
    float bdamount, total_expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        displaychart();
    }
    public void addbudget(View v){
        SharedPreferences pref = getSharedPreferences("Expendify", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        EditText ebudget = (EditText) findViewById(R.id.editTextTextPersonName);
        bdamount = Float.parseFloat(ebudget.getText().toString());
        editor.putFloat("bd_budget", bdamount);
        editor.apply();
        Toast.makeText(this, pref.getFloat("bd_amount", 0.0f) + "", Toast.LENGTH_SHORT).show();
    }
        public  void displaychart(){
            SharedPreferences pref = getSharedPreferences("Expendify", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            total_expenses = pref.getFloat("total_expense",0.0f);
            PieChart mPieChart = (PieChart) findViewById(R.id.piechart);

            mPieChart.addPieSlice(new PieModel("total expense", total_expenses, Color.parseColor("#CDA67F")));
            mPieChart.addPieSlice(new PieModel("remaining", bdamount-total_expenses, Color.parseColor("#FED70E")));

            mPieChart.startAnimation();
        }


    }