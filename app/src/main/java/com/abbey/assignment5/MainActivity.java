package com.abbey.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    String msg;

    final DecimalFormat decFormat = new DecimalFormat("0.00");

    public String KmToMiles(double value){
        double Message = (value * 0.62173);
        if (Message>1){
            msg = " Miles";
        }else{
            msg = " Mile";
        }

        String result = decFormat.format(Message);
        return result;
    }

    public String MilesToKm(double value){
        double Message = (value * 1.62173);
        if (Message>1){
            msg = " Kilometers";
        }else{
            msg = " Kilometer";
        }
        String result = decFormat.format(Message);
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit_KM = findViewById(R.id.edit_KM);
        final EditText edit_Miles = findViewById(R.id.edit_Miles);
        final TextView result = findViewById(R.id.result);


        //KmToMiles
        edit_KM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    double value = Double.parseDouble(s.toString());
                    result.setText(KmToMiles(value) + msg);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //MilesToKm
        edit_Miles.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    double value = Double.parseDouble(s.toString());
                    result.setText(MilesToKm(value) + msg);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}

