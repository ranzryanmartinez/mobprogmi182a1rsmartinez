package com.example.block1_part3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    
    Button buttonBlue;

    Button buttonPink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        buttonBlue = (Button) findViewById(R.id.button_blueInvisible);


        buttonPink = new Button(getApplicationContext());

        buttonPink.setText("The Pink Panther's To Do List");
        buttonPink.setTextColor(Color.BLACK);
        buttonPink.setBackgroundColor(Color.parseColor("#FD9BF3")); // light pink

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        layoutParams.addRule(RelativeLayout.BELOW, buttonBlue.getId());

        RelativeLayout relativeLayout_mainScreen = (RelativeLayout) findViewById(R.id.relativeLayout_mainScreen);
        relativeLayout_mainScreen.addView(buttonPink, layoutParams);


        buttonBlue.setOnClickListener(this);
        buttonPink.setOnClickListener(this);
    }


    public void toDo(View v) {
        if (v.equals(buttonBlue))

            v.setVisibility(View.INVISIBLE);
        if (v.equals(buttonPink))

            Toast.makeText(getApplicationContext(),
                    "to do to do to do...",
                    Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        toDo(v);
    }
}