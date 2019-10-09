package com.guysapp.wallpapers.utils;

import com.guysapp.wallpapers.model.ResponsePixebay;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface endpoints {



    @GET(".")
    Call<ResponsePixebay> getImages(@QueryMap HashMap<String,String> hashMap);
}
