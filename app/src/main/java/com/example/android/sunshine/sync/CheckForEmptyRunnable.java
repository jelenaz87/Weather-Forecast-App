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

    public CheckForEmptyRunnable(Context mContext) {
        this.mContext = mContext;
        operations = new SunshineDatabaseOperations(mContext);
    }

    @Override
    public void run() {

       if (new CheckForEmptyRunnable(mContext).operations.checkContentOfDatabase()) {
            startImmediateSync(mContext);
       }
    }

    public static void startImmediateSync(@NonNull final Context context) {
        Intent intentToSyncImmediately = new Intent(context, SunshineSyncIntentService.class);
        context.startService(intentToSyncImmediately);
    }

}
