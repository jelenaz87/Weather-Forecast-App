package com.example.android.sunshine;

import android.content.ContentValues;

import com.example.android.sunshine.utilities.NetworkUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by jelena.zivanovic on 12/4/2017.
 */

public interface GetResponse {

 //   Call<WeatherObject>getWeatherObject(@Url String url);
    @GET ("staticweather")
   Call<WeatherObject> getWeatherObject(@Query(NetworkUtils.QUERY_PARAM) String location,
                                        @Query(NetworkUtils.FORMAT_PARAM) String format,
                        @Query(NetworkUtils.UNITS_PARAM) String units,
                        @Query(NetworkUtils.DAYS_PARAM) String days);
}
