package com.example.android.sunshine.retrofit;

import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jelena.zivanovic on 12/5/2017.
 */

public class WeatherInfo {

    @SerializedName("main")
    private TemperatureObject temperatureObject;
    @SerializedName(OpenWeatherJsonUtils.OWM_WEATHER)
    private ArrayList<WeatherDetail> weatherDetail = new ArrayList<>();
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("wind")
    private Wind windInfo;
    @SerializedName("dt_txt")
    private String time;

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWindInfo() {
        return windInfo;
    }

    public void setWindInfo(Wind windInfo) {
        this.windInfo = windInfo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }




    public TemperatureObject getTemperatureObject() {
        return temperatureObject;
    }

    public void setTemperatureObject(TemperatureObject temperatureObject) {
        this.temperatureObject = temperatureObject;
    }
    public ArrayList<WeatherDetail> getWeatherDetail() {
        return weatherDetail;
    }

    public void setWeatherDetail(ArrayList<WeatherDetail> weatherDetail) {
        this.weatherDetail = weatherDetail;
    }

}
