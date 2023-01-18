/*
 * Copyright (C) 2022 SuperiorOS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.awaken.lab.fragments;

import com.android.internal.logging.nano.MetricsProto;

import android.os.Bundle;
import android.content.Context;
import com.android.settings.R;

import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

import com.android.settings.SettingsPreferenceFragment;

public class NotificationSettings extends SettingsPreferenceFragment {

    private static final String KEY_BATTERY_CHARGING_LIGHT = "battery_charging_light";
    
    Preference mBatteryLightPref;
    PreferenceScreen prefSet;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        addPreferencesFromResource(R.xml.awaken_lab_notifications);
        
        mBatteryLightPref = (Preference) findPreference(KEY_BATTERY_CHARGING_LIGHT);
        prefSet = getPreferenceScreen();
        if (!getResources()
                .getBoolean(com.android.internal.R.bool.config_intrusiveBatteryLed))
        {
			if (mBatteryLightPref != null) {
				prefSet.removePreference(mBatteryLightPref);
			}
        }

    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.AWAKEN;
    }
}
