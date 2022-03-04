package com.example.numad22sp_zhaoyangwang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.MalformedURLException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkCollectorButton extends AppCompatActivity {

    FloatingActionButton button;
    TextView lcURL;
    FloatingActionButton floatingActionButton;

    MyApplication myApplication = (MyApplication) this.getApplication();
    List<Item> itemList;

    /**
     * Set up recycler view
     */
    RecyclerView recyclerView;
    // RecyclViewAdapter mAdapter;
    RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector_button);
        itemList = myApplication.getItemList();

        recyclerView = findViewById(R.id.lv_item);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclViewAdapter(itemList, LinkCollectorButton.this);
        recyclerView.setAdapter(mAdapter);


        button = (FloatingActionButton) findViewById(R.id.FloatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinkCollectorAdd();
            }
        });
/**

        if (itemList.size() > 0) {
            lcURL = findViewById(R.id.lc_url);
            lcURL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.youtube.com/");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
            });
        }

        **/
    }

    public void openLinkCollectorAdd() {
        Intent intent = new Intent(this, LinkCollectorAdd.class);
        startActivity(intent);
    }

}


