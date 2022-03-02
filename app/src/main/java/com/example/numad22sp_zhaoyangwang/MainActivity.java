package com.example.numad22sp_zhaoyangwang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.numad22sp_zhaoyangwang.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button button1; // About Me
    private Button button2; // Clicky Clicky

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.AboutMe);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutMe();
            }
        });

        button2 = (Button) findViewById(R.id.ClickyClicky);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openClickyClicky();
            }
        });


    }

    public void openAboutMe() {
        Intent intent = new Intent(this, AboutMeButton.class);
        startActivity(intent);
    }

    public void openClickyClicky() {
        Intent intent = new Intent(this, ClickyClickyButton.class);
        startActivity(intent);
    }
}