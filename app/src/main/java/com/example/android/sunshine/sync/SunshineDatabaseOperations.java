package com.example.android.sunshine.sync;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;

/**
 * Created by danko.misic on 12/7/17.
 */

public class SunshineDatabaseOperations {

    private Context context;
    /* Get a handle on the ContentResolver to delete and insert data */
    private ContentResolver sunshineContentResolver;

    public SunshineDatabaseOperations(Context context) {
        this.context = context;
        sunshineContentResolver = context.getContentResolver();
    }

    public void insertNewValueIntoDatabase(ContentValues[] weatherValues) {

    /* Delete old weather data because we don't need to keep multiple days' data */
        sunshineContentResolver.delete(
                WeatherContract.WeatherEntry.CONTENT_URI,
                null,
                null);

                /* Insert our new weather data into Sunshine's ContentProvider */
        sunshineContentResolver.bulkInsert(
                WeatherContract.WeatherEntry.CONTENT_URI,
                weatherValues);
    }

}
