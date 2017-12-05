package com.example.android.sunshine;

import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jelena.zivanovic on 12/5/2017.
 */

public class TemperatureObject {

    public  TemperatureObject() {

    }


    @SerializedName(OpenWeatherJsonUtils.OWM_MAX)
    private double maxTemperature;
    @SerializedName(OpenWeatherJsonUtils.OWM_MIN)
    private double minTemperature;

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }
}
