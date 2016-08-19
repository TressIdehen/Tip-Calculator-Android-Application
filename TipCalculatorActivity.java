package com.example.tressidehen.tipcalculator;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    public  EditText Price;
    public  SeekBar Tip_Percentage;
    public  TextView Tip_Info;
    public  SeekBar Split_Number;
    public  TextView Split_Info;
    public  TextView All_Tip_Calc;
    public  TextView User_Tip_Calc;
    public  TextView User_Price_Total;
    public  TextView All_Price_Total;
    public  Button Calculate_Total;
    public  Integer Tip_Progress_Value;
    public  Integer People_Count_Total;
    public  Double Total_Tip;
    public  Double Total_Price;
    public  Double Percent_Calculator;
    public  Double People;
    public  Double Individual_Tip;
    public  Double Individual_Total;
    public  Double Cost;
    public  Double Percent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        Tip_Calculator();

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        getSupportActionBar().setTitle(R.string.My_App_Title);
        getSupportActionBar().setIcon(R.drawable.toolbar_clipart);
        getSupportActionBar().setSubtitle(R.string.My_App_Subtitle);

    }


    public void Tip_Calculator() {


        //entire objects casted
        Price = (EditText) findViewById(R.id.total_Bill);//this is the user edit enter info
        Tip_Percentage = (SeekBar) findViewById(R.id.tipBar);//this is the percentage seekBar of tip user want to give max at 30%
        Tip_Info = (TextView) findViewById(R.id.tipPercent);//this is the display text of that percent tip seekBar
        Tip_Info.setText(Tip_Percentage.getProgress() + "%");
        Split_Number = (SeekBar) findViewById(R.id.peopleBar);//this is the slide bar for the num of people sharing the bill max at 24 people
        Split_Info = (TextView) findViewById(R.id.splitNumber);//this is the display text for that slide bar count of people splitting bill
        Split_Info.setText("People: " + Split_Number.getProgress() + "/" + Split_Number.getMax());
        All_Tip_Calc = (TextView) findViewById(R.id.totalTipNum);//this is the display text for the total amount of tip based off user entry
        User_Tip_Calc = (TextView) findViewById(R.id.individualTipNum);//this is the display text for the individual amount off tip calculated based of user entry
        User_Price_Total = (TextView) findViewById(R.id.individualTip_Bill);//the amount each individual will have to pay including tip calc result
        All_Price_Total = (TextView) findViewById(R.id.totalTip_Bill);//group tip and bill total, should match the initial entry of the total bill
        Calculate_Total = (Button) findViewById(R.id.calculateBtn);//this button calculate the entire thing




        Tip_Percentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {//the tip percent selector
            @Override
            public void onProgressChanged(SeekBar seekBar, int Progress, boolean b) {//on start key progress bar

                Tip_Progress_Value = Progress;
                Tip_Info.setText(Progress + "%");



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {//during tip progress bar press

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {//on tip progress bar stop

                Tip_Info.setText(Tip_Progress_Value + "%");
                Percent = Double.valueOf((Tip_Progress_Value / 100.00));
            }
        });




        Split_Number.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {//the number of people selector
            @Override
            public void onProgressChanged(SeekBar seekBar, int People_Count, boolean b) {
                People_Count_Total = People_Count;//converts the slide icon value into a variable i can call on later

                Split_Info.setText("People: " + People_Count + "/" + Split_Number.getMax());// display info

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Split_Info.setText("People: " + People_Count_Total + "/" + Split_Number.getMax());
                People = Double.valueOf(People_Count_Total / 1.00);// this particular code i use to mathematical equation to convert the int into a double!
            }
        });


        Calculate_Total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Mathematics();

                All_Price_Total.setText(Total_Price.toString());//print out to visible string format
                User_Tip_Calc.setText(Individual_Tip.toString());//print out
                User_Price_Total.setText(Individual_Total.toString());//print out
                All_Tip_Calc.setText(Total_Tip.toString());//print out




            }
        });


    }

    public void Mathematics() {
        String Money = Price.getText().toString();//this code collects the text inputed on to the Edittext field of the price object
        Cost = Double.valueOf(Money);//this code converts that string text collected above into a double value
        Total_Tip = Cost * Percent;//operation
        Total_Price = Cost + Total_Tip;//operation
        Individual_Tip = Total_Tip / People;//operation
        Individual_Total = Total_Price / People;//operation



    }
}
