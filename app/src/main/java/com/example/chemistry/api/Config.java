package com.example.chemistry.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pt-api.herokuapp.com/elements/")
//            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();



}
