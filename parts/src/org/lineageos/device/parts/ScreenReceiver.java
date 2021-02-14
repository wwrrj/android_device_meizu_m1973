/*
 * Copyright (C) 2020 The MoKee Open Source Project
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package org.lineageos.device.parts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

class ScreenReceiver extends BroadcastReceiver {

    private static final String TAG = "AODScreen";
    private static final boolean DEBUG = false;

    private final AODService mService;

    private final IntentFilter mScreenStateFilter = new IntentFilter();

    private boolean mIsListening = false;

    ScreenReceiver(AODService service) {
        mService = service;
        mScreenStateFilter.addAction(Intent.ACTION_SCREEN_ON);
        mScreenStateFilter.addAction(Intent.ACTION_SCREEN_OFF);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (Intent.ACTION_SCREEN_ON.equals(action)) {
            mService.onDisplayOn();
        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            mService.onDisplayOff();
        }
    }

    void enable() {
        if (mIsListening) return;
        if (DEBUG) Log.d(TAG, "Enabling");
        mService.registerReceiver(this, mScreenStateFilter);
        mIsListening = true;
    }

    void disable() {
        if (!mIsListening) return;
        if (DEBUG) Log.d(TAG, "Disabling");
        mService.unregisterReceiver(this);
        mIsListening = false;
    }

}
