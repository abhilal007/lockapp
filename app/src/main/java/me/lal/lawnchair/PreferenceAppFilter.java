package me.lal.lawnchair;

import android.content.ComponentName;
import android.content.Context;

import me.lal.lawnchair.preferences.IPreferenceProvider;
import me.lal.lawnchair.preferences.IPreferenceProvider;
import me.lal.lawnchair.preferences.IPreferenceProvider;

public class PreferenceAppFilter implements AppFilter {

    @Override
    public boolean shouldShowApp(ComponentName app, Context context) {
        if (app.getPackageName().equals(context.getPackageName()))
            return false;
        IPreferenceProvider prefs = Utilities.getPrefs(context);
        return prefs.getShowHidden() || !Utilities.isAppHidden(context, app.flattenToString());
    }
}
