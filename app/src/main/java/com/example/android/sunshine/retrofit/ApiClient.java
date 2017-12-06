package com.example.android.sunshine.retrofit;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by jelena.zivanovic on 12/4/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "https://andfun-weather.udacity.com/";
    private static GetClient mGetClient;


    public static GetClient getResponse() {

        if (mGetClient == null) {
            mGetClient = getRetrofit().create(GetClient.class);
        }
        return mGetClient;
    }

    @NonNull
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
