package com.example.numad22sp_zhaoyangwang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ClickyClickyButton extends AppCompatActivity {

    private Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF;
    private TextView textView;
    private int screenDirection = 1; // Whether the current screen is LANDSCAPE/ PORTRAIT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicky_clicky_button);
        textView = (TextView) findViewById(R.id.CCTextView);

        Button buttonA = (Button) findViewById(R.id.CCButtonA);
        Button buttonB = (Button) findViewById(R.id.CCButtonB);
        Button buttonC = (Button) findViewById(R.id.CCButtonC);
        Button buttonD = (Button) findViewById(R.id.CCButtonD);
        Button buttonE = (Button) findViewById(R.id.CCButtonE);
        Button buttonF = (Button) findViewById(R.id.CCButtonF);


        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Pressed: A");
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Pressed: B");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Pressed: C");
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Pressed: D");
            }
        });

        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Pressed: E");
            }
        });

        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Pressed: F");
            }
        });

        if (getResources().getConfiguration().orientation != screenDirection) {
            screenDirection = getResources().getConfiguration().orientation;
            setDefaultPressed(textView);
        }
    }

    public void setDefaultPressed(TextView textView) {
        textView.setText("Pressed: -");
    }
}