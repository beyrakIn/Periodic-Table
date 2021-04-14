package com.example.chemistry.api;

import com.example.chemistry.api.models.Element;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface AppService {

    @GET
    Call<List<Element>> LIST_CALL(
            @Url String url
    );

    @GET
    Call<Element> ELEMENT_CALL(
            @Url String url
    );

}
