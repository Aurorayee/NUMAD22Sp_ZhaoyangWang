package com.example.numad22sp_zhaoyangwang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numad22sp_zhaoyangwang.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button button1; // About Me
    private Button button2; // Clicky Clicky
    private Button button3; // Link Collector
    private Button button4; // Locator
    private Button button5; // WebService

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


        button3 = (Button) findViewById(R.id.LinkCollector);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinkCollector();
            }
        });

        button4 = (Button) findViewById(R.id.Locatorbutton);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLocator();
            }
        });

        button5 = findViewById(R.id.webServiceButton);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebService();
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

    public void openLinkCollector() {
        Intent intent = new Intent(this, LinkCollectorButton.class);
        startActivity(intent);
    }

    public void openLocator() {
        Intent intent = new Intent(this, Locator.class);
        startActivity(intent);
    }

    public void openWebService() {
        Intent intent = new Intent(this, WebServiceButton.class);
        startActivity(intent);
    }

}