package com.example.android.sunshine.sync;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by jelena.zivanovic on 12/8/2017.
 */

public class CheckForEmptyRunnable implements Runnable {

    private SunshineDatabaseOperations operations;
    private Context mContext;
    private SunshineSyncTask.NetworkConnection connection;

    public CheckForEmptyRunnable(Context mContext, SunshineSyncTask.NetworkConnection connection) {
        this.mContext = mContext;
        this.operations = new SunshineDatabaseOperations(mContext);
        this.connection = connection;
    }

    @Override
    public void run() {

       if (operations.checkContentOfDatabase()) {
            startImmediateSync(mContext);
       }
    }

    public void startImmediateSync(@NonNull final Context context) {
        Intent intentToSyncImmediately = new Intent(context, SunshineSyncIntentService.class);
        intentToSyncImmediately.putExtra("this",connection);
        context.startService(intentToSyncImmediately);
    }

}
