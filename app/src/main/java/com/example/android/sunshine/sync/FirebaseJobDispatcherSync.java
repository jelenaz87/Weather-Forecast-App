package com.example.android.sunshine.sync;

import android.content.Context;
import android.os.Bundle;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.Driver;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;

import java.util.concurrent.TimeUnit;

/**
 * Created by jelena.zivanovic on 12/7/2017.
 */

public class FirebaseJobDispatcherSync {

    private static final int SYNC_INTERVAL_HOURS = 3;
    private static final int SYNC_INTERVAL_SECONDS = (int) TimeUnit.HOURS.toSeconds(SYNC_INTERVAL_HOURS);
    private static final int SYNC_FLEXTIME_SECONDS = SYNC_INTERVAL_SECONDS / 3;

    private static final String SUNSHINE_SYNC_TAG = "sunshine-sync";

    public Context mContext;

    public FirebaseJobDispatcherSync(Context mContext) {
        this.mContext = mContext;
    }

    public void  scheduleFirebaseJobDispatcherSync(SunshineSyncTask.NetworkConnection connection) {
        Driver driver = new GooglePlayDriver(mContext);
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);
        Bundle bundle = new Bundle();
        bundle.putSerializable("interface",connection);
        /* Create the Job to periodically sync Sunshine */
        Job syncSunshineJob = dispatcher.newJobBuilder()
                /* The Service that will be used to sync Sunshine's data */
                .setService(SunshineFirebaseJobService.class)
                /* Set the UNIQUE tag used to identify this Job */
                .setTag(SUNSHINE_SYNC_TAG)
                /*
                 * Network constraints on which this Job should run. We choose to run on any
                 * network, but you can also choose to run only on un-metered networks or when the
                 * device is charging. It might be a good idea to include a preference for this,
                 * as some users may not want to download any data on their mobile plan. ($$$)
                 */
                .setConstraints(Constraint.ON_ANY_NETWORK)
                /*
                 * setLifetime sets how long this job should persist. The options are to keep the
                 * Job "forever" or to have it die the next time the device boots up.
                 */
                .setLifetime(Lifetime.FOREVER)
                /*
                 * We want Sunshine's weather data to stay up to date, so we tell this Job to recur.
                 */
                .setRecurring(true)
                /*
                 * We want the weather data to be synced every 3 to 4 hours. The first argument for
                 * Trigger's static executionWindow method is the start of the time frame when the
                 * sync should be performed. The second argument is the latest point in time at
                 * which the data should be synced. Please note that this end time is not
                 * guaranteed, but is more of a guideline for FirebaseJobDispatcher to go off of.
                 */
                .setTrigger(Trigger.executionWindow(
                        SYNC_INTERVAL_SECONDS,
                        SYNC_INTERVAL_SECONDS + SYNC_FLEXTIME_SECONDS))
                /*
                 * If a Job with the tag with provided already exists, this new job will replace
                 * the old one.
                 */
                .setReplaceCurrent(true)
                .setExtras(bundle)

                /* Once the Job is ready, call the builder's build method to return the Job */
                .build();

        /* Schedule the Job with the dispatcher */
        dispatcher.schedule(syncSunshineJob);
    }
}
