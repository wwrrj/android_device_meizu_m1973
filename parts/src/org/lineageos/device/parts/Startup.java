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
import android.os.UserHandle;

import static lineageos.content.Intent.ACTION_INITIALIZE_LINEAGE_HARDWARE;

public class Startup extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (ACTION_INITIALIZE_LINEAGE_HARDWARE.equals(action)) {
            context.startServiceAsUser(
                    new Intent(context, AODService.class),
                    UserHandle.CURRENT);
        }
    }

}
