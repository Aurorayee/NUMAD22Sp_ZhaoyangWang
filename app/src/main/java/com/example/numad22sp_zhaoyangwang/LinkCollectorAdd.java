package com.example.numad22sp_zhaoyangwang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.List;

public class LinkCollectorAdd extends AppCompatActivity {
    Button buttonOK;
    Button buttonCancle;
    EditText URL;
    EditText name;
    ConstraintLayout constraintLayout;
    List<Item> itemList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_added_item);

        buttonOK = findViewById(R.id.ButtonOK);
        buttonCancle = findViewById(R.id.ButtonCancle);
        URL = findViewById(R.id.URLInput);
        name = findViewById(R.id.NameInput);
        itemList = myApplication.getItemList();
        constraintLayout = findViewById(R.id.UserAddedItemPage);

        /**
         * When user click OK button, the info. input to the block would add to the link collector.
         */
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addUrl = URL.getText().toString();
                String addName = name.getText().toString();

                // If the input name or url length equals to 0, remind user to type in the form again. Since name/ url should not be empty
                if (addUrl.length() == 0 || addName.length() == 0) {
                    Snackbar.make(constraintLayout, "Name/ URL empty, please fill in the form again", Snackbar.LENGTH_LONG).show();
                }

                else {
                    Item add = new Item(URL.getText().toString(), name.getText().toString());
                    itemList.add(add);

                    Snackbar.make(constraintLayout, "Add Successful, going to turn back to the main page in a second ..", Snackbar.LENGTH_LONG).show();

                    //  Intent intent = new Intent(LinkCollectorAdd.this, LinkCollectorButton.class);
                    //  startActivity(intent);
                }


            }
        });

        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LinkCollectorAdd.this, LinkCollectorButton.class);
                startActivity(intent);
            }
        });


    }

}