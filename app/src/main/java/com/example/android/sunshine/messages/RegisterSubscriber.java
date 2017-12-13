package com.example.android.sunshine.messages;

import com.example.android.sunshine.ui_component.MainActivity;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jelena.zivanovic on 12/13/2017.
 */

public class RegisterSubscriber {

    public static ConcurrentHashMap<Class<?>,MessageEvent > listSubscribers = new ConcurrentHashMap<>();

    public RegisterSubscriber () {

    }

    public void register (Class<?> mClass, MessageEvent event) {
    listSubscribers.put(mClass, event);

    }

    public void unRegister (Class<?> mClass) {
        listSubscribers.remove(mClass);
    }
}
