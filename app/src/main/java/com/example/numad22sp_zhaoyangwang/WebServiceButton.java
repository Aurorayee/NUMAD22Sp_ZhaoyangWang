package com.example.numad22sp_zhaoyangwang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiceButton extends AppCompatActivity {

    Spinner currency_from;
    Spinner currency_to;
    EditText amount_input;
    EditText amount_output;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service_button);

        currency_from = findViewById(R.id.webService_convert_from);
        currency_to = findViewById(R.id.webService_convert_to);
        amount_input = findViewById(R.id.webServiceInputAmount);
        amount_output = findViewById(R.id.webServiceResultAmount);
        convert = findViewById(R.id.webServiceConvertButton);

        String[] dropDownList = new String[]{"USD", "AED", "AFN", "ALL", "AMD"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dropDownList);

        currency_to.setAdapter(arrayAdapter);
        currency_from.setAdapter(arrayAdapter);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrencyConvertionInterface currencyConvertionInterface =
                        CurrencyConvertionBuilder.getRetrofitInstance().create(CurrencyConvertionInterface.class);
                Call<JsonObject> call = currencyConvertionInterface.getExchangeCurrency(currency_from.getSelectedItem().toString());
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Log.d("response", String.valueOf(response.body()));
                        JsonObject res = response.body();
                        JsonObject rates = res.getAsJsonObject("conversion_rates");
                        double inputAmount = 0;

                        try {
                            inputAmount = Double.valueOf(amount_input.getText().toString());
                        }
                        catch (Exception e) {
                            Toast.makeText(WebServiceButton.this, "Convert input amount must be int/double type",
                                    Toast.LENGTH_LONG).show();
                        }

                        // If the user input very large number,
                        if (inputAmount >= (int)(1e8)) {
                            Toast.makeText(WebServiceButton.this, "Convert input amount must be less than 1e8",
                                    Toast.LENGTH_LONG).show();
                        }

                        else if (inputAmount < 0) {
                            Toast.makeText(WebServiceButton.this, "Convert input amount cannot be negative",
                                    Toast.LENGTH_LONG).show();
                        }

                        else {
                            double multiplier = Double.valueOf(rates.get(currency_to.getSelectedItem().toString()).toString());
                            double resultToDisplay = inputAmount * multiplier;
                            amount_output.setText(String.valueOf(resultToDisplay));
                        }

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });
            }
        });

    }
}