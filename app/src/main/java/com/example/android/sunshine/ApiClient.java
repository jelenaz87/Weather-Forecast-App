package com.example.android.sunshine;

import com.example.android.sunshine.utilities.NetworkUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by jelena.zivanovic on 12/4/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "https://andfun-weather.udacity.com/";
    private  GetResponse mGetResponse;




    public  GetResponse getResponse() {

       if (mGetResponse==null) {

           Retrofit retrofit =  new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

          mGetResponse = retrofit.create(GetResponse.class);
        }
        return mGetResponse;
    }
}
