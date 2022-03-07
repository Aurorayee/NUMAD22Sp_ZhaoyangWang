package com.example.numad22sp_zhaoyangwang;

import retrofit2.Call;
import com.google.gson.JsonObject;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CurrencyConvertionInterface {
    @GET("v6/dde4114a524fb349bd86ec6d/latest/{currency}")
    Call<JsonObject> getExchangeCurrency(@Path("currency") String currency);
}
