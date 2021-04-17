package com.example.chemistry.api.methods;

import com.example.chemistry.api.AppService;
import com.example.chemistry.api.Config;
import com.example.chemistry.api.models.Element;

import java.util.List;

import retrofit2.Call;

public class GetElements {
    private AppService appService;

    public Call<List<Element>> getElements() {
        appService = Config.retrofit.create(AppService.class);
        return appService.LIST_CALL("https://pt-elements.herokuapp.com/api/v1/jsonfile/elements.json/");
    }

    public Call<Element> getElement() {
        appService = Config.retrofit.create(AppService.class);
        return appService.ELEMENT_CALL("https://pt-elements.herokuapp.com/api/v1/jsonfile/elements.json/");
    }
}
