package com.example.android.sunshine.retrofit;

import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jelena.zivanovic on 12/5/2017.
 */

public class WeatherInfo {


    @SerializedName(OpenWeatherJsonUtils.OWM_TEMPERATURE)
    private TemperatureObject temperatureObject;
    @SerializedName(OpenWeatherJsonUtils.OWM_PRESSURE)
    private double pressure;
    @SerializedName(OpenWeatherJsonUtils.OWM_HUMIDITY)
    private int humidity;
    @SerializedName(OpenWeatherJsonUtils.OWM_WEATHER)
    private ArrayList<WeatherDetail> weatherDetail = new ArrayList<>();
    @SerializedName(OpenWeatherJsonUtils.OWM_WINDSPEED)
    private double windSpeed;
    @SerializedName(OpenWeatherJsonUtils.OWM_WIND_DIRECTION)
    private double windDirection;

    public TemperatureObject getTemperatureObject() {
        return temperatureObject;
    }

    public void setTemperatureObject(TemperatureObject temperatureObject) {
        this.temperatureObject = temperatureObject;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public ArrayList<WeatherDetail> getWeatherDetail() {
        return weatherDetail;
    }

    public void setWeatherDetail(ArrayList<WeatherDetail> weatherDetail) {
        this.weatherDetail = weatherDetail;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }



}
