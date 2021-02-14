/*
 * Copyright (C) 2020 The MoKee Open Source Project
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package org.lineageos.device.parts;

import android.database.ContentObserver;
import android.provider.Settings;
import android.util.Log;

class SettingObserver extends ContentObserver {

    private static final String TAG = "AODSetting";
    private static final boolean DEBUG = false;

    private final AODService mService;

    private boolean mIsListening = false;

    SettingObserver(AODService service) {
        super(null);
        mService = service;
    }

    @Override
    public void onChange(boolean selfChange) {
        mService.onSettingChange();
    }

    void enable() {
        if (mIsListening) return;
        if (DEBUG) Log.d(TAG, "Enabling");
        mService.getContentResolver().registerContentObserver(
            Settings.Secure.getUriFor(Settings.Secure.DOZE_ALWAYS_ON),
            false, this);
        mIsListening = true;
    }

    void disable() {
        if (!mIsListening) return;
        if (DEBUG) Log.d(TAG, "Disabling");
        mService.getContentResolver().unregisterContentObserver(this);
        mIsListening = false;
    }

}
