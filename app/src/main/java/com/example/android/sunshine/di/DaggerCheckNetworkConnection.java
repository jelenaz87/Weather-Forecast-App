package com.example.android.sunshine.di;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.android.sunshine.sync.CheckNetworkConnection;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jelena.zivanovic on 12/18/2017.
 */
@Module
public class DaggerCheckNetworkConnection {

    private ConnectivityManager mConnectivityManager;
    private NetworkInfo mNetworkInfo;
    private Context mContext;


    public DaggerCheckNetworkConnection (Context mContext) {
        this.mContext = mContext;
        mConnectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
    }

    @Provides
    Context getmContext () {
        return this.mContext;
    }

    @Provides
    CheckNetworkConnection getCheckNetworkConnectionObject () {
        return new CheckNetworkConnection(mContext);
    }
}
