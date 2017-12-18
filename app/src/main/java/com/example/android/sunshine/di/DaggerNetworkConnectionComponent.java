package com.example.android.sunshine.di;

import com.example.android.sunshine.ui_component.MainActivity;

import dagger.Component;

/**
 * Created by jelena.zivanovic on 12/18/2017.
 */
@Component (modules = {DaggerCheckNetworkConnection.class})
public interface DaggerNetworkConnectionComponent {
    void inject (MainActivity mainActivity);
}
