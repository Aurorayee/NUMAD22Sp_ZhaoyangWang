package com.example.numad22sp_zhaoyangwang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.numad22sp_zhaoyangwang.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutMe();
            }
        });
    }

    public void openAboutMe() {
        Intent intent = new Intent(this, Activity.class);
        startActivity(intent);
    }
}