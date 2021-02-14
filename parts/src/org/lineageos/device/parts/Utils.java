/*
 * Copyright (C) 2020 The MoKee Open Source Project
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package org.lineageos.device.parts;

import android.content.Context;
import android.provider.Settings;

import com.android.internal.R;

class Utils {

    static boolean isAODEnabled(Context context) {
        final boolean alwaysOnByDefault = context.getResources()
                .getBoolean(R.bool.config_dozeAlwaysOnEnabled);

        return Settings.Secure.getInt(context.getContentResolver(),
                Settings.Secure.DOZE_ALWAYS_ON,
                alwaysOnByDefault ? 1 : 0) != 0;
    }

}
