package com.example.android.sunshine.sync;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import com.example.android.sunshine.ui_component.MainActivity;

/**
 * Created by jelena.zivanovic on 12/11/2017.
 */

public class CheckNetworkConnection {

   private ConnectivityManager mConnectivityManager;
   private NetworkInfo mNetworkInfo;
   private Context mContext;



   public CheckNetworkConnection (Context context) {
       mContext = context;
       mConnectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
       mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();

   }

   public boolean isNetworkConnectionAvailable (int visibility) {
       if (mNetworkInfo != null) {
           new SunshineSyncUtils().initialize(mContext);
           return true;
       } else {
         if (visibility == View.INVISIBLE) {
          return false;
       } else {
             return  true;
         }
   }
    }
}
