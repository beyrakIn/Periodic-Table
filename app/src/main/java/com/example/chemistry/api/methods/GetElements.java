package com.example.chemistry.api.methods;

import com.example.chemistry.api.AppService;
import com.example.chemistry.api.Config;
import com.example.chemistry.api.models.Element;
import com.example.chemistry.api.models.Git;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class GetElements {
    private AppService appService;

    public Call<List<Element>> getElements() {
        appService = Config.retrofit.create(AppService.class);
        return appService.LIST_CALL("https://pt-api.herokuapp.com/elements/");
    }

    public Call<Element> getElement() {
        final String path = "element/symbol/";
        String element = "H";
        appService = Config.retrofit.create(AppService.class);
        return appService.ELEMENT_CALL("https://neelpatel05.pythonanywhere.com/element/symbol/?symbol=H");
    }


    public Call<Git> gitCall(){
        appService = Config.retrofit.create(AppService.class);
        return appService.GIT_CALL("https://api.github.com/");
    };
}
