package com.example.chemistry.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pt-elements.herokuapp.com/api/v1/jsonfile/elements.json/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
