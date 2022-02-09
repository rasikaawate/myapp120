package com.example.myapp120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class expense extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

    }
    public void addExpense(View view){
        SharedPreferences pref = getSharedPreferences("Expendify", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String title, category, comment;
        float amount= 0.0f;
        EditText etitle = (EditText) findViewById(R.id.txtTitle);
        EditText ecategory = (EditText) findViewById(R.id.txtCategory);
        EditText ecomment = (EditText) findViewById(R.id.txtComment);
        EditText eamount = (EditText) findViewById(R.id.txtAmount);
        title = etitle.getText().toString();
        category = ecategory.getText().toString();
        comment = ecomment.getText().toString();
        amount = Float.parseFloat(eamount.getText().toString());
        editor.putString("ae_title",title);
        editor.putString("ae_category",category);
        editor.putString("ae_comment",comment);
        editor.putFloat("ae_amount",amount);

        if (pref.contains("total_expenses"))
        {
            float te = pref.getFloat("total_expenses",0.0f);
            te = te + amount;
            editor.putFloat("total_expenses", te);
        }
        else
        editor.putFloat("total_expenses", amount);

        editor.apply();

        String t, c, cm;
        float am=0.0f;
        t= pref.getString("ae_title", null);
        c= pref.getString("ae_category", null);
        cm= pref.getString("ae_comment", null);
        am= pref.getFloat("ae_amount",0.0f);
        Toast.makeText(this, "title: "+t+"\n"+c+"\n" + cm +"\n" + am, Toast.LENGTH_SHORT).show();


    }
}